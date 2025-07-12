package hpbao.web.service.goalService;

import hpbao.domain.goal.GoalSet;
import hpbao.domain.goal.SetPrdGoal;
import hpbao.web.repository.GoalSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalScheduler {

    private final GoalSetService goalSetService;
    private final GoalSetRepository goalSetRepository;

    @Scheduled(cron = "0 0 0 * * ?" )// 매일 자정에 실행
    public void updateDailyAchievementRates(){
        List<GoalSet> allGoals = goalSetRepository.findAll();

        for (GoalSet goal : allGoals) {
            double dailyAchievementRate = goalSetService.DailyAchievementRate(goal.getId());
            goal.setDailyAchievementRate(dailyAchievementRate);

            goalSetRepository.save(goal);
        }


    }
}
