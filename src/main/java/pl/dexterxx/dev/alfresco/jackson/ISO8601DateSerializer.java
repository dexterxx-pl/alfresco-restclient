package pl.dexterxx.dev.alfresco.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.dexterxx.dev.alfresco.dto.util.AlfrescoDtoUtil;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * The Class ISO8601DateSerializer.
 */
public class ISO8601DateSerializer extends JsonSerializer<Date> {

    /*
     * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator,
     * org.codehaus.jackson.map.SerializerProvider)
     */
    @Override
    public void serialize(final Date value, final JsonGenerator jgen,
                          final SerializerProvider provider) throws IOException {
        try {
            final String dateString = AlfrescoDtoUtil.formatISO8601Date(value);
            jgen.writeString(dateString);
        } catch (final ParseException pe) {
            throw new IOException(
                    "Error occurred while formatting date to ISO8601 format",
                    pe);
        }
    }

}
