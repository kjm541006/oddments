package study.test.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransferRequestDTO {

    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;
}
