package io.spring.springboot.Controller;

import io.spring.springboot.Entity.User;
import io.spring.springboot.Repository.UserRepository;
import io.spring.springboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String home(Model model){
        model.addAttribute("listUser",userService.getAllUser());
        return "index";
    }

    @GetMapping("/showAddNewUser")
    public String showAddNewUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "add";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin/list";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable(value = "id") long id,Model model){
        User user = userService.getUserId(id);
        model.addAttribute("user",user);
        return "update";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id){
        this.userService.deleteUserById(id);
        return "redirect:/admin/list";
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
}
