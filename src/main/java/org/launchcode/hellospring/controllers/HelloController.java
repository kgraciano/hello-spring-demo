package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//every controller class we make needs a controller annotation


// this request will be shown in the root path since that is the default "/" so it will live in the root path
//@GetMapping
@Controller
public class HelloController {

//    @GetMapping("hello") //handles request at path /hello
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    @GetMapping("goodbye") //handles request at path /goodbye and calls the method goodbye()
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
        //Get request are used only to request data example localhost8080:/goodbye calls the goodbye
        //controller method and returns "Goodbye, Spring!"
    }


    //Query parameters

    // Handles request of the form /hello?name-LaunchCode
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

}
