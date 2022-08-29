package name.krot.broker.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@Entity
@EqualsAndHashCode
public class AppBond {
    @Id
    private long id;
    private String name;
    private AppType type;
    private double price;
    @OneToMany
    @ToString.Exclude
    private List<AppUser> owners;
}