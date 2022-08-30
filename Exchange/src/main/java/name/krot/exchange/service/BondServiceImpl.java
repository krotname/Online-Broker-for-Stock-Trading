package name.krot.exchange.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import name.krot.exchange.dao.BalanceRepository;
import name.krot.exchange.dao.BalanceRepository;
import name.krot.exchange.dao.BondRepository;
import name.krot.exchange.dao.CourseRepository;
//import name.krot.exchange.entity.AppBalance;
import name.krot.exchange.entity.AppBalance;
import name.krot.exchange.entity.AppBond;
import name.krot.exchange.entity.AppCourse;
import name.krot.grpc.ExchangeOuterClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BondServiceImpl implements BondService{

    private final CourseRepository courseRepository;
    private final BondRepository bondRepository;
    private final BalanceRepository balanceRepository;

    public ExchangeOuterClass.ReplyCourse getCurrentPrice(String bondCode) {

        AppBond appBond = bondRepository.findAppBondByBondCode(bondCode);
        AppCourse appCourse = courseRepository.findAppCourseByBondType(appBond);

        return ExchangeOuterClass.ReplyCourse.
                newBuilder().
                setName(appBond.getBondName()).
                setId(appCourse.getId()).
                setPrice(appCourse.getBondCurrentCourse()).
                build();
    }

    public ExchangeOuterClass.Reply getBondInfo(long id) {
        log.info(String.valueOf(id));
        AppBalance appBalance = balanceRepository.findAppBalanceByBondHolderId(id);

        return ExchangeOuterClass.Reply.newBuilder()
                .setCount(appBalance.getBalance())
                .setPrice(appBalance.getBondType().getAppCourse().getBondCurrentCourse())
                .setOwnerId(id)
                .setName(appBalance.getBondType().getBondName())
                .build();
    }
}
