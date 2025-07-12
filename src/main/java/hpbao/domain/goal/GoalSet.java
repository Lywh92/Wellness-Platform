package hpbao.domain.goal;

import hpbao.domain.caloriekit.CalorieKit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static hpbao.domain.goal.PeriodType.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class GoalSet { // 목표설정객체

    @Id
    @GeneratedValue
    @Column(name = "GOALSET_ID")
    private Long id; // 식별자

    @OneToMany(mappedBy = "goalSet", cascade = CascadeType.ALL)
    private List<SetPrdGoal> setPrdGoals = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CALORIEKIT_ID")
    private CalorieKit calorieKit;

    private String GoalContent; //목표내용
    @Enumerated(EnumType.STRING)
    private GoalType goalType; // 목표종류

    //    private long goalPeriod; // 목표기간
    private LocalDate startDate; // 시작일
    private LocalDate endDate; // 종료일
    private  long  goalDay; // 달성일
    private ChronoUnit unit;
    private LocalTime goalByTime; //목표시간
    private double targetValue; // 목표값
    private double currentValue; // 현재 진행값
    private double dailyAchievementRate; // 일일 달성률

    public GoalSet() {

    }

    ;


}