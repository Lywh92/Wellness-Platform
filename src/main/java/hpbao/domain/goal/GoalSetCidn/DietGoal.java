package hpbao.domain.goal.GoalSetCidn;

import hpbao.domain.caloriekit.CalorieGal;
import hpbao.domain.caloriekit.CalorieKit;
import hpbao.domain.goal.GoalSet;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Dietary Goal: 식단목표
@Entity
@Setter @Getter
public class DietGoal extends GoalSet {
    //    private Integer dtrPeriod; // 식단기간

    @ElementCollection
    private Map<DietByTime, Integer> mealCalories = new HashMap<>();
    private Integer dietCaloric; //  하루 목표칼로리 : 체형목표와 활동량 고려

    @Enumerated(EnumType.STRING)
    private DietByTime dietByTime; // 오전식단, 오후식단, 저녁식단:Diet by time

    private Integer dietMoisture;  //  수분목표: 컵 단위

    private String Macronutrients; // 3대 영양소
    private String dietDetail; //  식습관/ 제한음식

    public DietGoal(){

    };

    public int newDtrCaloric(CalorieKit calorieKit, Integer dietCaloric){

        CalorieKit CalorieKit = new CalorieKit();
        Random random = new Random();
        int value = random.nextInt(201) + 300;

        double dailyCaloric = calorieKit.dailyCaloric(calorieKit.getBmr(),calorieKit.getPal());
        CalorieGal calorieGal = calorieKit.getCalorieGal();

        if (calorieGal == CalorieGal.체중유지){
           return (int) dailyCaloric;
        } else if (calorieGal == CalorieGal.체중감소) {
            return (int) dailyCaloric - 500;
        } else if (calorieGal ==CalorieGal.체중증가){
            return (int) dailyCaloric + value;
        }else if(calorieGal == CalorieGal.근육증가) {
            return (int)dailyCaloric + 500;
        }else {
            return (int)dietCaloric;
        }

    };

    public void distribution(Integer dietCaloric) {
        this.dietCaloric = dietCaloric;
       Integer oneMeal = dietCaloric / 3;
       mealCalories.put(DietByTime.MORNING, oneMeal);
       mealCalories.put(DietByTime.AFTERNOON, oneMeal);
       mealCalories.put(DietByTime.EVENING, oneMeal);

    };

    // 특정 식사에 대한 칼로리 설정
    public void setCaloricForMeal(DietByTime dietByTime, int caloric) {

         mealCalories.put(dietByTime, caloric);
    }

    // 특정 식사에 대한 칼로리 반환
    public Integer getCaloricForMeal(DietByTime dietByTime) {

        return mealCalories.getOrDefault(dietByTime, 0);
    }

    // 전체 식단에 대한 칼로리 반환
//    public Map<DietByTime,Integer> getAllMealCalories() {
//        return mealCalories;
//    }


}