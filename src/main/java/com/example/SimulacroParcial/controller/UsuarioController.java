package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.interfaces.ComentarioRepository;
import com.example.SimulacroParcial.interfaces.PublicacionRepository;
import com.example.SimulacroParcial.interfaces.UsuarioRepository;
import com.example.SimulacroParcial.models.Comentario;
import com.example.SimulacroParcial.models.Publicacion;
import com.example.SimulacroParcial.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;


    public String getHead( HttpServletRequest request) {

        return request.getHeader("user-agent");
    }

    @PostMapping("")
    public void add(@RequestBody Usuario u,HttpServletRequest request){

        u.setBrowser(getHead(request));
        repository.save(u);
    }


    @GetMapping("")
    public List<Usuario> getAll(){
        List<Usuario> users = repository.findAll();
        return users;
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getbyid(@PathVariable int id){
        return repository.findById(id);
    }


    @PatchMapping("modificar/{id}")
    public void modify(@RequestBody Usuario u,@PathVariable int id){
        Usuario aux = repository.getOne(id);
        aux.setNombre(u.getNombre());
        aux.setApellido(u.getApellido());
        repository.save(aux);

    }

    @PostMapping("/delete/{id}")
    public  void eliminar(@PathVariable int id){
        repository.deleteById(id);
    }


}
