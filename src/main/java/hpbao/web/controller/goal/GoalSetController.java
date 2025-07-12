package hpbao.web.controller.goal;

import hpbao.domain.goal.GoalSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class GoalSetController {

    @GetMapping("/goalset")
    public String goalSet(Model model) {

        model.addAttribute("goalset", new GoalSet());

        return "goal/goalSet";
    };
}
