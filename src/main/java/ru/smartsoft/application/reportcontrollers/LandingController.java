/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smartsoft.application.reportcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.smartsoft.application.entities.FormRequest;
import ru.smartsoft.application.entities.dao.FormRequestDao;

/**
 *
 * @author arseniy
 */
@Controller
public class LandingController {
    
    
    @RequestMapping("/")
    public String landing(){
        
        return "landing";
    }
}
