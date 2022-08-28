package name.krot.exchange.service;

import lombok.RequiredArgsConstructor;
import name.krot.exchange.dao.BondRepository;
import name.krot.exchange.dao.CourseRepository;
import name.krot.exchange.entity.AppBond;
import name.krot.exchange.entity.AppCourse;
import name.krot.grpc.ExchangeOuterClass;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BondService {

    private final CourseRepository courseRepository;
    private final BondRepository bondRepository;
    public ExchangeOuterClass.ReplyCourse getCurrentPrice(String bondCode) {

        System.out.println(bondCode);
        AppBond appBond = bondRepository.findAppBondByBondCode(bondCode);
        System.out.println(appBond);
        AppCourse appCourse = courseRepository.findAppCourseByBondType(appBond);
        System.out.println(appCourse);

        return ExchangeOuterClass.ReplyCourse.
                newBuilder().
                setName(appCourse.getBondType().getBondName()).
                setId(appCourse.getId()).
                setPrice(appCourse.getBondCurrentCourse()).
                build();
    }

    public long sellbond(AppBond appBond, long count) {
        return  0L;
    }

    public long buybond(AppBond appBond, long count) {
        return  0L;
    }
}
