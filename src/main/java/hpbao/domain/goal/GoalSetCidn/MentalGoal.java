package hpbao.domain.goal.GoalSetCidn;

import hpbao.domain.goal.GoalSet;
import jakarta.persistence.Entity;
import lombok.Getter;

@Entity
@Getter
public class MentalGoal extends GoalSet {

    private String Management; // 멘탈관리 선택
    private String Motivation; // 멘탈동기
    private String[] details; // 달성내용
    private Integer sleepGoal; // 수면목표
    
    public MentalGoal(){

    };

    public String sleepState(Integer sleepGoal){
        if(sleepGoal < 6) {
            return "부족";
        } else if (sleepGoal == 6) {
            return "양호";
        } else {
           return  "원활";
        }
    }
}
