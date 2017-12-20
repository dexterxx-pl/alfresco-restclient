package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

/**
 * The Class PagingConfig.
 */
public class PagingConfig extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -4814175523989306623L;

    /**
     * The max items.
     */
    @JsonProperty("maxItems")
    private int maxItems;

    /**
     * The skip count.
     */
    @JsonProperty("skipCount")
    private int skipCount;

    /**
     * Gets the max items.
     *
     * @return the max items
     */
    public int getMaxItems() {
        return maxItems;
    }

    /**
     * Sets the max items.
     *
     * @param maxItems the new max items
     */
    public void setMaxItems(final int maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * Gets the skip count.
     *
     * @return the skip count
     */
    public int getSkipCount() {
        return skipCount;
    }

    /**
     * Sets the skip count.
     *
     * @param skipCount the new skip count
     */
    public void setSkipCount(final int skipCount) {
        this.skipCount = skipCount;
    }

}
