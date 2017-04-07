package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 07/04/2017.
 */

public class Entidad extends SugarRecord {
    String nombre;
    Integer clave;

    public Entidad(){

    }

    public Entidad(String nombre, Integer clave){
        this.clave=clave;
        this.nombre=nombre;
    }
}
