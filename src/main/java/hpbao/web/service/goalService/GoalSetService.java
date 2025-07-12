package hpbao.web.service.goalService;

import hpbao.domain.goal.GoalSet;
import hpbao.web.repository.GoalSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class GoalSetService {

    private final GoalSetRepository goalSetRepository;

    public double DailyAchievementRate(Long goalSetId){

        // 1. 목표 조회
        GoalSet goal = goalSetRepository.findById(goalSetId).orElseThrow(() -> new GoalNotFoundException("Goal not found with ID: " + goalSetId));

            // 2. 목표의 현재 값, 목표 값, 시작일, 종료일 가져오기
            double currentValue = goal.getCurrentValue();   // 현재까지 달성한 값
            double targetValue = goal.getTargetValue();     // 목표 값
            LocalDate startDate =goal.getStartDate() ;      // 목표 시작일
            LocalDate endDate = goal.getEndDate();          // 목표 종료일

            // 3. 남은 기간 계산
            long totalDays = ChronoUnit.DAYS.between(startDate, endDate); // 전체 기간 (예: 30일)
            long daysPassed = ChronoUnit.DAYS.between(startDate, LocalDate.now()); // 현재까지 경과한 기간
            long daysRemaining = totalDays - daysPassed; // 남은 기간 (예: 10일 남음)

            // 4. 현재까지의 예상 달성률 계산
            double expectedValueByNow = (targetValue / totalDays) * daysPassed;  // 현재까지 달성해야 할 값

            // 5. 결과 반환
            return (currentValue / expectedValueByNow) * 100;
        }
    };


