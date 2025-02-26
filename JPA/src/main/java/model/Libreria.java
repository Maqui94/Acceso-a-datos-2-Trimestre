package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "librerias")
public class Libreria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String dueno;
    @Column
    private String direccion;
    @ManyToMany(mappedBy = "librerias",fetch = FetchType.EAGER)
    private List<Libro> libros;
    public Libreria(String nombre, String dueno, String direccion) {
        this.nombre = nombre;
        this.dueno = dueno;
        this.direccion = direccion;
    }
}
