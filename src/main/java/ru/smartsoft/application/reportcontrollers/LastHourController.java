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
import ru.smartsoft.application.entities.FormRequest;
import ru.smartsoft.application.entities.dao.FormRequestDao;

/**
 *
 * @author arseniy
 */
@Controller
public class LastHourController {
    @Autowired
    FormRequestDao formRequestDao;
    
    @RequestMapping("/last_hour_report")
    public String lastHour(Model model){
        List<FormRequest> formRequests = formRequestDao.getLastHourRequests();
        if(formRequests.isEmpty()){
            formRequests.add(new FormRequest("No activity last hour", "", "", ""));
        }
        model.addAttribute("last_hour_list", formRequests);
        return "last_hour_report";
    }
}
