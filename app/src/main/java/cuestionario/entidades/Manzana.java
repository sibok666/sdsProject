package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 07/04/2017.
 */

public class Manzana extends SugarRecord {
    public String claveAgeb;
    public String claveManzana;
    public String zap;

    public Manzana(){

    }
    public Manzana(String claveAgeb,String claveManzana,String zap){
        this.claveAgeb=claveAgeb;
        this.claveManzana=claveManzana;
        this.zap=zap;
    }

}
