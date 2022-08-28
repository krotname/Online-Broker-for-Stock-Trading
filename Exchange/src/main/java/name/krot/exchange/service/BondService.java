package name.krot.exchange.service;

import lombok.RequiredArgsConstructor;
import name.krot.exchange.dao.BondRepository;
import name.krot.exchange.dao.CourseRepository;
import name.krot.exchange.entity.AppBond;
import name.krot.exchange.entity.AppCourse;
import name.krot.grpc.ExchangeOuterClass;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BondService {

    private final CourseRepository courseRepository;
    private final BondRepository bondRepository;

    public ExchangeOuterClass.ReplyCourse getCurrentPrice(String bondCode) {

        AppBond appBond = bondRepository.findAppBondByBondCode(bondCode);
        AppCourse appCourse = courseRepository.findAppCourseByBondType(appBond);

        return ExchangeOuterClass.ReplyCourse.
                newBuilder().
                setName(appCourse.getBondType().getBondName()).
                setId(appCourse.getId()).
                setPrice(appCourse.getBondCurrentCourse()).
                build();
    }

    public long sellBond(AppBond appBond, long count) {
        return 0L;
    }

    public long buyBond(AppBond appBond, long count) {
        return 0L;
    }
}
