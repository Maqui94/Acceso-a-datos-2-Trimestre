package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "competiciones")
public class Competicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private LocalDate fecha;
    @Column
    private String ubicacion;

    @ManyToMany(mappedBy = "competiciones",fetch = FetchType.EAGER)
    private List<Atleta> atletas;

    public Competicion(String nombre, LocalDate fecha, String ubicacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }
    public boolean perteneceCategoriaHombre(double peso, String categoria) {
        switch (categoria) {
            case "Menos de 61 kg": return peso < 61;
            case "61 kg - 67 kg": return peso >= 61 && peso < 67;
            case "67 kg - 73 kg": return peso >= 67 && peso < 73;
            case "73 kg - 81 kg": return peso >= 73 && peso < 81;
            case "81 kg - 89 kg": return peso >= 81 && peso < 89;
            case "89 kg - 96 kg": return peso >= 89 && peso < 96;
            case "96 kg - 102 kg": return peso >= 96 && peso < 102;
            case "Más de 102 kg": return peso >= 102;
            default: return false;
        }
    }

    public boolean perteneceCategoriaMujer(double peso, String categoria) {
        switch (categoria) {
            case "Menos de 49 kg": return peso < 49;
            case "49 kg - 55 kg": return peso >= 49 && peso < 55;
            case "55 kg - 59 kg": return peso >= 55 && peso < 59;
            case "59 kg - 64 kg": return peso >= 59 && peso < 64;
            case "64 kg - 71 kg": return peso >= 64 && peso < 71;
            case "71 kg - 76 kg": return peso >= 71 && peso < 76;
            case "76 kg - 81 kg": return peso >= 76 && peso < 81;
            case "Más de 81 kg": return peso >= 81;
            default: return false;
        }
    }
}
