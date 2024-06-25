package br.com.academy.controlles;

import java.util.Optional;
import java.util.List;

import org.hibernate.query.results.Builders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.academy.dao.AlunoRepository;
import br.com.academy.dto.Alunodto;
import br.com.academy.model.AlunoEntity;
import jakarta.validation.Valid;

@RestController

public class AlunoContoller implements WebMvcConfigurer {
    @Autowired
    private AlunoRepository repository;

    @PostMapping("/form")
    public ModelAndView form(@Valid AlunoEntity aluno) {
        ModelAndView mv = new ModelAndView();
        System.out.println(aluno);
        mv.setViewName("redirect:/alterar/{id}");
        return mv;
    }

    @GetMapping("/inserirAlunos")
    public ModelAndView insertAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/formAluno");
        AlunoEntity aluno = new AlunoEntity();
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("/insertAlunos")
    public ModelAndView cadastrarAluno(@Valid Alunodto alunodto, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        AlunoEntity aluno = new AlunoEntity();

        BeanUtils.copyProperties(alunodto, aluno);

        if (br.hasErrors()) { // caso
            // System.out.println(br.hasErrors());
            // System.out.println(br.toString());
            mv.setViewName("/aluno/formAluno");
            // System.out.println(aluno.hashCode());
            mv.addObject("aluno", aluno);
            System.out.println(alunodto);
            System.out.println(aluno);
            return mv;

        } else {

            aluno.setNome(aluno.getNome().toUpperCase());

            this.repository.save(aluno);
            mv.setViewName("redirect:/adicionados");

            return mv;

        }
    }

    @GetMapping("/adicionados")
    public ModelAndView listagemAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/listaAlunos");
        mv.addObject("lista_alunos", repository.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<AlunoEntity> optional = this.repository.findById(id);
        AlunoEntity aluno = optional.get();
        mv.addObject("aluno", aluno);
        mv.setViewName("aluno/alterar");
        return mv;

    }

    @PostMapping("/alterar")
    public ModelAndView alterar(@Valid AlunoEntity aluno) {
        ModelAndView mv = new ModelAndView();
        aluno.setNome(aluno.getNome().toUpperCase());
        this.repository.save(aluno);
        mv.setViewName("redirect:/adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluir(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        Optional<AlunoEntity> aluno = this.repository.findById(id);
        repository.delete(aluno.get());
        mv.setViewName("redirect:/adicionados");
        return mv;

    }

    @GetMapping("/filtro")
    public ModelAndView fitrar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/filtroAlunos");
        return mv;
    }

    @GetMapping("/ativos")
    public ModelAndView listagemAlunosAtivos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/ativos");
        mv.addObject("lista_alunos", repository.findByStatusAtivos());
        System.out.println(repository.findByStatusAtivos());
        return mv;
    }

    @GetMapping("/inativos")
    public ModelAndView listagemAlunosIntivos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/ativos");
        mv.addObject("lista_alunos", repository.findByStatusInativos());
        System.out.println(repository.findByStatusAtivos());
        return mv;
    }

    @GetMapping("/cancelados")
    public ModelAndView listagemAlunosInativos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/cancelados");
        mv.addObject("lista_alunos", repository.findByStatusCancelados());
        System.out.println(repository.findByStatusAtivos());
        return mv;
    }

    @GetMapping("/trancados")
    public ModelAndView listagemAlunosTrancados() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/trancados");
        mv.addObject("lista_alunos", repository.findByStatusTrancados());
        System.out.println(repository.findByStatusAtivos());
        return mv;
    }

    @GetMapping("/encontrar")
    public ModelAndView encontrar(Model model) {
        ModelAndView mv = new ModelAndView();
        /// model.addAttribute("aluno", new AlunoEntity());
        mv.setViewName("aluno/encontrar");
        return mv;

    }

    @PostMapping("/encontrar")
    public ModelAndView listagemEncontrtados(@RequestParam(required = false) String nome) {

        String nome_ = nome.replaceAll("\\s+", "");
        System.out.println(nome_);
        System.err.println(nome);

        ModelAndView mv = new ModelAndView();
        if (nome_ == null || nome_.trim().isEmpty()) {
            mv.addObject("error", "Nome não pode ser vazio");
            mv.setViewName("");
            return mv;
        }
        List<AlunoEntity> lista = this.repository.findByNomeContainingIgnoreCase(nome_);

        mv.addObject("lista", lista);
        // mv.addObject(nome);
        mv.setViewName("aluno/pesquisaPorNome");
        return mv;
    }

}
