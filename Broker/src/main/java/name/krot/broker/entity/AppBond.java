package name.krot.broker.entity;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class AppBond {
    @Id
    private long id;
    private String name;
    private AppType type;
    private double price;
    @OneToMany
    @ToString.Exclude
    private List<AppUser> owners;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppBond appBond = (AppBond) o;
        return id == appBond.id && Double.compare(appBond.price, price) == 0 && Objects.equal(name, appBond.name) && type == appBond.type && Objects.equal(owners, appBond.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, type, price, owners);
    }
}