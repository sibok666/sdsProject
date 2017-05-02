package cuestionario.entidades;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by asuarezr on 02/05/2017.
 */

public class EncuestaSeguimiento extends SugarRecord implements Serializable {
    public Date fecharecepcion;
    public String terminado;
    public String curp;
    public String latitud;
    public String longitud;
    public String ageb;
    public String folioUnico;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public String nombre;
    public String vialidad;
    public String noExterior;
    public String localidad;
    public byte []fotografiaBeneficiario;
    public byte []fotografiaIne;
    public byte []fotografiaInicio;
    public byte []imagenFirma;
    public byte []fotografiaDurante1;
    public byte []fotografiaDurante2;
    public byte []fotografiaDurante3;
    public byte []fotografiaDurante4;
    public byte []fotografiaDurante5;
    public byte []fotografiaFinal;
    public Integer guardadoBdRemota;


    //FOLIO UNICO,PATERNO,MATERNO,NOMBRE,VIALIDAD,NUMERO EXTERIOR,LOCALIDAD,

    public EncuestaSeguimiento(){

    }

    public EncuestaSeguimiento(Date fecharecepcion,String terminado,String curp,String latitud,
            String longitud,String ageb,String folioUnico,String apellidoPaterno,String apellidoMaterno,
            String nombre,String vialidad,String noExterior,String localidad, byte fotografiaBeneficiario[],
                               byte []fotografiaIne,byte []fotografiaInicio,byte []imagenFirma,
                                       byte []fotografiaDurante1,byte []fotografiaDurante2,
                                       byte []fotografiaDurante3,byte []fotografiaDurante4,
                                       byte []fotografiaDurante5,byte []fotografiaFinal,Integer guardadoBdRemota){

        this.fecharecepcion=fecharecepcion;
        this.terminado=terminado;
        this.curp=curp;
        this.latitud=latitud;
        this.longitud=longitud;
        this.ageb=ageb;
        this.folioUnico=folioUnico;
        this.apellidoPaterno=apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.nombre=nombre;
        this.vialidad=vialidad;
        this.noExterior=noExterior;
        this.localidad=localidad;
        this.fotografiaBeneficiario=fotografiaBeneficiario;
        this.fotografiaIne=fotografiaIne;
        this.fotografiaInicio=fotografiaInicio;
        this.imagenFirma=imagenFirma;
        this.fotografiaDurante1=fotografiaDurante1;
        this.fotografiaDurante2=fotografiaDurante2;
        this.fotografiaDurante3=fotografiaDurante3;
        this.fotografiaDurante4=fotografiaDurante4;
        this.fotografiaDurante5=fotografiaDurante5;
        this.fotografiaFinal=fotografiaFinal;
        this.guardadoBdRemota=guardadoBdRemota;

    }
}
