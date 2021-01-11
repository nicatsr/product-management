package az.product.controller;

import az.product.model.dto.UserDto;
import az.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getRegisterForm(){
        ModelAndView mav = new ModelAndView("web/register");
        UserDto userDto = new UserDto();
        mav.addObject("userDto" , userDto);
        return mav;
    }

    @PostMapping("addUser")
    public ModelAndView addUser(
            @ModelAttribute("userDto")@Valid UserDto userDto,
            BindingResult br
    ){
        ModelAndView mav = new ModelAndView("/web/login");
        if (br.hasErrors()){
            mav.setViewName("web/register");
        }else{
            userService.addUser(userDto);
        }
        return mav;
    }


}
