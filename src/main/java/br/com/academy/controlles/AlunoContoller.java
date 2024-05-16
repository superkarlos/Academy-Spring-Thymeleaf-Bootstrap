package br.com.academy.controlles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.AlunoRepository;
import br.com.academy.model.AlunoEntity;

@RestController

public class AlunoContoller {

    @Autowired 
    private AlunoRepository repository;
    
    @GetMapping("/inserirAlunos")
    public ModelAndView insertAlunos( AlunoEntity aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/formAluno");
        mv.addObject("aluno", new AlunoEntity());
        return mv;

    }

    @PostMapping("/insertAlunos")
    public ModelAndView cadastrarAluno( AlunoEntity aluno){
    aluno.setNome(aluno.getNome().toUpperCase());
    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:/adicionados");
    repository.save(aluno);
    return mv;
    }

    @GetMapping("/adicionados")
    public ModelAndView listagemAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/listaAlunos");
        mv.addObject("lista_alunos", repository.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable ("id")  Long id){
       
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alterar");
        Optional<AlunoEntity> optional=  this.repository.findById(id);
        AlunoEntity aluno = optional.get();
        mv.addObject("aluno", aluno);

        return mv;
        
    }

    @PostMapping("/alterar")
    public ModelAndView alterar( AlunoEntity aluno){
    ModelAndView mv = new ModelAndView();
    aluno.setNome(aluno.getNome().toUpperCase());
    repository.save(aluno);
    mv.setViewName("redirect:/adicionados");
    return mv;
    }



    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable ("id")  Long id,AlunoEntity aluno){
       ModelAndView mv = new ModelAndView();
       repository.delete(aluno);
       mv.setViewName("redirect:/adicionados");
       return mv;
           
    }
   
}




