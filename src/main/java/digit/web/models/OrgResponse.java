package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.response.ResponseInfo;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.Builder;

/**
 * OrgResponse
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class OrgResponse   {
        @JsonProperty("ResponseInfo")

                private ResponseInfo responseInfo = null;

        @JsonProperty("organisations")
          @Valid
                private List<Organisation> organisations = null;

        @JsonProperty("pagination")

                private AllOfOrgResponsePagination pagination = null;


//        public OrgResponse addOrganisationsItem(Organisation organisationsItem) {
//            if (this.organisations == null) {
//            this.organisations = new ArrayList<>();
//            }
//        this.organisations.add(organisationsItem);
//        return this;
//        }

}
