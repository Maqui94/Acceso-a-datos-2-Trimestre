package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "clubs")
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String ubicacion;
    @Column
    private LocalDate fundacion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coach")
    private Coach coach;
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    private List<Atleta> atletas;


    public Club(String nombre, String ubicacion, LocalDate fundacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fundacion = fundacion;
    }

    public Club(String nombre, String ubicacion, LocalDate fundacion, Coach coach) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.fundacion = fundacion;
        this.coach = coach;
    }
}
