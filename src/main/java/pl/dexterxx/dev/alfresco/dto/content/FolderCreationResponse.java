package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

/**
 * FolderCreationResponse.java
 *
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class FolderCreationResponse extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4774217252641874172L;

    /**
     * The name.
     */
    private String name;

    /**
     * The object id.
     */
    private String objectId;

    /**
     * The node reference.
     */
    @JsonProperty("nodeRef")
    private String nodeReference;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the object id.
     *
     * @return the object id
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     * Sets the object id.
     *
     * @param objectId the new object id
     */
    public void setObjectId(final String objectId) {
        this.objectId = objectId;
    }

    /**
     * Gets the node reference.
     *
     * @return the node reference
     */
    public String getNodeReference() {
        return nodeReference;
    }

    /**
     * Sets the node reference.
     *
     * @param nodeReference the new node reference
     */
    public void setNodeReference(final String nodeReference) {
        this.nodeReference = nodeReference;
    }

}
