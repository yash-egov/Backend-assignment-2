package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
//import digit.web.models.HttpsrawGithubusercontentComegovernmentsDIGITOSSmastercoreServicesdocscommonContractV11YmlcomponentsschemasDocument;
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
 * Represents the functions of an organisation
 */
@Schema(description = "Represents the functions of an organisation")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Function   {

        @JsonProperty("id")

        private String id = null;

        @JsonProperty("orgId")

                private String orgId = null;

        @JsonProperty("applicationNumber")

                private String applicationNumber = null;

        @JsonProperty("type")

        @Size(min=2,max=64)         private String type = null;

        @JsonProperty("category")

        @Size(min=2,max=64)         private String category = null;

        @JsonProperty("class")

        @Size(min=2,max=64)         private String propertyClass = null;

        @JsonProperty("validFrom")

          @Valid
                private BigDecimal validFrom = null;

        @JsonProperty("validTo")

          @Valid
                private BigDecimal validTo = null;

        @JsonProperty("wfStatus")

        @Size(min=2,max=64)         private String wfStatus = null;

        @JsonProperty("isActive")

                private Boolean isActive = null;

            /**
            * Gets or Sets applicationStatus
            */
            public enum ApplicationStatusEnum {
                        ACTIVE("ACTIVE"),
                        
                        INACTIVE("INACTIVE"),
                        
                        INWORKFLOW("INWORKFLOW");
            
            private String value;
            
            ApplicationStatusEnum(String value) {
            this.value = value;
            }
            
            @Override
            @JsonValue
            public String toString() {
            return String.valueOf(value);
            }
            
            @JsonCreator
            public static ApplicationStatusEnum fromValue(String text) {
            for (ApplicationStatusEnum b : ApplicationStatusEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
            return b;
            }
            }
            return null;
            }
            }        @JsonProperty("applicationStatus")

                private ApplicationStatusEnum applicationStatus = null;

        @JsonProperty("documents")
          @Valid
                private List<Document> documents = null;

        @JsonProperty("additionalDetails")

                private Object additionalDetails = null;

        @JsonProperty("auditDetails")

                private AllOfFunctionAuditDetails auditDetails = null;


        public Function addDocumentsItem(Document documentsItem) {
            if (this.documents == null) {
            this.documents = new ArrayList<>();
            }
        this.documents.add(documentsItem);
        return this;
        }

}
