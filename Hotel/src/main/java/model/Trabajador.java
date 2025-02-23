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
@Table(name="empleados")
@NamedQuery(name="Trabajador.findAll",query = "FROM Trabajador")
@NamedQuery(name="Trabajador.findAllByLocalidad",query = "FROM Trabajador t WHERE t.direccion.localidad=:localidad")
@NamedQuery(name="Trabajador.findAllByProvincia",query = "FROM Trabajador t WHERE t.direccion.provincia=:provincia")

public class Trabajador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Embedded
    private Direccion direccion;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="localidad",column = @Column(name="localidad2")),
            @AttributeOverride(name="provincia",column = @Column(name="provincia2"))
    })
    private Direccion direccion2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    @Column
    private int telefono;

    @ManyToMany(mappedBy = "listaTrabajadores",fetch = FetchType.EAGER)
    private List<Cliente>listaClientes;

    public Trabajador(String nombre, String apellido, Direccion direccion, Direccion direccion2, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.direccion2 = direccion2;
        this.telefono = telefono;
    }

    public Trabajador(String nombre, String apellido, Direccion direccion, Direccion direccion2, Habitacion habitacion, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.direccion2 = direccion2;
        this.habitacion = habitacion;
        this.telefono = telefono;
    }

    public Trabajador(int id) {
        this.id = id;
    }

   // @Override

   /* public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }*/

    @Override
    public String toString() {
        return "Trabajador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion=" + direccion +
                ", direccion2=" + direccion2 +
                ", telefono=" + telefono +
                '}';
    }
}
