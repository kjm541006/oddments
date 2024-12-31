package study.test.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class User {

    private Long id;
    private String username;
    private String name;
    private BigDecimal amount;

    public User(Long id, String username, String name, BigDecimal amount) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.amount = amount;
    }
}
