package com.example.demoassignment.Controller;

import com.example.demoassignment.Domain.UserModel;
import com.example.demoassignment.Service.UserService;
import com.example.demoassignment.exception.FieldMissMatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("signup")
    public String showformRegister(Model model){
        model.addAttribute("user", new UserModel());
        return "Register";
    }
    @PostMapping("signup")
    public String registerAcount(@ModelAttribute("user")UserModel userModel) throws FieldMissMatchException {
        try {
            userService.save(userModel);
            return "redirect:/signup?success";
        } catch (FieldMissMatchException e){
            return "redirect:/signup?failed";
        }
    }
    @GetMapping("login")
    public String index(){
        return "Login";
    }

}
