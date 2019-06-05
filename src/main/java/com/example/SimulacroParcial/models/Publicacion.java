package com.example.SimulacroParcial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Publicacion {
    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private String foto;
    private  LocalDate fecha;
    private int liked;


    @PrePersist
    public void fechear(){
        if(this.fecha == null){
            this.fecha= LocalDate.now();
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuario_id", referencedColumnName = "id")
    @JsonIgnore
    @ToString.Exclude
    private Usuario user;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "publicacion")
    private List<Comentario> comentarios;
}
