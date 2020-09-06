package br.com.concord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.concord.model.User;
import br.com.concord.service.IUserService;
import br.com.concord.service.UserService;

@Controller
public class UserController 
{
	@Autowired
    private UserService userService;

    @GetMapping("/showUsers")
    public String findUsers(Model model) {

        List<User> users = (List<User>) userService.findAll();

        model.addAttribute("users", users);

        return "showUsers";
    }
}
