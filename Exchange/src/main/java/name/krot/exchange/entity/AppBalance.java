package name.krot.exchange.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "bond_balance")
public class AppBalance {
    @Id
    private long bondHolderId;
    private long balance;
    private long bondTypeId;
}
