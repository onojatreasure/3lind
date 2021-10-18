package com.treasureio.line.controllers;

import com.treasureio.line.exception.CheckNotFoundException;
import com.treasureio.line.models.Check;
import com.treasureio.line.services.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CheckController {

    @Autowired
    private CheckService checkService;

    //check similarity and save
    @PostMapping("/checks")
    public Check saveCheck(@Valid @RequestBody Check check) {
        //LOGGER.info("Inside saveCheck of CheckController");
        return checkService.saveCheck(check);
    }

    //
    //Get All Departments
    @GetMapping("/checks")
    public List<Check> fetchCheckList() {
        //LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return checkService.fetchCheckList();
    }

    //Get A check score by ID
    @GetMapping("/checks/{id}")
    public Check fetchChecksById(@PathVariable("id") Long checkId) throws CheckNotFoundException {
        return checkService.fetchCheckById(checkId);
    }

}
