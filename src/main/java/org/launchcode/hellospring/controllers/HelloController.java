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
    // Handles request of the form /hello?name=LaunchCode
    //Path parameters video
    //Some controllers can take in parameters in the form of query strings.
    //query strings are URL data, the key-value pairs
    //@RequestParam annotation notifies spring that the name parameter is going to be in the query parameter(end of URL)
    //a dynamic response will take a piece of data from the request and give a different response based on the value of that data. the example below shows us one way.
    //cannot have 2 different controllers at the same path. first method in this class was commented for the method below to run locally.
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + name + "!";
    }
// i did not add this to the correct branch i pushed it to static-response instead of query parameters branch
    //committing and created the query param branch
}
