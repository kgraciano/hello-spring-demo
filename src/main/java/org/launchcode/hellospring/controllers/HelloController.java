package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//every controller class we make needs a controller annotation


// this request will be shown in the root path since that is the default "/" so it will live in the root path
//@GetMapping
@Controller
public class HelloController {

    @GetMapping("hello") //handles request at path /hello
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }
    @GetMapping("goodbye") //handles request at path /goodbye
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

}
