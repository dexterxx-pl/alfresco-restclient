package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

/**
 * The Class QueryResponseSorter.
 */
public class QueryResponseSorter extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -5269615411978334553L;

    /**
     * The column name.
     */
    @JsonProperty("column")
    private String columnName;

    /**
     * The ascending.
     */
    @JsonProperty("ascending")
    private boolean ascending;

    /**
     * Gets the column name.
     *
     * @return the column name
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Sets the column name.
     *
     * @param columnName the new column name
     */
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    /**
     * Checks if is ascending.
     *
     * @return true, if is ascending
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * Sets the ascending.
     *
     * @param ascending the new ascending
     */
    public void setAscending(final boolean ascending) {
        this.ascending = ascending;
    }

}
