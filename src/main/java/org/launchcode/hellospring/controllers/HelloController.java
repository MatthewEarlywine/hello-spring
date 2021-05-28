package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
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
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping ("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting",  "Hello, " + name + "!");
        return "hello";
    }
    // Also know that you can redirect a user by removing the @ResponseBody annotation
    // from the controller and returning "redirect:/(DESIREDPATH)".


    // lives at /hello/form
    @RequestMapping(value = "form", method={RequestMethod.GET, RequestMethod.POST})
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
