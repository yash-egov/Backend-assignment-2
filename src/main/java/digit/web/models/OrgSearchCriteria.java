package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Organisation search attributes
 */
@Schema(description = "Organisation search attributes")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class OrgSearchCriteria   {
        @JsonProperty("id")

                private List<String> id = null;

        @JsonProperty("tenantId")

        @Size(min=2,max=1000)         private String tenantId = null;

        @JsonProperty("name")

                private String name = null;

        @JsonProperty("applicationNumber")

                private String applicationNumber = null;

        @JsonProperty("orgNumber")

                private String orgNumber = null;

        @JsonProperty("applicationStatus")

                private String applicationStatus = null;

        @JsonProperty("contactMobileNumber")

                private String contactMobileNumber = null;

        @JsonProperty("functions")

                private AllOfOrgSearchCriteriaFunctions functions = null;

        @JsonProperty("createdFrom")

          @Valid
                private BigDecimal createdFrom = null;

        @JsonProperty("createdTo")

          @Valid
                private BigDecimal createdTo = null;

        @JsonProperty("boundaryCode")

                private String boundaryCode = null;

        @JsonProperty("identifierType")

                private String identifierType = null;

        @JsonProperty("identifierValue")

                private String identifierValue = null;

        @JsonProperty("includeDeleted")

                private Boolean includeDeleted = false;


        public OrgSearchCriteria addIdItem(String idItem) {
            if (this.id == null) {
            this.id = new ArrayList<>();
            }
        this.id.add(idItem);
        return this;
        }

}
