package upyog.web.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.egov.common.contract.models.AuditDetails;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allotment {
    private String allotmentId;
    @NotBlank
    private String assetNo;
    @NotBlank
    @Size(max = 100, message = "Tenant ID must be less than or equal to 100 characters")
    private String tenantId;
    private String userUuid;
    @NotBlank
    @Size(max = 100, message = "Allottee name must be less than or equal to 100 characters")
    private String alloteeName;
    @NotBlank
    @Size(min = 10, max = 10, message = "Mobile no must be exactly 10 digits")
    private String mobileNo;
    @NotBlank
    @Size(min = 10, max = 10, message = "Alternate Mobile no must be exactly 10 digits")
    private String alternateMobileNo;
    @NotBlank
    @Size(max = 100, message = "Email ID must be less than or equal to 100 characters")
    private String emailId;
    @NotBlank
    private LocalDate agreementStartDate;
    @NotBlank
    private LocalDate agreementEndDate;
    @NotBlank
    private Integer duration;
    @NotBlank
    private BigDecimal rentRate;
    @NotBlank
    private BigDecimal monthlyRent;
    @NotBlank
    private BigDecimal advancePayment;
    @NotBlank
    private LocalDate advancePaymentDate;
    @NotBlank
    private String eofficeFileNo;

    private AuditDetails auditDetails;
}