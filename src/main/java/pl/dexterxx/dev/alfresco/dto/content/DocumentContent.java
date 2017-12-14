package pl.dexterxx.dev.alfresco.dto.content;

import pl.dexterxx.dev.alfresco.dto.BaseDto;

import java.io.File;

/**
 * The Class DocumentContent.
 */
public class DocumentContent extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 7947888264561168246L;

    /**
     * The doc file.
     */
    private File docFile;

    /**
     * Gets the doc file.
     *
     * @return the doc file
     */
    public File getDocFile() {
        return docFile;
    }

    /**
     * Sets the doc file.
     *
     * @param docFile the new doc file
     */
    public void setDocFile(final File docFile) {
        this.docFile = docFile;
    }
}
