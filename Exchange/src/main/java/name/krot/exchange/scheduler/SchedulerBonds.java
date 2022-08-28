package name.krot.exchange.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import name.krot.exchange.dao.BondRepository;
import name.krot.exchange.dao.CourseRepository;
import name.krot.exchange.entity.AppBond;
import name.krot.exchange.entity.AppCourse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
@Slf4j
public class SchedulerBonds {

    private final CourseRepository courseRepository;
    private final BondRepository bondRepository;

    @Scheduled(fixedDelay = 3000)
    public void scheduleFixedDelayTask() {
        Iterable<AppBond> all = bondRepository.findAll();

        all.forEach(appBond -> {
            AppCourse appCourse = courseRepository.findAppCourseByBondType(appBond);
            long random = ThreadLocalRandom.current().nextLong(1, 10);
            boolean negation = ThreadLocalRandom.current().nextBoolean();
            if (negation) {
                random *= -1;
            }
            Long bondCurrentCourse = appCourse.getBondCurrentCourse();
            long newCourse = bondCurrentCourse + bondCurrentCourse / 100 * random;
            log.debug("{}: Current Course = {}, new Course = {}", appBond.getBondName(), bondCurrentCourse, newCourse);
            appCourse.setBondCurrentCourse(newCourse);
            courseRepository.save(appCourse);
        });
        log.info("Updated course: " + all);

    }
}
