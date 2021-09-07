package app.springData.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    Long id;
    String email;
    String password;
}
