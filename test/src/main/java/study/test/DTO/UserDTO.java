package study.test.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String name;
    private BigDecimal amount;
}
