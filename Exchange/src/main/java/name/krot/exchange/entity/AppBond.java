package name.krot.exchange.entity;

import com.google.common.base.Objects;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class AppBond {
    @Id
    private long id;
    private String name;
    private String bondType; // todo  тип данных
    private String bondPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppBond appBond = (AppBond) o;
        return id == appBond.id && Objects.equal(name, appBond.name) && Objects.equal(bondType, appBond.bondType) && Objects.equal(bondPrice, appBond.bondPrice);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
