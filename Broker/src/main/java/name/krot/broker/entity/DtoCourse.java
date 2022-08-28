package name.krot.broker.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DtoCourse {
    private long id;
    private long price;
    private String name;
}
