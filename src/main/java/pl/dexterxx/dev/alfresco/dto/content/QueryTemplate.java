package pl.dexterxx.dev.alfresco.dto.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.dexterxx.dev.alfresco.dto.BaseDto;

/**
 * The Class QueryTemplate.
 */
public class QueryTemplate extends BaseDto {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -1213291462198257552L;

    /**
     * The field name.
     */
    @JsonProperty("field")
    private String fieldName;

    /**
     * The template.
     */
    @JsonProperty("template")
    private String template;

    /**
     * Gets the field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the field name. See <a href=
     * "http://docs.alfresco.com/4.0/index.jsp?topic=%2Fcom.alfresco.enterprise.doc%2Fconcepts%2Frm-searchsyntax-querytemplates.html"
     * >this</a> link for details.
     *
     * @param fieldName the new field name
     */
    public void setFieldName(final String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets the template.
     *
     * @return the template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Sets the query template. See <a href=
     * "http://docs.alfresco.com/4.0/index.jsp?topic=%2Fcom.alfresco.enterprise.doc%2Fconcepts%2Frm-searchsyntax-querytemplates.html"
     * >this</a> link for details.
     *
     * @param template the new template
     */
    public void setTemplate(final String template) {
        this.template = template;
    }

}
