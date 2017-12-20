package pl.dexterxx.dev.alfresco.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import pl.dexterxx.dev.alfresco.dto.Timestamp;
import pl.dexterxx.dev.alfresco.dto.util.AlfrescoDtoUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * The Class ISO8601DateDeserializer.
 */
public class ISO8601DateDeserializer extends JsonDeserializer<Date> {

    /*
     * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
     * org.codehaus.jackson.map.DeserializationContext)
     */
    @Override
    public Date deserialize(final JsonParser jsonparser,
                            final DeserializationContext deserializationcontext) throws IOException {
        final Timestamp timestamp = jsonparser.readValueAs(Timestamp.class);
        if (timestamp == null || StringUtils.isBlank(timestamp.getIso8601())) {
            return null;
        }
        final String dateString = timestamp.getIso8601();
        try {
            return AlfrescoDtoUtil.parseISO8601Date(dateString);
        } catch (final ParseException parseException) {
            throw new IOException("Error occurred while parsing date '"
                    + dateString + "'", parseException);
        }
    }

}
