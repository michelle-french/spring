package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

//  lives at /hello/goodbye
//    @GetMapping("goodbye")
//    public String goodbye(){
//        return "Goodbye, Spring!";
//    }

//    Handles request of the form /hello?name=LaunchCode
//    lives at /hello/hello
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }

//    Handles request of the form/hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    // lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                 "<body>" +
                     "<form action='hello' method='post'>" +
                         "<input type='text' name='name'>" +
                            "<select name=\"lang\" id=\"lang\">\n" +
                            "    <option value=\"\">--Please choose a language--</option>\n" +
                            "    <option value=\"hindi\">Hindi</option>\n" +
                            "    <option value=\"italian\">Italian</option>\n" +
                            "    <option value=\"german\">German</option>\n" +
                            "    <option value=\"spanish\">Spanish</option>\n" +
                            "    <option value=\"french\">French</option>\n" +
                            "    <option value=\"english\">English</option>\n" +
                            "</select>" +
                         "<input type='submit' value='Greet me!'>" +
                    "</form>" +
                "</body>" +
              "</html>";
    }
    @RequestMapping(value="hello", method = {RequestMethod.POST})
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String lang) {
        if (name == null) {
            name = "World";
        }return createMessage(name, lang);
    }

    public static String createMessage(String name, String lang) {
        String greeting="";

        if(lang.equals("hindi")) {
            greeting = "Namaste ";
        }else if(lang.equals("italian")) {
            greeting = "Cioa ";
        }else if(lang.equals("german")) {
            greeting = "Guten Tag ";
        }else if(lang.equals("spanish")) {
            greeting = "Hola ";
        }else if(lang.equals("french")) {
            greeting = "Bonjour ";
        }else if(lang.equals("english")) {
            greeting = "Hello ";
        }
        return greeting + name + "!";
    }
}

