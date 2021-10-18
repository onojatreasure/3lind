package com.treasureio.line.controllers;

import com.treasureio.line.models.Check;
import com.treasureio.line.services.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CheckController {

    @Autowired
    private CheckService checkService;

    //Save a check
    @PostMapping("/checks")
    public Check saveCheck(@Valid @RequestBody Check check) {
        //LOGGER.info("Inside saveCheck of CheckController");
        return checkService.saveCheck(check);
    }

}
