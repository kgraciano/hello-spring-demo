package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    //    @GetMapping("hello") //handles request at path /hello
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //with @RequestMapping("hello") being at class level, the path will always begin with /hello
    //This now lives /hello/goodbye since we use @GetMapping("goodbye") on the method itself

    @GetMapping("goodbye") //handles request at path /goodbye and calls the method goodbye()
    public String goodbye() {
        return "Goodbye, Spring!";

    }


    //this method now lives at /hello since we have to value inside of @RequestMapping
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String friend) {

        return "Hello, my name is " + name + ", and this is my friend " + friend + "!";
    }


//    @GetMapping("{name}")
//    public String hellowWithPathParam(@PathVariable String name) {
//        return "Hello, " + name +"!";
//    }



    //lives at /hello/form

    //Form submission
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='text' name='friend'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";


    }


    }









