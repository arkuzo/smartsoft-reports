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
public class UncompletedActivityController {
    
    @Autowired
    FormRequestDao formRequestDao;
    
    @RequestMapping("/uncompleted_activity_report")
    public String uncomleted(Model model){
        List<FormRequest> formRequests = formRequestDao.getUncompletedRequests();
        if(formRequests.isEmpty()){
            formRequests.add(new FormRequest("All requests is completed", "", "", ""));
        }
        model.addAttribute("uncompleted_requests", formRequests);
        return "uncompleted_activity_report";
    }
    
}
