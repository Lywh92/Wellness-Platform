package hpbao.web.repository;

import hpbao.domain.goal.GoalSet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class GoalRepository implements GoalSetRepository {

    private final EntityManager em;

    public GoalRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public GoalSet save(GoalSet goalSet) {
        return null;
    }

    @Override
    public void update(Long goalSetId, GoalSet updateParam) {

    }

    @Override
    public Optional<GoalSet> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<GoalSet> findAll(){
        String jpql = "select g from GoalSet g";
        TypedQuery<GoalSet> query = em.createQuery(jpql, GoalSet.class);
        return query.getResultList();
    }

}
