package hpbao.domain.caloriekit;

import hpbao.domain.goal.GoalSet;
import hpbao.domain.goal.GoalSetCidn.ExerciseGoal;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class CalorieKit {
    @Id @GeneratedValue
    @Column(name = "CALORIEKIT_ID")
    private Long id; // 식별자 아이디

    @Enumerated(EnumType.STRING)
    private CalorieGal calorieGal; // 사용자 체형에 따른 목표

    @OneToMany(mappedBy = "calorieKit")
    private List<GoalSet> goalSets = new ArrayList<>();

    private String gender; //성별
    private Integer weight; // 몸무게
    private Integer height; // 키
    private Integer age; // 나이
    private double bmr; // 기초대사량
    private double pal; //활동대사량
    private Integer dailyCaloric; // 하루권장칼로리량

    public CalorieKit() {

    };

    public double addBmr(String gender, Integer weight, Integer height, Integer age){
        double bmr = 0;
        if( StringUtils.hasText(gender) && gender.equals("여성")){
             bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
        } else if (StringUtils.hasText(gender) && gender.equals("남성")) {
             bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        }
        return bmr;
    };

    //비율 기반 칼로리 추가 방식 : bmr+(bmr * 비율)
    public double addPal(double bmr) {
        ExerciseGoal excGoal = new ExerciseGoal();
        Integer intensity = excGoal.getExcIntensity();
        if ( intensity == 1){
            return bmr * 0.2;
        }else if(intensity == 2){
            return bmr * 0.375;
        } else if (intensity == 3) {
            return  bmr * 0.555;
        } else if (intensity == 4) {
            return  bmr * 0.725;
        } else if (intensity == 5) {
            return  bmr * 0.9;
        }
        return pal;
    };

    public Integer dailyCaloric (double bmr , double pal){

        Integer newDailyCaloric = (int) (bmr + pal);

        return dailyCaloric;
    };

//    public CalorieKit(List<CalorieGal> calorieGoal, Integer weight, Integer height, Integer age, Float pal, Integer bmr, Integer dailyCaloric) {
//        this.calorieGoal = calorieGoal;
//        this.weight = weight;
//        this.height = height;
//        this.age = age;
//        this.pal = pal;
//        this.bmr = bmr;
//        this.dailyCaloric = dailyCaloric;
//    }
}
