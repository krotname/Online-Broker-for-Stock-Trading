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
@Table(name = "bond_holder")
public class AppBondHolder {
    @Id
    private long id;
    private long userId;
}
