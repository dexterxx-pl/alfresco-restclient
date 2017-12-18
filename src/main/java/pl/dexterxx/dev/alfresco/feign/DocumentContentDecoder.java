package pl.dexterxx.dev.alfresco.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dexterxx.dev.alfresco.commons.HeadersUtil;
import pl.dexterxx.dev.alfresco.dto.content.DocumentContent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

/**
 * Equivalent of DocumentContentProvider before fork.
 * Download's alfresco content file into temp directory and returns local handler to it.
 * TODO(dexterxx) specified cache configuration, refactor, more commons?
 *
 * @author Kamil Komorek (admin@dexterxx.pl)
 */
public class DocumentContentDecoder implements Decoder {

    /**
     * The Constant logger.
     */
    private final static Logger logger = LoggerFactory.getLogger(DocumentContentDecoder.class);

    /**
     * The Constant PREFIX.
     */
    private static final String PREFIX = "dms";

    /**
     * The Constant SUFFIX.
     */
    private static final String SUFFIX = "file";

    private static final String HEADER_FILENAME_REGEXP = "(?i)^.*filename=\"?([^\"]+)\"?.*$";

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {

        if (type != DocumentContent.class) {
            throw new DecodeException(format("%s is not a type supported by this decoder.", type));
        }
        String contentType = HeadersUtil.findContentType(response.headers())
                .orElseThrow(() -> new IOException("Content-type must be specified"));

        Optional<String> filename = getContentDispositionFilename(response.headers());
        MediaType mediaType = MediaType.parse(contentType);

        final DocumentContent documentContent = new DocumentContent();
        String prefix = null;
        String suffix;
        if (filename.isPresent()) {
            suffix = getFileSuffix(filename.get(), mediaType);
            prefix = getFilePrefix(filename.get());
        } else {
            logger.warn("Content Disposition header not found in response. All the attributes DocumentContent instance won't be populated.");
            suffix = getFileSuffix(mediaType);
        }
        if (StringUtils.isBlank(prefix)) {
            prefix = PREFIX;
        }
        if (StringUtils.isBlank(suffix)) {
            suffix = "." + SUFFIX;
        }

        File downloadedFile = File.createTempFile(prefix, suffix);

        try (
                final OutputStream output = new BufferedOutputStream(new FileOutputStream(downloadedFile))
        ) {
            IOUtils.copy(response.body().asInputStream(), output);
        }
        documentContent.setDocFile(downloadedFile);

        return documentContent;
    }

    private Optional<String> getContentDispositionFilename(Map<String, Collection<String>> headers) {
        Optional<String> contentDisposition = HeadersUtil.findFirstHeaderValueIgnoreCase(headers,
                HttpHeaders.CONTENT_DISPOSITION);

        // https://stackoverflow.com/a/27226712
        return contentDisposition
                .map(value -> value.replaceFirst(HEADER_FILENAME_REGEXP, "$1"));
    }

    /**
     * Gets the file prefix.
     *
     * @param filename the filename of content
     * @return the file prefix
     */
    private String getFilePrefix(final String filename) {
        return StringUtils.substringBeforeLast(filename, ".");
    }

    /**
     * Gets the file suffix.
     *
     * @param filename  the filename of content
     * @param mediaType the media type
     * @return the file suffix
     */
    private String getFileSuffix(final String filename,
                                 final MediaType mediaType) {
        return getFileSuffix(mediaType, filename);
    }

    /**
     * Gets the file suffix.
     *
     * @param mediaType the media type
     * @return the file suffix
     */
    private String getFileSuffix(final MediaType mediaType) {
        return getFileSuffix(mediaType, null);
    }

    /**
     * Gets the file suffix.
     *
     * @param mediaType the media type
     * @param fileName  the file name
     * @return the file suffix
     */
    private String getFileSuffix(final MediaType mediaType, final String fileName) {
        String suffix = StringUtils.substringAfterLast(fileName, ".");
        if (StringUtils.isNotBlank(suffix)) {
            suffix = "." + suffix;
        } else {
            final String mediaSubtype = StringUtils.defaultString(mediaType.getSubtype());
            suffix = getFileExtension(getHttpMimeType(mediaType), mediaSubtype);
        }
        return suffix;
    }

    /**
     * Gets the http mime type.
     *
     * @param mediaType the media type
     * @return the http mime type
     */
    private String getHttpMimeType(final MediaType mediaType) {
        return mediaType.getType() + "/" + mediaType.getSubtype();
    }

    /**
     * Gets the file extension.
     *
     * @param mimeType         the mime type
     * @param defaultExtension the default extension
     * @return the file extension
     */
    private String getFileExtension(final String mimeType, final String defaultExtension) {
        final TikaConfig config = TikaConfig.getDefaultConfig();
        final MimeTypes allTypes = config.getMimeRepository();
        MimeType contentType = null;
        try {
            contentType = allTypes.forName(mimeType);
        } catch (final MimeTypeException mte) {
            logger.error("An error occurred while getting extension mapping against mime: " + mimeType, mte);
        }
        if (contentType != null) {
            return contentType.getExtension();
        }
        logger.error("UNABLE TO GET EXTENSION AGAINST MIMETYPE '" + mimeType + "'. RETURNING EXTENSION VALUE SAME AS MIMETYPE.");
        return "." + defaultExtension;
    }
}
