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
@RequiredArgsConstructor
@Entity
@ToString
@Table(name = "bond_type")
public class AppBond implements Serializable {
    @Id
    private long id;
    private String bondCode;
    private String bondName;
    @OneToOne
    @JoinColumn(name = "id")
    @ToString.Exclude
    private AppCourse appCourse;
    @ManyToMany(mappedBy = "appBonds")
    @ToString.Exclude
    private List<AppBondHolder> appBondHolders;
}
