package name.krot.broker.dao;

import name.krot.broker.entity.AppBalance;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<AppBalance, Long> {
    AppBalance findAppBalanceByUserId(Long id);
}
