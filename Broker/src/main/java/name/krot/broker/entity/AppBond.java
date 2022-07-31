package name.krot.broker.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class AppBond {
    @Id
    private long bondCode;
    private String bondName;
    private String bondType;
    private String bondPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppBond appBond = (AppBond) o;
        return Objects.equals(bondCode, appBond.bondCode);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}