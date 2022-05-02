package com.controllers;

import com.model.Intern;
import com.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class InternController {

    @Autowired
    @Qualifier("database1")
    private InternService internService;

    @RequestMapping(value = "/getInternInfo",method = RequestMethod.GET)
    public List<Intern> internDetails(){
        return internService.getInterns();
    }

    @RequestMapping(value = "/createIntern",method = RequestMethod.POST)
    public Intern createIntern(@RequestBody Intern intern){
            return  internService.createIntern(intern);
    }

    @RequestMapping(value = "/deleteIntern",method = RequestMethod.DELETE)
    public Intern deleteIntern(@RequestBody Intern intern){
        return internService.deleteIntern(intern);
    }

    @RequestMapping(value = "/updateIntern",method = RequestMethod.PUT)
    public Intern updateIntern(@RequestBody Intern intern){
        return internService.updateIntern(intern);
    }

}


