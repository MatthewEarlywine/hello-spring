package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class HelloController {

    //Handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //responds to GET requests at "/goodbye"
    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    // lives at /hello/hello
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello " + name + "!";
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
        if(name == null){
            name = "World";
        }

        String greeting = "";

        if (language.equals("french")) {
            greeting = "Bonjour, ";
        } else if (language.equals("spanish")) {
            greeting = "Hola, ";
        } else if (language.equals("german")) {
            greeting = "Hallo, ";
        } else if (language.equals("chinese")) {
            greeting = "Ni hao, ";
        } else if (language.equals("english")){
            greeting = "Hello ";
        }
        return "<p style='color:blue; text-align:center; margin-top:28px; font-size:38px'>" + greeting + name + "</p>";
    }

    // lives at /hello/form
//    @GetMapping ("form")
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action='hello' method='post'>" + // submits request to /hello
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form?" +
//                "</body>" +
//                "</html>";
//    }


        @GetMapping ("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + // submits request to /hello
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='french'>French</option>" +
                "<option value='chinese'>Chinese</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
