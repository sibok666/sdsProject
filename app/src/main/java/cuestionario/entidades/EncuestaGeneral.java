package cuestionario.entidades;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Hector on 12/04/2017.
 */

public class EncuestaGeneral extends SugarRecord {
   public  Integer idEncuesta;
    public String folio;
    public Double latitud;
    public Double longitud;
    public String claveEncuestador;
    public String nombreEncuestador;
    public Date fechaInicio;
    public Date fechaFin;
    public Integer guardadoEnBDRemota;
    public String entidadFederativa;
    public String claveEntidad;
    public String municipio;
    public String claveMunicipio;
    public String localidad;
    public String claveLocalidad;
    public String claveAgeb;
    public String claveManzana;
    public String domicilioGeografico;
    public String a3tipoAdminCarretera;
    public String a3derechoTransito;
    public String a3codigoCarretera;
    public String a3Origen;
    public String a3Destino;
    public String a3Km;
    public String a3Metros;
    public String b3TerminoGenerico;
    public String b3Origen;
    public String b3Destino;
    public String b3Margen;
    public String b3Km;
    public String b3Metros;
    public String c3TipoVialidad;
    public String c3NombreVialidad;
    public String c3NumeroExt;
    public String c3letra;
    public String c3NumExtAnt;
    public String c3NumInterior;
    public String c3LetraInterior;
    public String c3Cp;
    public String c3tipoAsentamiento;
    public String c3NombreAsentamiento;
    public String c3Entrevialidad1Tipo;
    public String c3Entrevialidad1Nombre;
    public String c3Entrevialidad2Tipo;
    public String c3Entrevialidad2Nombre;
    public String c3VialidadPosteriorTipo;
    public String c3VialidadPosteriorNombre;
    public String c3Referencia;

    public String informanteAdecuado;
    public String documentoOficialInformante;
    public String documentoOficialInformanteCodigo;
    public String documentoOficialInformanteFolio;
    public String documentoOficialInformanteParaEdad;
    public String documentoOficialInformanteParaEdadCodigo;
    public String documentoOficialInformanteParaEdadFolio;
    public String tipoVivienda;
    public Integer personasEnVivienda;
    public Integer numeroDeHogares;
    public Integer numeroDePersonasEnElHogar;
    public String compartenGastos;
    public String habitanMismaVivienda;
    public String tieneTelefono;
    public String numeroTelefono;
    public Integer telCelular;
    public Integer telRecados;
    public Integer telFijo;

    public EncuestaGeneral(){}
    public EncuestaGeneral(Integer idEncuesta,String folio,Double latitud,
            Double longitud,String claveEncuestador,String nombreEncuestador,
            Date fechaInicio,Date fechaFin,Integer guardadoEnBDRemota,String entidadFederativa,
            String claveEntidad,String municipio,String claveMunicipio,String localidad,
            String claveLocalidad,String claveAgeb,String claveManzana,String domicilioGeografico,
            String a3tipoAdminCarretera,String a3derechoTransito,String a3codigoCarretera,String a3Origen,String a3Destino,
            String a3Km,String a3Metros,String b3TerminoGenerico,String b3Origen,String b3Destino,
            String b3Margen,String b3Km,String b3Metros,String c3TipoVialidad,String c3NombreVialidad,
            String c3NumeroExt,String c3letra,String c3NumExtAnt,String c3NumInterior,String c3LetraInterior,
            String c3Cp,String c3tipoAsentamiento,String c3NombreAsentamiento,String c3Entrevialidad1Tipo,
            String c3Entrevialidad1Nombre,String c3Entrevialidad2Tipo,String c3Entrevialidad2Nombre,
            String c3VialidadPosteriorTipo,String c3VialidadPosteriorNombre,String c3Referencia,
                           String informanteAdecuado,String documentoOficialInformante,String documentoOficialInformanteCodigo,
                                   String documentoOficialInformanteFolio,String documentoOficialInformanteParaEdad,String documentoOficialInformanteParaEdadCodigo,
                                   String documentoOficialInformanteParaEdadFolio,String tipoVivienda,Integer personasEnVivienda,
                                   Integer numeroDeHogares,Integer numeroDePersonasEnElHogar,
                                   String compartenGastos,String habitanMismaVivienda,
                                   String tieneTelefono,String numeroTelefono,Integer telCelular,Integer telRecados,Integer telFijo){

        this.idEncuesta=idEncuesta;
        this.folio=folio;
        this.latitud=latitud;
        this.longitud=longitud;
        this.claveEncuestador=claveEncuestador;
        this.nombreEncuestador=nombreEncuestador;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.guardadoEnBDRemota=guardadoEnBDRemota;
        this.entidadFederativa=entidadFederativa;
        this.claveEntidad=claveEntidad;
        this.municipio=municipio;
        this.claveMunicipio=claveMunicipio;
        this.localidad=localidad;
        this.claveLocalidad=claveLocalidad;
        this.claveAgeb=claveAgeb;
        this.claveManzana=claveManzana;
        this.domicilioGeografico=domicilioGeografico;
        this.a3tipoAdminCarretera=a3tipoAdminCarretera;
        this.a3derechoTransito=a3derechoTransito;
        this.a3codigoCarretera=a3codigoCarretera;
        this.a3Origen=a3Origen;
        this.a3Destino=a3Destino;
        this.a3Km=a3Km;
        this.a3Metros=a3Metros;
        this.b3TerminoGenerico=b3TerminoGenerico;
        this.b3Origen=b3Origen;
        this.b3Destino=b3Destino;
        this.b3Margen=b3Margen;
        this.b3Km=b3Km;
        this.b3Metros=b3Metros;
        this.c3TipoVialidad=c3TipoVialidad;
        this.c3NombreVialidad=c3NombreVialidad;
        this.c3NumeroExt=c3NumeroExt;
        this.c3letra=c3letra;
        this.c3NumExtAnt=c3NumExtAnt;
        this.c3NumInterior=c3NumInterior;
        this.c3LetraInterior=c3LetraInterior;
        this.c3Cp=c3Cp;
        this.c3tipoAsentamiento=c3tipoAsentamiento;
        this.c3NombreAsentamiento=c3NombreAsentamiento;
        this.c3Entrevialidad1Tipo=c3Entrevialidad1Tipo;
        this.c3Entrevialidad1Nombre=c3Entrevialidad1Nombre;
        this.c3Entrevialidad2Tipo=c3Entrevialidad2Tipo;
        this.c3Entrevialidad2Nombre=c3Entrevialidad2Nombre;
        this.c3VialidadPosteriorTipo=c3VialidadPosteriorTipo;
        this.c3VialidadPosteriorNombre=c3VialidadPosteriorNombre;
        this.c3Referencia=c3Referencia;

        this.informanteAdecuado=informanteAdecuado;
        this.documentoOficialInformante=documentoOficialInformante;
        this.documentoOficialInformanteCodigo=documentoOficialInformanteCodigo;
        this.documentoOficialInformanteFolio=documentoOficialInformanteFolio;
        this.documentoOficialInformanteParaEdad=documentoOficialInformanteParaEdad;
        this.documentoOficialInformanteParaEdadCodigo=documentoOficialInformanteParaEdadCodigo;
        this.documentoOficialInformanteParaEdadFolio=documentoOficialInformanteParaEdadFolio;
        this.tipoVivienda=tipoVivienda;
        this.personasEnVivienda=personasEnVivienda;
        this.numeroDeHogares=numeroDeHogares;
        this.numeroDePersonasEnElHogar=numeroDePersonasEnElHogar;
        this.compartenGastos=compartenGastos;
        this.habitanMismaVivienda=habitanMismaVivienda;
        this.tieneTelefono=tieneTelefono;
        this.numeroTelefono=numeroTelefono;
        this.telCelular=telCelular;
        this.telRecados=telRecados;
        this.telFijo=telFijo;
    }

}
