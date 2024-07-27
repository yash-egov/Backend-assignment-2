package digit.web.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Captures details of a contact person
 */
@Schema(description = "Captures details of a contact person")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDetails {
    @JsonProperty("id")

    private String id = null;


    @JsonProperty("orgId")

    private String orgId = null;

    @JsonProperty("contactName")

    private String contactName = null;

    @JsonProperty("contactMobileNumber")

    private String contactMobileNumber = null;

    @JsonProperty("contactEmail")

    private String contactEmail = null;


}
