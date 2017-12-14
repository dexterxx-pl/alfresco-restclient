alfresco-restclient
===================

Rest client written in Java 8 to consume Alfresco RESTful services based on OpenFeign.

It's fork of [techblue/alfresco-restclient](https://github.com/techblue/alfresco-restclient) project which:
* Migrates from RestEasy to [OpenFeign](https://github.com/OpenFeign/feign)
* Migrates from JDK7 to JDK8
* Updates Jackson Mapper from 1.9 to 2.9
* Changes JBoss logging to SFL4J bridge
* [TODO] Migrates test to real unit tests
* Makes some freshness, cleanup etc. ;)

## Maven and releases

Not published yet and it's **not ready for production** use, be patient.

## How to use (beta)

```java

final String alfrescoUrl = "http://my-alfresco-host";

final String alfrescoUser = "alfresco-user";

final String alfrescoPass = "alfresco-password";

private void makeSomeStuff() {

    Credentials credentials = new Credentials(alfrescoUser, alfrescoPass);

    // Create AuthService which logins and logouts in Alfresco
    AuthService authService = new AuthService(alfrescoUrl, credentials);

    AuthResponse authResponse = authService.login();
    String token = authResponse.getAuthenticationData().getAuthenticationToken();

    // Let's get node with our token
    String filePath = "workspace://SpacesStore/6cffe1dd-d4aa-4770-b371-7c9b4c808cc9";
    AlfrescoUtils.AlfrescoStorePath alfPath = AlfrescoUtils.extractPath(filePath);

    DocumentContent nodeContent = new ContentService(alfrescoUrl, token)
        .getNodeContent(alfPath.storeType, alfPath.storeId, alfPath.nodeId);
    
    // so easy!
}

```