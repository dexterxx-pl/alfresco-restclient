package pl.dexterxx.dev.alfresco.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Map;

/**
 * The Class UnquoteCharacterEscapeDeserializer.
 */
public class UnquoteCharacterEscapeDeserializer extends JsonDeserializer<Map<String, String>> {

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
     * org.codehaus.jackson.map.DeserializationContext)
     */
    @Override
    public Map<String, String> deserialize(final JsonParser jsonparser, final DeserializationContext ctxt) throws IOException {
        return jsonparser.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true).readValueAs(new TypeReference<Map<String, String>>() {
        });
    }

}
