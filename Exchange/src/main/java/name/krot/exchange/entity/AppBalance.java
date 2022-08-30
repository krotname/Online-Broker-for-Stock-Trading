package name.krot.exchange.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "bond_balance")
public class AppBalance implements Serializable {
    @Id
    @Column(name = "bond_holder_id")
    private long bondHolderId;
    private long balance;
    @ManyToOne
    @JoinColumn(name="bond_type_id", nullable=false)
    private AppBond bondType;

}
