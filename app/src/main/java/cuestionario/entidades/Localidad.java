package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 07/04/2017.
 */

public class Localidad extends SugarRecord{
    public String claveMunicipio;
    public String claveLocalidad;
    public String nombreLocalidad;

    public Localidad(){

    }
    public Localidad(String claveMunicipio,String claveLocalidad,String nombreLocalidad){
        this.claveLocalidad=claveLocalidad;
        this.claveMunicipio=claveMunicipio;
        this.nombreLocalidad=nombreLocalidad;
    }

}
