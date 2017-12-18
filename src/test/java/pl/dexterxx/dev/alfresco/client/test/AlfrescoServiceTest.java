package pl.dexterxx.dev.alfresco.client.test;

import pl.dexterxx.dev.alfresco.commons.AlfrescoUtil;
import pl.dexterxx.dev.alfresco.dto.AuthResponse;
import pl.dexterxx.dev.alfresco.dto.Credentials;
import pl.dexterxx.dev.alfresco.dto.common.GroupSorter;
import pl.dexterxx.dev.alfresco.dto.content.ContentMetadata;
import pl.dexterxx.dev.alfresco.dto.content.ContentUploadForm;
import pl.dexterxx.dev.alfresco.dto.content.QueryResponseSorter;
import pl.dexterxx.dev.alfresco.dto.content.SearchRequest;
import pl.dexterxx.dev.alfresco.dto.error.ServiceResponse;
import pl.dexterxx.dev.alfresco.dto.user.AddUser;
import pl.dexterxx.dev.alfresco.dto.user.AuthorityQuery;
import pl.dexterxx.dev.alfresco.dto.user.GroupQuery;
import pl.dexterxx.dev.alfresco.dto.user.User;
import pl.dexterxx.dev.alfresco.exception.AuthenticationException;
import pl.dexterxx.dev.alfresco.exception.ContentException;
import pl.dexterxx.dev.alfresco.exception.GroupException;
import pl.dexterxx.dev.alfresco.exception.SearchException;
import pl.dexterxx.dev.alfresco.exception.UserException;
import pl.dexterxx.dev.alfresco.service.AuthService;
import pl.dexterxx.dev.alfresco.service.ContentService;
import pl.dexterxx.dev.alfresco.service.FolderService;
import pl.dexterxx.dev.alfresco.service.GroupService;
import pl.dexterxx.dev.alfresco.service.UserService;

import javax.activation.FileDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO(dexterxx): migrate to testng
public class AlfrescoServiceTest {

    private static final String BASE_URL = "http://localhost:5080";
    private static String authTicket;

    public static void main(final String args[]) {
        testLoginValidateLogout(getCredentials());

        authTicket = testLoginValidate(getCredentials(), true);
        // testGetUsers();
        // testGetGroups();
        // testGetGroup();
        // testGetChildAuthorities();
        // testGetParentAuthorities();
        // testDeleteUser();
        // testCreateUser();
        // testGetUser();
        // testChangeUserPassword();
        // testUpdateUser();
        // testGetUser();
        testGetContent();
        // testAdvancedSearch();
        // testUploadContent();
        // testStoreMetadata();
        // testSearchFolder();
    }

    private static void testSearchFolder() {
        final FolderService folderService = new FolderService(BASE_URL, authTicket);
        try {
            System.out.println(
                    folderService.searchFolder("4f1a8cdb-e8e9-4987-bdf4-3e76fe2655d9", "cmis:name IN ('foo', 'bar')"));
        } catch (final ContentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void testStoreMetadata() {
        final ContentService contentService = new ContentService(BASE_URL,
                authTicket);
        final ContentMetadata contentMetadata = new ContentMetadata();
        final Map<String, String> properties = new HashMap<String, String>();
        properties.put("author", "SavedbyWindowsInternetExplorer8");
        properties.put("originator", "SavedbyWindowsInternetExplorer8");
        properties.put("application-id", "44284");
        contentMetadata.setProperties(properties);
        ;
        try {
            contentService.storeNodeMetadata("7b08f922-d84b-4aeb-a44c-8743c4a9d0d0", contentMetadata);
        } catch (final ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testAdvancedSearch() {
        final ContentService contentService = new ContentService(BASE_URL,
                authTicket);
        // EVERYTHING EXCEPT FOR PROPCO CONTENT MODEL
        SearchRequest searchReuqest = new SearchRequest("@cm\\:author:\"SavedbyWindowsInternetExplorer8\"");
        // FOR PROPCO CONTENT MODEL
        // SearchRequest searchReuqest = new SearchRequest("cm:lastName=\"Jain\"");
        // final SearchRequest searchReuqest = new SearchRequest("+PATH:\"//cm:QA//*\" +@cm\\:lastName:\"Jain\"");
//        final SearchRequest searchReuqest = new SearchRequest("@techblue\\:application-id:44284");
        // final PagingConfig pagingConfig = new PagingConfig();
        // pagingConfig.setMaxItems(2);
        // pagingConfig.setSkipCount(5);
        final QueryResponseSorter responseSorter = new QueryResponseSorter();
        responseSorter.setColumnName("@cm:modified");
        final List<QueryResponseSorter> responseSorters = new ArrayList<QueryResponseSorter>();
        responseSorters.add(responseSorter);
        searchReuqest.setResponseSorters(responseSorters);
        // searchReuqest.setPagingConfig(pagingConfig);
        try {
            System.out.println("RESPONSE:" + contentService.search(searchReuqest));
        } catch (final SearchException e) {
            e.printStackTrace();
        }

    }

    private static void testUploadContent() {
        final ContentService contentService = new ContentService(BASE_URL,
                authTicket);
        final ContentUploadForm uploadMetadata = new ContentUploadForm();
        final FileDataSource fileDataSource = new FileDataSource("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
        // FileDataSource fileDataSource = new FileDataSource("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
        uploadMetadata.setFileData(fileDataSource);
        uploadMetadata.setDestination("workspace://SpacesStore/a31a1771-fd57-4d78-a6b8-65372e50fdbc");
        // uploadMetadata.setContainerId("documentLibrary");
        // uploadMetadata.setUploadDirectory("/Company Home");
        // uploadMetadata.setSiteId("swsdp");
        uploadMetadata.setFileName("demo123.pdf");
        uploadMetadata.setDescription("Test REST upload");

        try {
            System.out.println(contentService.uploadDocument(uploadMetadata));
        } catch (final ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testGetContent() {
        final ContentService contentService = new ContentService(BASE_URL,
                authTicket);
        try {
            // ba90e398-dc4f-4de8-a97d-e30669ebee6c DOCX
            // 27eb6ac6-abb3-4e31-be96-a97140ff641a DOC
            AlfrescoUtil.AlfrescoStorePath alfrescoStorePath = AlfrescoUtil
                    .extractPath("workspace://SpacesStore/647e0d97-401e-48f0-8748-55d527456797");
            System.out.println(contentService.getNodeContent(alfrescoStorePath.nodeId));
        } catch (final ContentException e) {
            e.printStackTrace();
        }
    }

    private static void testUpdateUser() {
        final UserService userService = new UserService(BASE_URL, authTicket);
        final User user = new User();
        user.setCompanyaddress1("73, Sector 5");
        user.setCompanyaddress2("Manesar");
        user.setOrganization("Techblue Software");
        user.setMobile("9212641104");
        try {
            System.out.println(userService.updateUser("ajay", user));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testChangeUserPassword() {
        final UserService userService = new UserService(BASE_URL, authTicket);
        try {
            userService.changePassword("ajay", "ajay", "ajayd");
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testDeleteUser() {
        final UserService userService = new UserService(BASE_URL, authTicket);
        try {
            userService.deleteUser("ajay");
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testCreateUser() {
        final UserService userService = new UserService(BASE_URL, authTicket);
        final AddUser user = getMockUser();
        try {
            System.out.println(userService.createUser(user));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static AddUser getMockUser() {
        final AddUser user = new AddUser();
        user.setUserName("ajay");
        user.setPassword("ajay");
        user.setFirstName("Ajay");
        user.setLastName("Deshwal");
        user.setJobtitle("Software Engineer");
        user.setEmail("ajay.deshwal@techblue.co.uk");
        user.setQuota(3);
        final List<String> groups = new ArrayList<String>();
        groups.add("GROUP_ALFRESCO_ADMINISTRATORS");
        user.setGroups(groups);
        return user;
    }

    private static void testGetParentAuthorities() {
        final GroupService userService = new GroupService(BASE_URL, authTicket);
        try {
            final AuthorityQuery authorityQuery = new AuthorityQuery();
            authorityQuery.setSortBy(GroupSorter.AUTHORITY_NAME);
            System.out.println(userService.getParentAuthorities(
                    "EMAIL_CONTRIBUTORS", authorityQuery));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetChildAuthorities() {
        final GroupService userService = new GroupService(BASE_URL, authTicket);
        try {
            final AuthorityQuery authorityQuery = new AuthorityQuery();
            authorityQuery.setSortBy(GroupSorter.AUTHORITY_NAME);
            System.out.println(userService.getChildAuthorities(
                    "ALFRESCO_ADMINISTRATORS", authorityQuery));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetGroup() {
        final GroupService userService = new GroupService(BASE_URL, authTicket);
        try {
            System.out.println(userService.getGroup("ALFRESCO_ADMINISTRATORS"));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetGroups() {
        final GroupService userService = new GroupService(BASE_URL, authTicket);
        try {
            final GroupQuery groupQuery = new GroupQuery();
            System.out.println(userService.getGroups(groupQuery));
        } catch (final GroupException e) {
            e.printStackTrace();
        }
    }

    private static void testGetUser() {
        final UserService userService = new UserService(BASE_URL, authTicket);
        try {
            System.out.println(userService.getUser("ajay"));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static void testGetUsers() {
        final UserService userService = new UserService(BASE_URL, authTicket);
        try {
            System.out.println(userService.getUsers("A", 2));
        } catch (final UserException e) {
            e.printStackTrace();
        }
    }

    private static String testLoginValidateLogout(final Credentials credentials) {
        return testLoginValidate(credentials, false);
    }

    private static String testLoginValidate(final Credentials credentials, boolean onlyLogin) {
        final AuthService authService = new AuthService(BASE_URL, credentials);
        try {
            final AuthResponse token = authService.login();
            System.out.println("Auth Token: " + token);
            final String valid = authService.validateTicket(token.getAuthenticationData().getAuthenticationToken());
            System.out.println("Validation: " + valid);

            if (!token.getAuthenticationData().getAuthenticationToken().equals(valid)) {
                throw new AuthenticationException("Validation not equals response token");
            }

            if (!onlyLogin) {
                final ServiceResponse logout = authService.logout(token.getAuthenticationData().getAuthenticationToken());
                System.out.println("Logout: " + logout);
            }

            return valid;
        } catch (final AuthenticationException e) {
            e.printStackTrace();
        }
        return "exc";
    }

    private static Credentials getCredentials() {
        return new Credentials("admin", "admin");
    }
}