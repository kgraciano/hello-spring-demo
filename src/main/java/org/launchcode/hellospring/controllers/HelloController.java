package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//every controller class we make needs a controller annotation


// this request will be shown in the root path since that is the default "/" so it will live in the root path
//@GetMapping
@Controller
@ResponseBody
@RequestMapping("hello") //every single controller method within the class will begin with /hello
public class HelloController {

//    @GetMapping("hello") //handles request at path /hello
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //now lives at /hello/goodbye
    @GetMapping("goodbye") //handles request at path /goodbye and calls the method goodbye()
    public String goodbye() {
        return "Goodbye, Spring!";
        //Get request are used only to request data example localhost8080:/goodbye calls the goodbye
        //controller method and returns "Goodbye, Spring!"
    }

    //Query parameters
    // Handles request of the form /hello?name=LaunchCode

    //Some controllers can take in parameters in the form of query strings.
    //query strings are URL data, the key-value pairs
    //@RequestParam annotation notifies spring that the name parameter is going to be in the query parameter(end of URL)
    //a dynamic response will take a piece of data from the request and give a different response based on the value of that data. the example below shows us one way.
    //cannot have 2 different controllers at the same path. first method in this class was commented for the method below to run locally.
//    @GetMapping("hello")
//    @ResponseBody

    //now lives at /hello after value="hello" has been deleted from @Requestingmapping below
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})

    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + name + "!";
    }
//Get requests handlers that accept data other words dynamic
// Handles request of the form /hello/Launchcode
// @PathVariable tells spring that this method is looking for a request to /hello/{name}

    //Now lives at hello/{name} so what ever the path variable is !
    @GetMapping("{name}")
    public String hellowWithPathParam(@PathVariable String name) {
        return "Hello, " + name +"!";
    }
    //Also note that you can redirect a user by removing the @ResponseBody annotation from the controller method and returning "redirect:/DESIREDPATH"

    //Question from the check your understanding
    //working with query parameters and the @RequestParam notation
    @GetMapping("venus")
    public String venusSurface(@RequestParam String terrestrial) {
        if (terrestrial.equals(false)) {
            return "Venus is gaseous";

        } else {
            return "Venus is rocky";

        }
    }

        //Question #2
    //@Path parameters
        @GetMapping("venus/{orbiter}")
        public String venusOrbiter(@PathVariable String orbiter) {
            return orbiter + " currently orbits Venus.";
        }

        //Form submission

    //now lives /hello/form
        @GetMapping("form")
        public String helloForm() {
         return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

         //why exactly does this work?
            //action='hello' refers back to the handler method at path hello?
        // using method='post' it goes to the /hello path without revealing the name in URL localhost8080:/hello did not make a query string
            //using method='get' the URL shows the name parameters. localhost:8080/hello?name=Java
            //always need a controller method that can handle the form submission
            //@RequestMapping can annotate a method to respond to both GET and POST requests.
        }


    }









