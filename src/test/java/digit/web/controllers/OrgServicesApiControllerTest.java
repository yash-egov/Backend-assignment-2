package digit.web.controllers;

import digit.web.models.HttpsrawGithubusercontentComegovernmentsDIGITOSSmastercoreServicesdocscommonContractV11YmlcomponentsschemasErrorRes;
import digit.web.models.HttpsrawGithubusercontentComegovernmentsDIGITOSSmastercoreServicesdocscommonContractYmlcomponentsschemasErrorRes;
import digit.web.models.OrgRequest;
import digit.web.models.OrgResponse;
import digit.web.models.OrgSearchCriteria;
import digit.web.models.OrgServiceRequest;
import digit.web.models.OrgServiceResponse;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import digit.TestConfiguration;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
* API tests for OrgServicesApiController
*/
@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(OrgServicesApiController.class)
@Import(TestConfiguration.class)
public class OrgServicesApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void orgServicesOrganisationV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/org-services/organisation/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void orgServicesOrganisationV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/org-services/organisation/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void orgServicesOrganisationV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/org-services/organisation/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void orgServicesOrganisationV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/org-services/organisation/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void orgServicesOrganisationV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/org-services/organisation/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void orgServicesOrganisationV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/org-services/organisation/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void orgServicesV1CreatePostSuccess() throws Exception {
        mockMvc.perform(post("/org-services/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void orgServicesV1CreatePostFailure() throws Exception {
        mockMvc.perform(post("/org-services/v1/_create").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void orgServicesV1SearchPostSuccess() throws Exception {
        mockMvc.perform(post("/org-services/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void orgServicesV1SearchPostFailure() throws Exception {
        mockMvc.perform(post("/org-services/v1/_search").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

    @Test
    public void orgServicesV1UpdatePostSuccess() throws Exception {
        mockMvc.perform(post("/org-services/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isOk());
    }

    @Test
    public void orgServicesV1UpdatePostFailure() throws Exception {
        mockMvc.perform(post("/org-services/v1/_update").contentType(MediaType
        .APPLICATION_JSON_UTF8))
        .andExpect(status().isBadRequest());
    }

}
