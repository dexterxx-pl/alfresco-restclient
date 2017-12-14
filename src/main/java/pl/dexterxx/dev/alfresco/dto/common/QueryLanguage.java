package pl.dexterxx.dev.alfresco.dto.common;

/**
 * The Enum QueryLanguage.
 */
public enum QueryLanguage {

    /**
     * The lucene.
     */
    LUCENE("lucene"),

    /**
     * The xpath.
     */
    XPATH("xpath"),

    /**
     * The jcr xpath.
     */
    JCR_XPATH("jcr-xpath"),

    /**
     * The fts alfresco.
     */
    FTS_ALFRESCO("fts-alfresco");

    /**
     * The name.
     */
    private String name;

    /**
     * Instantiates a new query language.
     *
     * @param name the name
     */
    private QueryLanguage(final String name) {
        this.name = name;
    }

    /* 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return name;
    }

}
