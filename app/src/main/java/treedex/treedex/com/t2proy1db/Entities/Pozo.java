package treedex.treedex.com.t2proy1db.Entities;

/**
 * Created by Evhanz on 15/11/2015.
 */
public class Pozo {

    public int Id;
    public String nombre;
    public String operador_pozo;
    public String estrella;

    public Pozo() {
        Id = 0;
        this.nombre = "";
        this.operador_pozo = "";
        this.estrella = "";

    }

    public Pozo(int id, String nombre, String operador_pozo, String estrella) {
        Id = id;
        this.nombre = nombre;
        this.operador_pozo = operador_pozo;
        this.estrella = estrella;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOperador_pozo() {
        return operador_pozo;
    }

    public void setOperador_pozo(String operador_pozo) {
        this.operador_pozo = operador_pozo;
    }

    public String getEstrella() {
        return estrella;
    }

    public void setEstrella(String estrella) {
        this.estrella = estrella;
    }
}
