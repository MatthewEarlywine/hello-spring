package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping
public class HelloController {

    //Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //responds to GET requests at "/goodbye"
    //now lives at /hello/goodbye
    @GetMapping ("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    // lives at /hello/hello
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String value){
//            return "Hello " + name + "!";
//    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping ("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name +"!";
    }
    // Also know that you can redirect a user by removing the @ResponseBody annotation
    // from the controller and returning "redirect:/(DESIREDPATH)".


    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String createMessage(@RequestParam String name, @RequestParam String language){
        if(name == null){
            name = "World";
        }

        String greeting = "";

        if (language.equals("Fr")) {
            greeting = "Bonjour, ";
        } else if (language.equals("Sp")) {
            greeting = "Hola, ";
        } else if (language.equals("Ge")) {
            greeting = "Hallo, ";
        } else if (language.equals("Ch")) {
            greeting = "Ni hao, ";
        } else if (language.equals("En")){
            greeting = "Hello ";
        }
        return "<p style='color:blue; text-align:center; margin-top:28px; font-size:38px'>" + greeting + name + "</p>";
    }

    // lives at /hello/form
    @GetMapping ("form")
    public String helloForm(){
        return "form";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String createMessage(@RequestParam String name,@RequestParam String language){
//        if (name == null){
//            name = "World";
//        }
//
//        String greeting = "";
//
//        if(language)
//    }


}
