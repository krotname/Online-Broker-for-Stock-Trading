package name.krot.exchange.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "bond_holder")
public class AppBondHolder implements Serializable {
    @Id
    private long id;
    private long userId;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "bond_balance",
            joinColumns = {@JoinColumn(name = "bond_type_id")},
            inverseJoinColumns = {@JoinColumn(name = "bond_holder_id")}
    )
    private List<AppBond> appBonds;
}
