package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }


    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

        //Form submission
        @GetMapping("form")
        public String helloForm() {
        return "form";
    }
//dynamic views is when contents are changed when data is entered per requests


    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);


        return "helloList";
    }

    @GetMapping("coffee-list")
    public String coffeeNames(Model model) {
        List<String> coffeeOptions = new ArrayList<>();
        coffeeOptions.add("Black coffee");
        coffeeOptions.add("frappe");
        coffeeOptions.add("Iced coffee");
        model.addAttribute("coffeeOptions", coffeeOptions);
        return "coffeeList";
    }

    }









