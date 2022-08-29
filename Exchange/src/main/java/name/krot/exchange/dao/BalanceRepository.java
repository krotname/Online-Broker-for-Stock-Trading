package name.krot.exchange.dao;

import name.krot.exchange.entity.AppBalance;
import org.springframework.data.repository.CrudRepository;

public interface BalanceRepository extends CrudRepository<AppBalance, Long> {
    AppBalance findAppBalanceByBondHolderId(long id);
}
