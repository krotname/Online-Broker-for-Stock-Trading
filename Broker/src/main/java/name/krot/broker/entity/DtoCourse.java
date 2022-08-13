package name.krot.broker.entity;

import lombok.*;

@Data
@Builder
public class DtoCourse {
    private long id;
    private long price;
    private String name;
}
