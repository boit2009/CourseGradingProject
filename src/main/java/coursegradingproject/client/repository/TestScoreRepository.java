package coursegradingproject.client.repository;

import coursegradingproject.client.entity.TestScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestScoreRepository extends JpaRepository<TestScore,Integer> {

}