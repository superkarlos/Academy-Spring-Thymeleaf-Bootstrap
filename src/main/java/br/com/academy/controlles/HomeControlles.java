package br.com.academy.controlles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.model.AlunoEntity;

@RestController

public class HomeControlles {

    @GetMapping("/home")
    public ModelAndView index(){
        ModelAndView  mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("aluno", new AlunoEntity());
        return mv;
    }
    
}
