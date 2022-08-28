package name.krot.exchange.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "course")
public class AppCourse implements Serializable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bond_type_id")
    private AppBond bondType;

    @Column(name = "bond_current_course", nullable = false)
    private Long bondCurrentCourse;

}
