package digit.web.controllers;


//import digit.web.models.HttpsrawGithubusercontentComegovernmentsDIGITOSSmastercoreServicesdocscommonContractV11YmlcomponentsschemasErrorRes;
//import digit.web.models.HttpsrawGithubusercontentComegovernmentsDIGITOSSmastercoreServicesdocscommonContractYmlcomponentsschemasErrorRes;

import digit.kafka.Producer;
import digit.services.OrganisationService;
import digit.util.ResponseInfoFactory;
import digit.web.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
//import jdk.internal.org.objectweb.asm.commons.GeneratorAdapter;
import org.egov.common.contract.response.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.*;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;


@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Controller
@RequestMapping("")
public class OrgServicesApiController {


    private final OrganisationService organisationService;


    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


    Producer producer;


    private ResponseInfoFactory responseInfoFactory;


    public OrgServicesApiController(OrganisationService organisationService, ObjectMapper objectMapper, HttpServletRequest request, Producer producer, ResponseInfoFactory responseInfoFactory) {
        this.organisationService = organisationService;
        this.objectMapper = objectMapper;
        this.request = request;
        this.producer = producer;
        this.responseInfoFactory = responseInfoFactory;
    }

    @RequestMapping(value = "/org-services/organisation/v1/_create", method = RequestMethod.POST)
    public ResponseEntity<OrgResponse> orgServicesOrganisationV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @RequestBody OrgRequest body) {


        Organisation organisation = organisationService.registerOrganisation(body);
        List<Organisation> allOrganisations = List.of(organisation);
        ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(body.getRequestInfo(), true);
        OrgResponse response = OrgResponse.builder().organisations(allOrganisations).responseInfo(responseInfo).build();
        return new ResponseEntity<OrgResponse>(response, HttpStatus.ACCEPTED);

    }


    @RequestMapping(value = "/org-services/organisation/v1/_search", method = RequestMethod.POST)
    public ResponseEntity<OrgResponse> orgServicesOrganisationV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody OrgSearchCriteria body) {
        try {
            List<Organisation> organisations = organisationService.searchOrganisations(body);
            OrgResponse response = OrgResponse.builder().organisations(organisations).build();
            return new ResponseEntity<OrgResponse>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<OrgResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/org-services/organisation/v1/_update", method = RequestMethod.POST)
    public ResponseEntity<OrgResponse> orgServicesOrganisationV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody OrgRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrgResponse>(objectMapper.readValue("{  \"ResponseInfo\" : \"\",  \"pagination\" : \"\",  \"organisations\" : [ {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  }, {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  } ]}", OrgResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                return new ResponseEntity<OrgResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrgResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/org-services/v1/_create", method = RequestMethod.POST)
    public ResponseEntity<OrgServiceResponse> orgServicesV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @RequestBody OrgServiceRequest body) {

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrgServiceResponse>(objectMapper.readValue("{  \"ResponseInfo\" : \"\",  \"pagination\" : \"\",  \"organisations\" : [ {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  }, {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  } ],  \"workflow\" : \"{}\"}", OrgServiceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                return new ResponseEntity<OrgServiceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrgServiceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/org-services/v1/_search", method = RequestMethod.POST)
    public ResponseEntity<OrgServiceResponse> orgServicesV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody OrgSearchCriteria body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrgServiceResponse>(objectMapper.readValue("{  \"ResponseInfo\" : \"\",  \"pagination\" : \"\",  \"organisations\" : [ {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  }, {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  } ],  \"workflow\" : \"{}\"}", OrgServiceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                return new ResponseEntity<OrgServiceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrgServiceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value = "/org-services/v1/_update", method = RequestMethod.POST)
    public ResponseEntity<OrgServiceResponse> orgServicesV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema = @Schema()) @Valid @RequestBody OrgServiceRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrgServiceResponse>(objectMapper.readValue("{  \"ResponseInfo\" : \"\",  \"pagination\" : \"\",  \"organisations\" : [ {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  }, {    \"functions\" : [ {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    }, {      \"applicationNumber\" : \"applicationNumber\",      \"documents\" : [ \"{}\", \"{}\" ],      \"validFrom\" : 6.027456183070403,      \"type\" : \"type\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"orgId\" : \"orgId\",      \"applicationStatus\" : \"ACTIVE\",      \"auditDetails\" : \"\",      \"wfStatus\" : \"wfStatus\",      \"category\" : \"category\",      \"class\" : \"Class 1, Class 2, Class 3 etc..\",      \"validTo\" : 1.4658129805029452    } ],    \"applicationNumber\" : \"applicationNumber\",    \"documents\" : [ null, null ],    \"identifiers\" : [ {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    }, {      \"type\" : \"PAN, GSTIN, TIN etc..\",      \"isActive\" : true,      \"additionalDetails\" : { },      \"value\" : \"value\"    } ],    \"jurisdiction\" : [ {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    }, {      \"code\" : \"WARD, LOCALITY, ULB, CITY\",      \"id\" : \"WARD01, JATNI\",      \"additionalDetails\" : { }    } ],    \"orgAddress\" : [ \"{}\", \"{}\" ],    \"isActive\" : true,    \"additionalDetails\" : { },    \"contactDetails\" : [ {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    }, {      \"contactMobileNumber\" : \"contactMobileNumber\",      \"contactEmail\" : \"contactEmail\",      \"contactName\" : \"contactName\"    } ],    \"externalRefNumber\" : \"externalRefNumber\",    \"dateOfIncorporation\" : 0.8008281904610115,    \"applicationStatus\" : \"applicationStatus\",    \"auditDetails\" : \"\",    \"tenantId\" : \"pb.amritsar\",    \"name\" : \"name\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"orgNumber\" : \"orgNumber\"  } ],  \"workflow\" : \"{}\"}", OrgServiceResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                return new ResponseEntity<OrgServiceResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrgServiceResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
