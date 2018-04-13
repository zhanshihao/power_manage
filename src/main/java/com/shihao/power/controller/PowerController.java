package com.shihao.power.controller;

import com.shihao.power.common.JsonResult;
import com.shihao.power.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PowerController {

    @Autowired
    private PowerService powerService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping
    public JsonResult index(){
        JsonResult msg = new JsonResult();
        return msg;
    }
}
