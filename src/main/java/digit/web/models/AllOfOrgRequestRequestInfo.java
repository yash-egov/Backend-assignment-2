package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.egov.common.contract.request.PlainAccessRequest;
import org.egov.common.contract.request.RequestInfo;

import java.util.Objects;

import org.egov.common.contract.request.User;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * AllOfOrgRequestRequestInfo
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T23:40:24.892419209+05:30[Asia/Kolkata]")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class AllOfOrgRequestRequestInfo  {

    @JsonProperty("apiId")
    @NotNull

    @Size(max=128)         private String apiId = null;

    @JsonProperty("ver")
    @NotNull

    @Size(max=32)         private String ver = null;

    @JsonProperty("ts")
    @NotNull

    private Long ts = null;

    @JsonProperty("action")
    @NotNull

    @Size(max=32)         private String action = null;

    @JsonProperty("did")

    @Size(max=1024)         private String did = null;

    @JsonProperty("key")

    @Size(max=256)         private String key = null;

    @JsonProperty("msgId")
    @NotNull

    @Size(max=256)         private String msgId = null;

    @JsonProperty("requesterId")

    @Size(max=256)         private String requesterId = null;

    @JsonProperty("authToken")

    private String authToken = null;

    @JsonProperty("userInfo")

    @Valid
    private User userInfo = null;

    @JsonProperty("correlationId")

    private String correlationId = null;

}

