package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
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
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name +"!";
    }
    // Also know that you can redirect a user by removing the @ResponseBody annotation
    // from the controller and returning "redirect:/(DESIREDPATH)".


    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String createMessage(@RequestParam String name, @RequestParam String language){
        if (language.equals("Fr")) {
            return "Bonjour " + name + "!";
        } else if (language.equals("Sp")) {
            return "Hola " + name + "!";
        } else if (language.equals("Ge")) {
            return "Hallo " + name + "!";
        } else if (language.equals("Ch")) {
            return "Ni hao " + name + "!";
        } else {
            return "Hello " + name + "!";
        }

    }

    // lives at /hello/form
    @GetMapping ("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submits request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='En'> English </option>" +
                "<option value='Fr'> French </option>" +
                "<option value='Sp'> Spanish </option>" +
                "<option value='Ge'> German </option>" +
                "<option value='Ch'> Chinese </option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form?" +
                "</body>" +
                "</html>";
    }

}
