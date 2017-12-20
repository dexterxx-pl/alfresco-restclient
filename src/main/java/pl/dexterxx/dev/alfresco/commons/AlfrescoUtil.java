package pl.dexterxx.dev.alfresco.commons;

import java.text.ParseException;

/**
 * Helpers related to Alfresco.
 *
 * @author Kamil Komorek (admin@dexterxx.pl)
 */
public class AlfrescoUtil {

    /**
     * Extracts ticket value from response like:
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;
     * &lt;ticket&gt;TICKET_d7657a7fbda43152d59920faecadf7049ff0e996&lt;/ticket&gt;
     * </pre>
     * TODO(dexterxx) think about it does include JAXB would not be better / make it better
     *
     * @param xml full xml response
     * @return extracted content wrapped in xml's ticket tag
     * @throws ParseException when ticket value cannot be resolved
     */
    public static String extractTicketFromXml(String xml) throws ParseException {
        try {
            return xml.substring(
                    xml.indexOf("<ticket>TICKET_") + "<ticket>".length(),
                    xml.indexOf("</ticket>")
            );
        } catch (Exception e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    /**
     * Extract's path like "workspace://SpacesStore/6fcfe1dd-da4a-4770-b731-79cb4c808cc9" to atomic.
     *
     * @param fullStorePath full store path with storeType://storeId/nodeId
     * @return extracted path
     */
    public static AlfrescoStorePath extractPath(String fullStorePath) {
        int firstSep = fullStorePath.indexOf("://");
        int lastSep = fullStorePath.lastIndexOf("/");

        AlfrescoStorePath alfrescoStorePath = new AlfrescoStorePath();

        alfrescoStorePath.storeType = fullStorePath.substring(0, firstSep);
        alfrescoStorePath.storeId = fullStorePath.substring(firstSep + 3, lastSep);
        alfrescoStorePath.nodeId = fullStorePath.substring(lastSep + 1);

        return alfrescoStorePath;
    }

    public static class AlfrescoStorePath {
        public String storeType;
        public String storeId;
        public String nodeId;
    }
}
