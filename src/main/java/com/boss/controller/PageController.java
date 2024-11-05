package com.boss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boss.entities.User;
import com.boss.forms.UserForm;
import com.boss.services.UserService;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String name(Model model) {
        // Sending data to view
        model.addAttribute("name", "Bhupinder Singh");
        model.addAttribute("profile", "Full stack developer");
        model.addAttribute("gitHubRepo", "https://github.com/Bhupinder784/AddressBook-System");
        return "Home";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", false);
        System.out.println("About page loading");
        return "About";
    }

    @RequestMapping("/service")
    public String servicePage() {
        System.out.println("Service page loading");
        return "Service";
    }

    @RequestMapping("/contact")
    public String contactPage() {
        System.out.println("Contact page loading");
        return "Contact";
    }

    @RequestMapping("/login")
    public String loginPage() {
        System.out.println("Login page loading");
        return "Login";
    }

    @RequestMapping("/signup")
    public String registerPage(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Bhupinder");
        // userForm.setEmail("bhupinder@gmail.com");
        // userForm.setPassword("123Bhupsi@");
        // userForm.setPhoneNumber("1234567890");
        // userForm.setAbout("<p>Lorem ipsum dolor sit amet consectetur adipisicing
        // elit. Placeat, ut!</p>");
        model.addAttribute("userForm", userForm);
        System.out.println("SignUp page loading");
        return "Register";
    }

    // Processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        // Fetch from data
        // Userform
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .profilePic("https://images.pexels.com/photos/8307424/pexels-photo-8307424.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1")
                .build();

        User saveUser = userService.saveUser(user);
        // Validate Form data
        // Save Data
        // Message register successful
        // Redirect Login page
        return "redirect:/signup";
    }
}
