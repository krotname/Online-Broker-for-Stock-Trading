package name.krot.broker.dao;

import name.krot.broker.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AppUser, Long> {
    AppUser findAppUserByLogin(String login);
}
