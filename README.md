alfresco-restclient
===================

Rest client written in Java 8 with OpenFeign to consume Alfresco RESTful services.

It's fork of [techblue/alfresco-restclient](https://github.com/techblue/alfresco-restclient) project which:
* Migrates from RestEasy to [OpenFeign](https://github.com/OpenFeign/feign)
* Migrates from JDK7 to JDK8
* Updates Jackson Mapper from 1.9 to 2.9
* Changes JBoss logging to SFL4J bridge
* [TODO] Migrates test to real unit tests
* Makes some freshness, cleanup etc. ;)

**It may not be compatible with base project** and don't expect it will ever be.

Tested (and used right now) only with Alfresco 4.2 version.

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

    // Let's get node content with our token
    String filePath = "workspace://SpacesStore/6cffe1dd-d4aa-4770-b371-7c9b4c808cc9";
    AlfrescoUtils.AlfrescoStorePath alfPath = AlfrescoUtils.extractPath(filePath);

    DocumentContent nodeContent = new ContentService(alfrescoUrl, token)
        .getNodeContent(alfPath.storeType, alfPath.storeId, alfPath.nodeId);
    
    // so easy!
}

```

## What works and what not

| Class / Module   |  Method                                |  Status / Does work? |  
| ---------------- | -------------------------------------- | -------------------- |
| Auth             | `login`                                |  ✅ Works!           |
| Auth             | `logout`                               |  ✅ Works!           |
| Auth             | `validateTicket`                       |  ✅ Works!           |
| Content          | `getNodeContent`                       |  ✅ Works!           |
| Content          | `uploadDocument`                       |  ❌ Probably NOT!    |
| Content          | `getNodeMetadata`                      |  ❔ Maybe            |
| Content          | `storeNodeMetadata`                    |  ⚠️ Should          |
| Content          | `advancedSearch`                       |  ❌ Probably NOT!    |
| Content          | `deleteDocument`                       |  ⚠️ Should          |
| Folder           | `createFolder`                         |  ⚠️ Should          |
| Folder           | `searchFolder`                         |  ❔ Maybe            |
| Folder           | `createFolderByCmisAtomEntry`          |  ⚠️ Should          |
| Group            | `getGroups`                            |  ♋ Partial          |
| Group            | `getGroup`                             |  ✅ Works!           |
| Group            | `getRootGroups`                        |  ❌ Probably NOT!    |
| Group            | `getChildAuthorities`                  |  ❌ Probably NOT!    |
| Group            | `getParentAuthorities`                 |  ❌ Probably NOT!    |
| Group            | `deleteGroup`                          |  ⚠️ Should          |
| Permission       | `setPermissions`                       |  ⚠️ Should          |
| Permission       | `readPermissions`                      |  ⚠️ Should          |
| Permission       | `setPermissions`                       |  ⚠️ Should          |
| User             | `getUsers`                             |  ✅ Works!           |
| User             | `getUser`                              |  ✅ Works!           |
| User             | `createUser`                           |  ⚠️ Should          |
| User             | `changePassword`                       |  ⚠️ Should          |
| User             | `deleteUser`                           |  ⚠️ Should          |
| User             | `updateUser`                           |  ⚠️ Should          |
| User             | `getUserHome`                          |  ❌ Probably NOT!    |