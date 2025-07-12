package hpbao.web.repository;

import hpbao.domain.goal.GoalSet;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface GoalSetRepository {

    GoalSet save(GoalSet goalSet);

    public void update(Long goalSetId, GoalSet updateParam);

    Optional<GoalSet> findById(Long id);

    List<GoalSet> findAll();
}
