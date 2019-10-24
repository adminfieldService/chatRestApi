package com.spinku.userRestApi.controller;

import java.util.Date;

import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class ViewController {
	private final String appMode;

    public ViewController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Tester");
        model.addAttribute("mode", appMode);

        return "index";
    }
}
