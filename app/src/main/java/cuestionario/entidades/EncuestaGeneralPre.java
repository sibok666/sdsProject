package cuestionario.entidades;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class EncuestaGeneralPre implements Serializable {
    private Integer idEncuesta;
    private String folio;
    private Double latitud;
    private Double longitud;
    private String claveEncuestador;
    private String nombreEncuestador;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer guardadoEnBDRemota;
    private String entidadFederativa;
    private String claveEntidad;
    private String municipio;
    private String claveMunicipio;
    private String localidad;
    private String claveLocalidad;
    private String claveAgeb;
    private String claveManzana;
    private String domicilioGeografico;
    private String a3tipoAdminCarretera;
    private String a3derechoTransito;
    private String a3codigoCarretera;
    private String a3Origen;
    private String a3Destino;
    private String a3Km;
    private String a3Metros;
    private String b3TerminoGenerico;
    private String b3Origen;
    private String b3Destino;
    private String b3Margen;
    private String b3Km;
    private String b3Metros;
    private String c3TipoVialidad;
    private String c3NombreVialidad;
    private String c3NumeroExt;
    private String c3letra;
    private String c3NumExtAnt;
    private String c3NumInterior;
    private String c3LetraInterior;
    private String c3Cp;
    private String c3tipoAsentamiento;
    private String c3NombreAsentamiento;
    private String c3Entrevialidad1Tipo;
    private String c3Entrevialidad1Nombre;
    private String c3Entrevialidad2Tipo;
    private String c3Entrevialidad2Nombre;
    private String c3VialidadPosteriorTipo;
    private String c3VialidadPosteriorNombre;
    private String c3Referencia;

    private String informanteAdecuado;
    private String documentoOficialInformante;
    private String documentoOficialInformanteCodigo;
    private String documentoOficialInformanteFolio;
    private String documentoOficialInformanteParaEdad;
    private String documentoOficialInformanteParaEdadCodigo;
    private String documentoOficialInformanteParaEdadFolio;
    private String tipoVivienda;
    private Integer personasEnVivienda;
    private Integer numeroDeHogares;
    private Integer numeroDePersonasEnElHogar;
    private String compartenGastos;
    private String habitanMismaVivienda;
    private String tieneTelefono;
    private String numeroTelefono;
    private Integer telCelular;
    private Integer telRecados;
    private Integer telFijo;

    public EncuestaGeneralPre(){}
    public EncuestaGeneralPre(Integer idEncuesta,String folio,Double latitud,
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

        this.setIdEncuesta(idEncuesta);
        this.setFolio(folio);
        this.setLatitud(latitud);
        this.setLongitud(longitud);
        this.setClaveEncuestador(claveEncuestador);
        this.setNombreEncuestador(nombreEncuestador);
        this.setFechaInicio(fechaInicio);
        this.setFechaFin(fechaFin);
        this.setGuardadoEnBDRemota(guardadoEnBDRemota);
        this.setEntidadFederativa(entidadFederativa);
        this.setClaveEntidad(claveEntidad);
        this.setMunicipio(municipio);
        this.setClaveMunicipio(claveMunicipio);
        this.setLocalidad(localidad);
        this.setClaveLocalidad(claveLocalidad);
        this.setClaveAgeb(claveAgeb);
        this.setClaveManzana(claveManzana);
        this.setDomicilioGeografico(domicilioGeografico);
        this.setA3tipoAdminCarretera(a3tipoAdminCarretera);
        this.setA3derechoTransito(a3derechoTransito);
        this.setA3codigoCarretera(a3codigoCarretera);
        this.setA3Origen(a3Origen);
        this.setA3Destino(a3Destino);
        this.setA3Km(a3Km);
        this.setA3Metros(a3Metros);
        this.setB3TerminoGenerico(b3TerminoGenerico);
        this.setB3Origen(b3Origen);
        this.setB3Destino(b3Destino);
        this.setB3Margen(b3Margen);
        this.setB3Km(b3Km);
        this.setB3Metros(b3Metros);
        this.setC3TipoVialidad(c3TipoVialidad);
        this.setC3NombreVialidad(c3NombreVialidad);
        this.setC3NumeroExt(c3NumeroExt);
        this.setC3letra(c3letra);
        this.setC3NumExtAnt(c3NumExtAnt);
        this.setC3NumInterior(c3NumInterior);
        this.setC3LetraInterior(c3LetraInterior);
        this.setC3Cp(c3Cp);
        this.setC3tipoAsentamiento(c3tipoAsentamiento);
        this.setC3NombreAsentamiento(c3NombreAsentamiento);
        this.setC3Entrevialidad1Tipo(c3Entrevialidad1Tipo);
        this.setC3Entrevialidad1Nombre(c3Entrevialidad1Nombre);
        this.setC3Entrevialidad2Tipo(c3Entrevialidad2Tipo);
        this.setC3Entrevialidad2Nombre(c3Entrevialidad2Nombre);
        this.setC3VialidadPosteriorTipo(c3VialidadPosteriorTipo);
        this.setC3VialidadPosteriorNombre(c3VialidadPosteriorNombre);
        this.setC3Referencia(c3Referencia);

        this.setInformanteAdecuado(informanteAdecuado);
        this.setDocumentoOficialInformante(documentoOficialInformante);
        this.setDocumentoOficialInformanteCodigo(documentoOficialInformanteCodigo);
        this.setDocumentoOficialInformanteFolio(documentoOficialInformanteFolio);
        this.setDocumentoOficialInformanteParaEdad(documentoOficialInformanteParaEdad);
        this.setDocumentoOficialInformanteParaEdadCodigo(documentoOficialInformanteParaEdadCodigo);
        this.setDocumentoOficialInformanteParaEdadFolio(documentoOficialInformanteParaEdadFolio);
        this.setTipoVivienda(tipoVivienda);
        this.setPersonasEnVivienda(personasEnVivienda);
        this.setNumeroDeHogares(numeroDeHogares);
        this.setNumeroDePersonasEnElHogar(numeroDePersonasEnElHogar);
        this.setCompartenGastos(compartenGastos);
        this.setHabitanMismaVivienda(habitanMismaVivienda);
        this.setTieneTelefono(tieneTelefono);
        this.setNumeroTelefono(numeroTelefono);
        this.setTelCelular(telCelular);
        this.setTelRecados(telRecados);
        this.setTelFijo(telFijo);
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }



    public String getClaveEncuestador() {
        return claveEncuestador;
    }

    public void setClaveEncuestador(String claveEncuestador) {
        this.claveEncuestador = claveEncuestador;
    }

    public String getNombreEncuestador() {
        return nombreEncuestador;
    }

    public void setNombreEncuestador(String nombreEncuestador) {
        this.nombreEncuestador = nombreEncuestador;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getGuardadoEnBDRemota() {
        return guardadoEnBDRemota;
    }

    public void setGuardadoEnBDRemota(Integer guardadoEnBDRemota) {
        this.guardadoEnBDRemota = guardadoEnBDRemota;
    }

    public String getEntidadFederativa() {
        return entidadFederativa;
    }

    public void setEntidadFederativa(String entidadFederativa) {
        this.entidadFederativa = entidadFederativa;
    }

    public String getClaveEntidad() {
        return claveEntidad;
    }

    public void setClaveEntidad(String claveEntidad) {
        this.claveEntidad = claveEntidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getClaveMunicipio() {
        return claveMunicipio;
    }

    public void setClaveMunicipio(String claveMunicipio) {
        this.claveMunicipio = claveMunicipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getClaveLocalidad() {
        return claveLocalidad;
    }

    public void setClaveLocalidad(String claveLocalidad) {
        this.claveLocalidad = claveLocalidad;
    }

    public String getClaveAgeb() {
        return claveAgeb;
    }

    public void setClaveAgeb(String claveAgeb) {
        this.claveAgeb = claveAgeb;
    }

    public String getClaveManzana() {
        return claveManzana;
    }

    public void setClaveManzana(String claveManzana) {
        this.claveManzana = claveManzana;
    }

    public String getDomicilioGeografico() {
        return domicilioGeografico;
    }

    public void setDomicilioGeografico(String domicilioGeografico) {
        this.domicilioGeografico = domicilioGeografico;
    }

    public String getA3tipoAdminCarretera() {
        return a3tipoAdminCarretera;
    }

    public void setA3tipoAdminCarretera(String a3tipoAdminCarretera) {
        this.a3tipoAdminCarretera = a3tipoAdminCarretera;
    }

    public String getA3derechoTransito() {
        return a3derechoTransito;
    }

    public void setA3derechoTransito(String a3derechoTransito) {
        this.a3derechoTransito = a3derechoTransito;
    }

    public String getA3Origen() {
        return a3Origen;
    }

    public void setA3Origen(String a3Origen) {
        this.a3Origen = a3Origen;
    }

    public String getA3Destino() {
        return a3Destino;
    }

    public void setA3Destino(String a3Destino) {
        this.a3Destino = a3Destino;
    }

    public String getA3Km() {
        return a3Km;
    }

    public void setA3Km(String a3Km) {
        this.a3Km = a3Km;
    }

    public String getA3Metros() {
        return a3Metros;
    }

    public void setA3Metros(String a3Metros) {
        this.a3Metros = a3Metros;
    }

    public String getB3TerminoGenerico() {
        return b3TerminoGenerico;
    }

    public void setB3TerminoGenerico(String b3TerminoGenerico) {
        this.b3TerminoGenerico = b3TerminoGenerico;
    }

    public String getB3Origen() {
        return b3Origen;
    }

    public void setB3Origen(String b3Origen) {
        this.b3Origen = b3Origen;
    }

    public String getB3Destino() {
        return b3Destino;
    }

    public void setB3Destino(String b3Destino) {
        this.b3Destino = b3Destino;
    }

    public String getB3Margen() {
        return b3Margen;
    }

    public void setB3Margen(String b3Margen) {
        this.b3Margen = b3Margen;
    }

    public String getB3Km() {
        return b3Km;
    }

    public void setB3Km(String b3Km) {
        this.b3Km = b3Km;
    }

    public String getB3Metros() {
        return b3Metros;
    }

    public void setB3Metros(String b3Metros) {
        this.b3Metros = b3Metros;
    }

    public String getC3TipoVialidad() {
        return c3TipoVialidad;
    }

    public void setC3TipoVialidad(String c3TipoVialidad) {
        this.c3TipoVialidad = c3TipoVialidad;
    }

    public String getC3NombreVialidad() {
        return c3NombreVialidad;
    }

    public void setC3NombreVialidad(String c3NombreVialidad) {
        this.c3NombreVialidad = c3NombreVialidad;
    }

    public String getC3NumeroExt() {
        return c3NumeroExt;
    }

    public void setC3NumeroExt(String c3NumeroExt) {
        this.c3NumeroExt = c3NumeroExt;
    }

    public String getC3letra() {
        return c3letra;
    }

    public void setC3letra(String c3letra) {
        this.c3letra = c3letra;
    }

    public String getC3NumExtAnt() {
        return c3NumExtAnt;
    }

    public void setC3NumExtAnt(String c3NumExtAnt) {
        this.c3NumExtAnt = c3NumExtAnt;
    }

    public String getC3NumInterior() {
        return c3NumInterior;
    }

    public void setC3NumInterior(String c3NumInterior) {
        this.c3NumInterior = c3NumInterior;
    }

    public String getC3LetraInterior() {
        return c3LetraInterior;
    }

    public void setC3LetraInterior(String c3LetraInterior) {
        this.c3LetraInterior = c3LetraInterior;
    }

    public String getC3Cp() {
        return c3Cp;
    }

    public void setC3Cp(String c3Cp) {
        this.c3Cp = c3Cp;
    }

    public String getC3tipoAsentamiento() {
        return c3tipoAsentamiento;
    }

    public void setC3tipoAsentamiento(String c3tipoAsentamiento) {
        this.c3tipoAsentamiento = c3tipoAsentamiento;
    }

    public String getC3NombreAsentamiento() {
        return c3NombreAsentamiento;
    }

    public void setC3NombreAsentamiento(String c3NombreAsentamiento) {
        this.c3NombreAsentamiento = c3NombreAsentamiento;
    }

    public String getC3Entrevialidad1Tipo() {
        return c3Entrevialidad1Tipo;
    }

    public void setC3Entrevialidad1Tipo(String c3Entrevialidad1Tipo) {
        this.c3Entrevialidad1Tipo = c3Entrevialidad1Tipo;
    }

    public String getC3Entrevialidad1Nombre() {
        return c3Entrevialidad1Nombre;
    }

    public void setC3Entrevialidad1Nombre(String c3Entrevialidad1Nombre) {
        this.c3Entrevialidad1Nombre = c3Entrevialidad1Nombre;
    }

    public String getC3Entrevialidad2Tipo() {
        return c3Entrevialidad2Tipo;
    }

    public void setC3Entrevialidad2Tipo(String c3Entrevialidad2Tipo) {
        this.c3Entrevialidad2Tipo = c3Entrevialidad2Tipo;
    }

    public String getC3Entrevialidad2Nombre() {
        return c3Entrevialidad2Nombre;
    }

    public void setC3Entrevialidad2Nombre(String c3Entrevialidad2Nombre) {
        this.c3Entrevialidad2Nombre = c3Entrevialidad2Nombre;
    }

    public String getC3VialidadPosteriorTipo() {
        return c3VialidadPosteriorTipo;
    }

    public void setC3VialidadPosteriorTipo(String c3VialidadPosteriorTipo) {
        this.c3VialidadPosteriorTipo = c3VialidadPosteriorTipo;
    }

    public String getC3VialidadPosteriorNombre() {
        return c3VialidadPosteriorNombre;
    }

    public void setC3VialidadPosteriorNombre(String c3VialidadPosteriorNombre) {
        this.c3VialidadPosteriorNombre = c3VialidadPosteriorNombre;
    }

    public String getC3Referencia() {
        return c3Referencia;
    }

    public void setC3Referencia(String c3Referencia) {
        this.c3Referencia = c3Referencia;
    }

    public String getInformanteAdecuado() {
        return informanteAdecuado;
    }

    public void setInformanteAdecuado(String informanteAdecuado) {
        this.informanteAdecuado = informanteAdecuado;
    }

    public String getDocumentoOficialInformante() {
        return documentoOficialInformante;
    }

    public void setDocumentoOficialInformante(String documentoOficialInformante) {
        this.documentoOficialInformante = documentoOficialInformante;
    }

    public String getDocumentoOficialInformanteCodigo() {
        return documentoOficialInformanteCodigo;
    }

    public void setDocumentoOficialInformanteCodigo(String documentoOficialInformanteCodigo) {
        this.documentoOficialInformanteCodigo = documentoOficialInformanteCodigo;
    }

    public String getDocumentoOficialInformanteFolio() {
        return documentoOficialInformanteFolio;
    }

    public void setDocumentoOficialInformanteFolio(String documentoOficialInformanteFolio) {
        this.documentoOficialInformanteFolio = documentoOficialInformanteFolio;
    }

    public String getDocumentoOficialInformanteParaEdad() {
        return documentoOficialInformanteParaEdad;
    }

    public void setDocumentoOficialInformanteParaEdad(String documentoOficialInformanteParaEdad) {
        this.documentoOficialInformanteParaEdad = documentoOficialInformanteParaEdad;
    }

    public String getDocumentoOficialInformanteParaEdadCodigo() {
        return documentoOficialInformanteParaEdadCodigo;
    }

    public void setDocumentoOficialInformanteParaEdadCodigo(String documentoOficialInformanteParaEdadCodigo) {
        this.documentoOficialInformanteParaEdadCodigo = documentoOficialInformanteParaEdadCodigo;
    }

    public String getDocumentoOficialInformanteParaEdadFolio() {
        return documentoOficialInformanteParaEdadFolio;
    }

    public void setDocumentoOficialInformanteParaEdadFolio(String documentoOficialInformanteParaEdadFolio) {
        this.documentoOficialInformanteParaEdadFolio = documentoOficialInformanteParaEdadFolio;
    }

    public String getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(String tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public Integer getPersonasEnVivienda() {
        return personasEnVivienda;
    }

    public void setPersonasEnVivienda(Integer personasEnVivienda) {
        this.personasEnVivienda = personasEnVivienda;
    }

    public Integer getNumeroDeHogares() {
        return numeroDeHogares;
    }

    public void setNumeroDeHogares(Integer numeroDeHogares) {
        this.numeroDeHogares = numeroDeHogares;
    }

    public Integer getNumeroDePersonasEnElHogar() {
        return numeroDePersonasEnElHogar;
    }

    public void setNumeroDePersonasEnElHogar(Integer numeroDePersonasEnElHogar) {
        this.numeroDePersonasEnElHogar = numeroDePersonasEnElHogar;
    }

    public String getCompartenGastos() {
        return compartenGastos;
    }

    public void setCompartenGastos(String compartenGastos) {
        this.compartenGastos = compartenGastos;
    }

    public String getHabitanMismaVivienda() {
        return habitanMismaVivienda;
    }

    public void setHabitanMismaVivienda(String habitanMismaVivienda) {
        this.habitanMismaVivienda = habitanMismaVivienda;
    }

    public String getTieneTelefono() {
        return tieneTelefono;
    }

    public void setTieneTelefono(String tieneTelefono) {
        this.tieneTelefono = tieneTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Integer getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(Integer telCelular) {
        this.telCelular = telCelular;
    }

    public Integer getTelRecados() {
        return telRecados;
    }

    public void setTelRecados(Integer telRecados) {
        this.telRecados = telRecados;
    }

    public Integer getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(Integer telFijo) {
        this.telFijo = telFijo;
    }

    public String getA3codigoCarretera() {
        return a3codigoCarretera;
    }

    public void setA3codigoCarretera(String a3codigoCarretera) {
        this.a3codigoCarretera = a3codigoCarretera;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
