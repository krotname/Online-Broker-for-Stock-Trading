package name.krot.exchange.dao;

import name.krot.exchange.entity.AppBond;
import org.springframework.data.repository.CrudRepository;

public interface BondRepository extends CrudRepository<AppBond, Long> {
    AppBond findAppBondByBondCode(String bondCode);
    AppBond findAppBondById(long id);

}
