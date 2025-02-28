package model;

import database.HibernateUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "atletas")
public class Atleta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private double peso;
    @Column
    private String sexo;
    @Column
    private int rm_snatch;//RM es igual a repetición máxima con ese peso, record personal
    @Column
    private int rm_clean_jerk;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_club")
    private Club club;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "participaciones", joinColumns = @JoinColumn(name = "id_atleta")
            , inverseJoinColumns = @JoinColumn(name = "id_competicion"))
    private List<Competicion> competiciones;

    public Atleta(String nombre, double peso, String sexo, int rm_snatch, int rm_clean_jerk) {
        this.nombre = nombre;
        this.peso = peso;
        this.sexo = sexo;
        this.rm_snatch = rm_snatch;
        this.rm_clean_jerk = rm_clean_jerk;
    }





}
