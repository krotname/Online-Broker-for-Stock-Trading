package name.krot.broker.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

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