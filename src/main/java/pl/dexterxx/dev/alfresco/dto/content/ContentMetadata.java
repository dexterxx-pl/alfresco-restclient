package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class ContentMetadata.
 */
public class ContentMetadata extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -824034451981584819L;

    /**
     * The properties.
     */
    @JsonProperty("properties")
    private Map<String, String> properties = new HashMap<String, String>();

    /**
     * The mimetype.
     */
    @JsonProperty("mimetype")
    private String mimetype;

    /**
     * The tags.
     */
    @JsonProperty("tags")
    private List<String> tags;

    /**
     * Gets the properties.
     *
     * @return the properties
     */
    public Map<String, String> getProperties() {
        return properties;
    }

    /**
     * Sets the properties.
     *
     * @param properties the properties
     */
    public void setProperties(final Map<String, String> properties) {
        this.properties = properties;
    }

    /**
     * Gets the mimetype.
     *
     * @return the mimetype
     */
    public String getMimetype() {
        return mimetype;
    }

    /**
     * Sets the mimetype.
     *
     * @param mimetype the new mimetype
     */
    public void setMimetype(final String mimetype) {
        this.mimetype = mimetype;
    }

    /**
     * Gets the tags.
     *
     * @return the tags
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Sets the tags.
     *
     * @param tags the new tags
     */
    public void setTags(final List<String> tags) {
        this.tags = tags;
    }

    /**
     * Adds the tag.
     *
     * @param value the value
     */
    public void addTag(final String value) {
        if (tags == null) {
            tags = new ArrayList<String>();
        }
        tags.add(value);
    }

    /**
     * Adds the property.
     *
     * @param name  the name
     * @param value the value
     */
    public void addProperty(final String name, final String value) {
        properties.put(name, value);
    }

}
