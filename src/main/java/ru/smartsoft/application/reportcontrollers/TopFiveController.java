/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.reportcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.smartsoft.application.entities.FormCounter;
import ru.smartsoft.application.entities.dao.FormCounterDao;

/**
 *
 * @author arseniy
 */
@Controller
public class TopFiveController {
    @Autowired
    FormCounterDao formCounterDao;
    
    @RequestMapping("/forms_top_5")
    public String topFive(Model model){
        List<FormCounter> formCounters = formCounterDao.getTop5forms();
        model.addAttribute("formCounters", formCounters);
        return "forms_top_5";
    }
    
}
