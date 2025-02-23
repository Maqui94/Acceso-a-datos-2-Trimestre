package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int planta;
    @Column
    private int numero;
    @Column
    private int capacidad;

    @OneToOne(mappedBy = "habitacion")
    private Trabajador trabajador;
    @OneToMany(mappedBy = "habitacion")
    private List<Cliente>lista;

    public Habitacion(int planta, int numero, int capacidad) {
        this.planta = planta;
        this.numero = numero;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", planta=" + planta +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                '}';
    }
}
