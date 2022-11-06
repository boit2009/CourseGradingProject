package coursegradingproject.client.repository;

import coursegradingproject.client.entity.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseClassRepository extends JpaRepository<CourseClass,Integer> {

}
