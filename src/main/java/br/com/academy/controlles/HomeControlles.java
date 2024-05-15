package br.com.academy.controlles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class HomeControlles {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView  mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("variavel","conteudo do cotroller");
        return mv;
    }
    
}
