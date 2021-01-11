package az.product.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public ModelAndView login(){
        return new ModelAndView("web/index");
    }


    @GetMapping("login")
    public String getLoginPage(){
        return "web/login";
    }
}
