package hpbao.domain.caloriekit;

import hpbao.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CalorieKitRepository {

   private static final Map<Long, CalorieKit> store = new ConcurrentHashMap<>();
   private static long sequence = 0L;

   public CalorieKit save(CalorieKit calorieKit) {
       calorieKit.setId(++sequence);
       store.put(calorieKit.getId(), calorieKit);
       return calorieKit;
   }

   public CalorieKit findById(Long id){

       return store.get(id);
   }

    public List<CalorieKit> findAll() {

       return new ArrayList<>(store.values());
    }

    public void update(Long calorieKitId, CalorieKit updateParam) {
        CalorieKit findCaloriekit = findById(calorieKitId);
        findCaloriekit.setCalorieGal(updateParam.getCalorieGal());
        findCaloriekit.setWeight(updateParam.getWeight());
        findCaloriekit.setHeight(updateParam.getHeight());
        findCaloriekit.setAge(updateParam.getAge());
        findCaloriekit.setPal(updateParam.getPal());
    }

    public void clearStore() {
       store.clear();
    }
}
