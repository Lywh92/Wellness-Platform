package hpbao.domain.goal.GoalSetCidn;

import hpbao.domain.goal.GoalSet;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ExerciseGoal extends GoalSet { // exercise : 운동목표


    private String excType; // 운동종류
    private String excGoal;
    private Integer excTime; // 운동시간
    // 운동주기
    private Integer excIntensity; // 운동강도 : pml 함께 사용




}
