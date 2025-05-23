package org.egov.dx.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.egov.dx.web.models.Transaction;
import org.springframework.validation.annotation.Validated;
import org.egov.common.contract.response.ResponseInfo;

import javax.validation.Valid;
import java.util.List;

/**
 * The payment response object, representing the status of the payment
 */
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-06-05T12:58:12.679+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {

    @JsonProperty("ResponseInfo")
    @Valid
    private ResponseInfo responseInfo;

    @JsonProperty("Transaction")
    @Valid
    private List<Transaction> transactions;

}

