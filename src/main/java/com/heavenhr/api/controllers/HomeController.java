package com.heavenhr.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kingsley Eze.
 * Project: heavenhr
 * Date: 12/25/2017.
 */

@RequestMapping("/")
@RestController
public class HomeController {

    @GetMapping("")
    public String index(){

        return "Welcome to Heaven HR App";
    }
}
