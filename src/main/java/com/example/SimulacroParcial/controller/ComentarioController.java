package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.ComentarioRepository;
import com.example.SimulacroParcial.interfaces.PublicacionRepository;
import com.example.SimulacroParcial.models.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@Controller
@RequestMapping("/commit")
public class ComentarioController {

    @Autowired
    ComentarioRepository repository;
    @Autowired
    PublicacionRepository repopub;

    @PostMapping("/{id}")
    public void add(@RequestBody Comentario c, @PathVariable int id){
        c.setPublicacion(repopub.getOne(id));
        repository.save(c);
    }

    @GetMapping("")
    public List<Comentario> getAll(){
        List<Comentario> pub = repository.findAll();
        return pub;
    }

    @PostMapping("/delete/{id}")
    public  void eliminar(@PathVariable int id){
        repository.deleteById(id);
    }


    @Scheduled(fixedDelay = 20000)
    public void borrarcommit(){
        List<Comentario> com = repository.findAll();
        for(Comentario c : com){
             

        }
    }
}
