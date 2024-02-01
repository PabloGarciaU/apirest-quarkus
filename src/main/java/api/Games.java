package api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nombre;
    public String fecha;
    public String puntuacion;

    public Games() {
    }

    public Games(String nombre, String fecha, String puntuacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.puntuacion = puntuacion;
    }
}