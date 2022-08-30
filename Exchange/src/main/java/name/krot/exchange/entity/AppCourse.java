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
@Table(name = "course")
public class AppCourse implements Serializable {

    @Id
    private long id;

    @OneToOne
    @JoinColumn(name = "bond_type_id")
    private AppBond bondType;

    @Column(name = "bond_current_course", nullable = false)
    private Long bondCurrentCourse;
}
