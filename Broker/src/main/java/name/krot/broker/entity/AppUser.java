package name.krot.broker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@EqualsAndHashCode
public class AppUser {
    @Id
    private long id;
    private String login;
    private String password;
    private String role;
}