package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by Hector on 12/04/2017.
 */

public class EncuestaPorIntegrante extends SugarRecord {
    Integer idEncuesta;
    String nombreIntegrante;
    String condicionResidencia;
    String parentezco;
    String tieneCurp;
    String curp;
    String fechaNacimiento;
    String edad;
    String sexo;
    String lugarDeNacimiento;
    String tieneActa;
    String viveElPadre;
    String nombreDelPadre;
    String viveLaMadre;
    String nombreDeLaMadre;
    String afiliadoAInstitucion;
    String motivoAfiliacion;
    String hablaIndigena;
    String lenguaIndigena;
    String hablaEspaniol;
    String seConsideraIndigena;
    String sabeLeer;
    String nivelEstudio;
    String gradoEstudio;
    String asisteAEscuela;
    String motivoAbandonoEscuela;
    String estadoCivil;
    String viveParejaEnElHogar;
    String elMesPasado;
    String actividadElMesPasado;
    String razonNoHaberTrabajado;
    String seDesempenioComo;
    String seDedicaATrabajar;
    String motivoNoTrabajarTodoElAnio;
    String tuvoSupervisor;
    String actividadPorSuCuenta;
    String prestaciones;
    String recibioPago;
    Integer cuantoDinero;
    String cadaCuanto;
    String segurosVoluntarios;
    String esJubilado;
    String recibeDineroPor;
    String tieneInapam;
    String recibeDineroPorAdultoMayor;


    public EncuestaPorIntegrante(    Integer idEncuesta,String nombreIntegrante,String condicionResidencia,
                                     String parentezco,String tieneCurp,String curp,String fechaNacimiento,
                                     String edad,String sexo,String lugarDeNacimiento,String tieneActa,
                                     String viveElPadre,String nombreDelPadre,String viveLaMadre,
                                     String nombreDeLaMadre,String afiliadoAInstitucion,String motivoAfiliacion,
                                     String hablaIndigena,String lenguaIndigena,String hablaEspaniol,String seConsideraIndigena,
                                     String sabeLeer,String nivelEstudio,String gradoEstudio,String asisteAEscuela,
                                     String motivoAbandonoEscuela,String estadoCivil,String viveParejaEnElHogar,
                                     String elMesPasado,String actividadElMesPasado,String razonNoHaberTrabajado,
                                     String seDesempenioComo,String seDedicaATrabajar,String motivoNoTrabajarTodoElAnio,
                                     String tuvoSupervisor,String actividadPorSuCuenta,String prestaciones,String recibioPago,
                                     Integer cuantoDinero,String cadaCuanto,String segurosVoluntarios,String esJubilado,
                                     String recibeDineroPor,String tieneInapam,String recibeDineroPorAdultoMayor){

        this.idEncuesta=idEncuesta;
        this.nombreIntegrante=nombreIntegrante;
        this.condicionResidencia=condicionResidencia;
        this.parentezco=parentezco;
        this.tieneCurp=tieneCurp;
        this.curp=curp;
        this.fechaNacimiento=fechaNacimiento;
        this.edad=edad;
        this.sexo=sexo;
        this.lugarDeNacimiento=lugarDeNacimiento;
        this.tieneActa=tieneActa;
        this.viveElPadre=viveElPadre;
        this.nombreDelPadre=nombreDelPadre;
        this.viveLaMadre=viveLaMadre;
        this.nombreDeLaMadre=nombreDeLaMadre;
        this.afiliadoAInstitucion=afiliadoAInstitucion;
        this.motivoAfiliacion=motivoAfiliacion;
        this.hablaIndigena=hablaIndigena;
        this.lenguaIndigena=lenguaIndigena;
        this.hablaEspaniol=hablaEspaniol;
        this.seConsideraIndigena=seConsideraIndigena;
        this.sabeLeer=sabeLeer;
        this.nivelEstudio=nivelEstudio;
        this.gradoEstudio=gradoEstudio;
        this.asisteAEscuela=asisteAEscuela;
        this.motivoAbandonoEscuela=motivoAbandonoEscuela;
        this.estadoCivil=estadoCivil;
        this.viveParejaEnElHogar=viveParejaEnElHogar;
        this.elMesPasado=elMesPasado;
        this.actividadElMesPasado=actividadElMesPasado;
        this.razonNoHaberTrabajado=razonNoHaberTrabajado;
        this.seDesempenioComo=seDesempenioComo;
        this.seDedicaATrabajar=seDedicaATrabajar;
        this.motivoNoTrabajarTodoElAnio=motivoNoTrabajarTodoElAnio;
        this.tuvoSupervisor=tuvoSupervisor;
        this.actividadPorSuCuenta=actividadPorSuCuenta;
        this.prestaciones=prestaciones;
        this.recibioPago=recibioPago;
        this.cuantoDinero=cuantoDinero;
        this.cadaCuanto=cadaCuanto;
        this.segurosVoluntarios=segurosVoluntarios;
        this.esJubilado=esJubilado;
        this.recibeDineroPor=recibeDineroPor;
        this.tieneInapam=tieneInapam;
        this.recibeDineroPorAdultoMayor=recibeDineroPorAdultoMayor;
    }
}
