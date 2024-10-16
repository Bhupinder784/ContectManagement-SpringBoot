package com.boss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String name(Model model){

        //Sending data to view
        model.addAttribute("name", "Bhupinder Singh");
        model.addAttribute("profile", "Full stack developer");
        model.addAttribute("gitHubRepo", "https://github.com/Bhupinder784/AddressBook-System");
        return "Home";
    }


    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("About page loading");
        return "About";
    }

    @RequestMapping("/service")
    public String servicePage(){
        System.out.println("Service page loading");
        return "Service";
    }
}
