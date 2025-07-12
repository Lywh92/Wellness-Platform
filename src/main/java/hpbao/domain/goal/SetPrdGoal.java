package hpbao.domain.goal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.temporal.ChronoUnit;

import static hpbao.domain.goal.PeriodType.directInput;

@Entity
@Getter @Setter
public class SetPrdGoal { // 설정기간목표 객체
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GOALSET_ID")
    private GoalSet goalSet; // 목표설정 : 총 목표기간, 목표종류, 시작일, 종료일

    @ManyToOne
    @JoinColumn(name = "PRDGOAL_ID")
    private PrdGoal prdGoal;  // 기간목표 : 일일목표, 주간목표, 월간목표



    // 완료여부, 달성률, 우선수위
    private Integer progress; // 진행 상황 %
    private Integer completionRate; // 총 달성률 %
    private boolean isCompleted; //완료여부
    private Integer priority; // 우선순위
    private int repeatCycle; // 특정설정기간 반복주기


//    public int repeatPeriod (PrdGoal prdGoal, ChronoUnit unit){
//            prdGoal.getPeriodStartDate()
//        }
//
//    }

}

