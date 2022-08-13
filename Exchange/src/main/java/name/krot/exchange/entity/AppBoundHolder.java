package name.krot.exchange.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class AppBoundHolder {
    @Id
    private long id;
    private String username;
    //@OneToMany // todo аргументы  и мэни ту мэни
   // @ToString.Exclude
   // private List<AppBond> bonds;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppBoundHolder appBoundHolder = (AppBoundHolder) o;
        return Objects.equals(id, appBoundHolder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
