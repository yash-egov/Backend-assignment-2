package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
//import digit.web.models.HttpsrawGithubusercontentComegovernmentsDIGITOSSmastercoreServicesdocscommonContractV11YmlcomponentsschemasWorkflow;
import digit.web.models.Organisation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * OrgServiceResponse
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class OrgServiceResponse   {
        @JsonProperty("ResponseInfo")

                private ResponseInfo responseInfo = null;

        @JsonProperty("organisations")
          @Valid
                private List<Organisation> organisations = null;

        @JsonProperty("pagination")

                private AllOfOrgServiceResponsePagination pagination = null;

        @JsonProperty("workflow")

          @Valid
                private Workflow workflow = null;


        public OrgServiceResponse addOrganisationsItem(Organisation organisationsItem) {
            if (this.organisations == null) {
            this.organisations = new ArrayList<>();
            }
        this.organisations.add(organisationsItem);
        return this;
        }

}
