package com.engine.tapholes.controller;

import com.engine.tapholes.rules.RegExEngine;
import com.engine.tapholes.utils.Util;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/score/{website}")
    @ResponseBody
    public String method7(@PathVariable("website") String website) {
        Util util = new Util();
        RegExEngine engine = new RegExEngine();
        return util.GetTextFromHTML(website);
    }
}