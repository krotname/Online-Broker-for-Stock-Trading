package name.krot.exchange.dao;

import name.krot.exchange.entity.AppBond;
import name.krot.exchange.entity.AppCourse;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<AppCourse, Long> {
    AppCourse findAppCourseByBondType(AppBond appBond);
}
