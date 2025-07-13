package hpbao.web.repository;

import hpbao.domain.caloriekit.CalorieKit;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CalorieKitRepository {

     private final EntityManager em;
   public void  save(CalorieKit calorieKit) {
      em.persist(calorieKit);
   }

   public CalorieKit findById(Long id){

       return em.find(CalorieKit.class, id);
   }

    public List<CalorieKit> findAll() {

       return  em.createQuery("select c from CalorieKit c", CalorieKit.class)
               .getResultList();
    }

//    public void update(Long calorieKitId, CalorieKit updateParam) {
//        CalorieKit findCaloriekit = findById(calorieKitId);
//        findCaloriekit.setCalorieGal(updateParam.getCalorieGal());
//        findCaloriekit.setWeight(updateParam.getWeight());
//        findCaloriekit.setHeight(updateParam.getHeight());
//        findCaloriekit.setAge(updateParam.getAge());
//        findCaloriekit.setPal(updateParam.getPal());
//    }

//    public void clearStore() {
//       store.clear();
//    }
}
