package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@ResponseBody
@RequestMapping("hello")
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

    //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("message")
    public String createMessage(@RequestParam String name, @RequestParam String languages) {
        String greeting = "";
        if (languages.equals("english")) {
            greeting = "Hello, " + name + "!";

        } else if (languages.equals("spanish")) {
            greeting = "Hola, " + name + "!";
        } else if (languages.equals("german")) {
            greeting = "Hallo, " + name + "!";
        } else if (languages.equals("czech")) {
            greeting = "Ahoj, " + name + "!";
        } else if (languages.equals("portuguese")) {
            greeting = "Olá, " + name + "!";
        }

        return greeting;
    }



    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello/message' method = 'post'>" +
                "<input type = 'text' name = 'name' > " +
                "<select name = 'languages' id = 'lang-select'>" +
                "<option value = 'english'> English </option>" +
                "<option value = 'spanish'> Spanish </option>" +
                "<option value = 'german'> German </option>" +
                "<option value = 'czech'> Czech </option>" +
                "<option value = 'portuguese'> Portuguese </option>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }






    }









