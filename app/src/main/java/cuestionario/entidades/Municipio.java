package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 07/04/2017.
 */

public class Municipio extends SugarRecord{
    public Integer entidad;
    public String claveMunicipio;
    public String nombreMunicipio;

    public Municipio(){}

    public Municipio(String claveMunicipio,String nombreMunicipio,Integer entidad){
        this.entidad=entidad;
        this.claveMunicipio=claveMunicipio;
        this.nombreMunicipio=nombreMunicipio;
    }
}
