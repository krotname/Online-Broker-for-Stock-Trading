package name.krot.broker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DtoUserInfo {
    private String login;
    private long balance;
    private String currency;
}
