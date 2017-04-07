package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 07/04/2017.
 */

public class Ageb extends SugarRecord{
    String claveGeo;
    String claveLocalidad;
    String claveAgeb;

    public Ageb(){

    }

    public Ageb(String claveGeo, String claveLocalidad,String claveAgeb){
        this.claveGeo=claveGeo;
        this.claveLocalidad=claveLocalidad;
        this.claveAgeb=claveAgeb;
    }
}
