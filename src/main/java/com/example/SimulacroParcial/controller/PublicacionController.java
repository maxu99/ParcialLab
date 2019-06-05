package com.example.SimulacroParcial.controller;
import com.example.SimulacroParcial.interfaces.PublicacionRepository;
import com.example.SimulacroParcial.interfaces.UsuarioRepository;
import com.example.SimulacroParcial.models.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {

    @Autowired
    PublicacionRepository repository;
    @Autowired
    UsuarioRepository repouser;

    @PostMapping("/{id}")
    public void add(@RequestBody Publicacion p, @PathVariable int id){

        p.setUser(repouser.getOne(id));
        repository.save(p);
    }

    @GetMapping("")
    public List<Publicacion> getAll(){
        List<Publicacion> pub = repository.findAll();
        return pub;
    }
}
