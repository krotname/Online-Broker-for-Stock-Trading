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
@Table(name = "balance")
@EqualsAndHashCode
public class AppBalance {
    @Id
    private long userId;
    private long balance;
    private String currency;
}
