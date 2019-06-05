package com.example.SimulacroParcial.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {
    @Id
    @GeneratedValue
    private int id;
    private String descripcion;
    private LocalDate fecha;
    private String owner;

    @PrePersist
    public void fechear(){
        if(this.fecha == null){
            this.fecha= LocalDate.now();
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Publicacion_id", referencedColumnName = "id")
    @JsonIgnore
    @ToString.Exclude
    private Publicacion publicacion;



}


