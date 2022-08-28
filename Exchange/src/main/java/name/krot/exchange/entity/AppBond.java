package name.krot.exchange.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "bond_type")
public class AppBond implements Serializable {
    @Id
    private long id;
    private String bondCode;
    private String bondName;
}
