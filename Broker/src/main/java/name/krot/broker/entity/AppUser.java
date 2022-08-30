package name.krot.broker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@EqualsAndHashCode
public class AppUser implements Serializable {
    @Id
    private long id;
    private String login;
    private String password;
    private String role;
    @OneToOne(optional = false)
    @JoinColumn(name = "id", nullable = false)
    private AppBalance balance;
}