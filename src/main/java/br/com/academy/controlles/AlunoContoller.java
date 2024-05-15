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
        System.out.println("entroi");
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

    @GetMapping("/deletar/{id}")
   public ResponseEntity<Object> dEntity(@PathVariable(value = "id") Long id) throws Exception{
    Optional<AlunoEntity> aluno = this.repository.findById(id);

    if (aluno.isPresent()) {
        this.repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado");
    } else {
        throw new Exception("uo não encontrado");
    }
}



}
