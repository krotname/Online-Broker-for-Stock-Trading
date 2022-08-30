package name.krot.exchange.dao;

import name.krot.exchange.entity.AppBalance;
import name.krot.exchange.entity.AppBondHolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BalanceRepository extends CrudRepository<AppBalance, AppBondHolder> {
    AppBalance findAppBalanceByBondHolderId(@Param("userId") Long userId);
}
