package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "coachs")
public class Coach implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private int experiencia;//en Años
    @Column
    private String especialidad;
    @OneToOne(mappedBy = "coach")
    private Club club;

    public Coach(String nombre, int experiencia, String especialidad) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
    }
}
