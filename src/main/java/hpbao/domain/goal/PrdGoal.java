package hpbao.domain.goal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class PrdGoal { // 기간목표
    @Id @GeneratedValue
    @Column(name = "PRDGOAL_ID")
    private Long id;

    @OneToMany(mappedBy = "prdGoal")
    private List<SetPrdGoal> setPrdGoals = new ArrayList<>();

//    private String dayGoal; //일일 목표
//    private String weekGoal; // 주간 목표
//    private String monGoal; // 월간 목표

    @Enumerated(EnumType.STRING)
    private PeriodType periodType; // 일일, 주간, 월간, 직접입력, 특정기간
    private String description; // 구체적인 목표정의
    private LocalDate periodStartDate; // 기간목표 시작일
    private LocalDate periodEndDate; // 기간목표 종료일
    private int recurrence; //기간 반복주기
    // 총 달성률 , 우선수위(중요도), 완료 여부

//    public int achievePeriod(LocalDate periodStartDate, LocalDate periodEndDate){
//        periodStartDate.plus(periodEndDate.)
//    }


}
