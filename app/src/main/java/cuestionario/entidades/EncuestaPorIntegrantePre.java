package cuestionario.entidades;

/**
 * Created by Hector on 12/04/2017.
 */

public class EncuestaPorIntegrantePre {
    private Integer idEncuesta;
    private String nombreIntegrante;
    private String condicionResidencia;
    private String parentezco;
    private String tieneCurp;
    private String curp;
    private String fechaNacimiento;
    private String edad;
    private String sexo;
    private String lugarDeNacimiento;
    private String tieneActa;
    private String viveElPadre;
    private String nombreDelPadre;
    private String viveLaMadre;
    private String nombreDeLaMadre;
    private String afiliadoAInstitucion;
    private String motivoAfiliacion;
    private String hablaIndigena;
    private String lenguaIndigena;
    private String hablaEspaniol;
    private String seConsideraIndigena;
    private String sabeLeer;
    private String nivelEstudio;
    private String gradoEstudio;
    private String asisteAEscuela;
    private String motivoAbandonoEscuela;
    private String estadoCivil;
    private String viveParejaEnElHogar;
    private String elMesPasado;
    private String actividadElMesPasado;
    private String razonNoHaberTrabajado;
    private String seDesempenioComo;
    private String seDedicaATrabajar;
    private String motivoNoTrabajarTodoElAnio;
    private String tuvoSupervisor;
    private String actividadPorSuCuenta;
    private String prestaciones;
    private String recibioPago;
    private Integer cuantoDinero;
    private String cadaCuanto;
    private String segurosVoluntarios;
    private String esJubilado;
    private String recibeDineroPor;
    private String tieneInapam;
    private String recibeDineroPorAdultoMayor;


    public EncuestaPorIntegrantePre(Integer idEncuesta, String nombreIntegrante, String condicionResidencia,
                                    String parentezco, String tieneCurp, String curp, String fechaNacimiento,
                                    String edad, String sexo, String lugarDeNacimiento, String tieneActa,
                                    String viveElPadre, String nombreDelPadre, String viveLaMadre,
                                    String nombreDeLaMadre, String afiliadoAInstitucion, String motivoAfiliacion,
                                    String hablaIndigena, String lenguaIndigena, String hablaEspaniol, String seConsideraIndigena,
                                    String sabeLeer, String nivelEstudio, String gradoEstudio, String asisteAEscuela,
                                    String motivoAbandonoEscuela, String estadoCivil, String viveParejaEnElHogar,
                                    String elMesPasado, String actividadElMesPasado, String razonNoHaberTrabajado,
                                    String seDesempenioComo, String seDedicaATrabajar, String motivoNoTrabajarTodoElAnio,
                                    String tuvoSupervisor, String actividadPorSuCuenta, String prestaciones, String recibioPago,
                                    Integer cuantoDinero, String cadaCuanto, String segurosVoluntarios, String esJubilado,
                                    String recibeDineroPor, String tieneInapam, String recibeDineroPorAdultoMayor){

        this.setIdEncuesta(idEncuesta);
        this.setNombreIntegrante(nombreIntegrante);
        this.setCondicionResidencia(condicionResidencia);
        this.setParentezco(parentezco);
        this.setTieneCurp(tieneCurp);
        this.setCurp(curp);
        this.setFechaNacimiento(fechaNacimiento);
        this.setEdad(edad);
        this.setSexo(sexo);
        this.setLugarDeNacimiento(lugarDeNacimiento);
        this.setTieneActa(tieneActa);
        this.setViveElPadre(viveElPadre);
        this.setNombreDelPadre(nombreDelPadre);
        this.setViveLaMadre(viveLaMadre);
        this.setNombreDeLaMadre(nombreDeLaMadre);
        this.setAfiliadoAInstitucion(afiliadoAInstitucion);
        this.setMotivoAfiliacion(motivoAfiliacion);
        this.setHablaIndigena(hablaIndigena);
        this.setLenguaIndigena(lenguaIndigena);
        this.setHablaEspaniol(hablaEspaniol);
        this.setSeConsideraIndigena(seConsideraIndigena);
        this.setSabeLeer(sabeLeer);
        this.setNivelEstudio(nivelEstudio);
        this.setGradoEstudio(gradoEstudio);
        this.setAsisteAEscuela(asisteAEscuela);
        this.setMotivoAbandonoEscuela(motivoAbandonoEscuela);
        this.setEstadoCivil(estadoCivil);
        this.setViveParejaEnElHogar(viveParejaEnElHogar);
        this.setElMesPasado(elMesPasado);
        this.setActividadElMesPasado(actividadElMesPasado);
        this.setRazonNoHaberTrabajado(razonNoHaberTrabajado);
        this.setSeDesempenioComo(seDesempenioComo);
        this.setSeDedicaATrabajar(seDedicaATrabajar);
        this.setMotivoNoTrabajarTodoElAnio(motivoNoTrabajarTodoElAnio);
        this.setTuvoSupervisor(tuvoSupervisor);
        this.setActividadPorSuCuenta(actividadPorSuCuenta);
        this.setPrestaciones(prestaciones);
        this.setRecibioPago(recibioPago);
        this.setCuantoDinero(cuantoDinero);
        this.setCadaCuanto(cadaCuanto);
        this.setSegurosVoluntarios(segurosVoluntarios);
        this.setEsJubilado(esJubilado);
        this.setRecibeDineroPor(recibeDineroPor);
        this.setTieneInapam(tieneInapam);
        this.setRecibeDineroPorAdultoMayor(recibeDineroPorAdultoMayor);
    }

    public Integer getIdEncuesta() {
        return idEncuesta;
    }

    public void setIdEncuesta(Integer idEncuesta) {
        this.idEncuesta = idEncuesta;
    }

    public String getNombreIntegrante() {
        return nombreIntegrante;
    }

    public void setNombreIntegrante(String nombreIntegrante) {
        this.nombreIntegrante = nombreIntegrante;
    }

    public String getCondicionResidencia() {
        return condicionResidencia;
    }

    public void setCondicionResidencia(String condicionResidencia) {
        this.condicionResidencia = condicionResidencia;
    }

    public String getParentezco() {
        return parentezco;
    }

    public void setParentezco(String parentezco) {
        this.parentezco = parentezco;
    }

    public String getTieneCurp() {
        return tieneCurp;
    }

    public void setTieneCurp(String tieneCurp) {
        this.tieneCurp = tieneCurp;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento;
    }

    public String getTieneActa() {
        return tieneActa;
    }

    public void setTieneActa(String tieneActa) {
        this.tieneActa = tieneActa;
    }

    public String getViveElPadre() {
        return viveElPadre;
    }

    public void setViveElPadre(String viveElPadre) {
        this.viveElPadre = viveElPadre;
    }

    public String getNombreDelPadre() {
        return nombreDelPadre;
    }

    public void setNombreDelPadre(String nombreDelPadre) {
        this.nombreDelPadre = nombreDelPadre;
    }

    public String getViveLaMadre() {
        return viveLaMadre;
    }

    public void setViveLaMadre(String viveLaMadre) {
        this.viveLaMadre = viveLaMadre;
    }

    public String getNombreDeLaMadre() {
        return nombreDeLaMadre;
    }

    public void setNombreDeLaMadre(String nombreDeLaMadre) {
        this.nombreDeLaMadre = nombreDeLaMadre;
    }

    public String getAfiliadoAInstitucion() {
        return afiliadoAInstitucion;
    }

    public void setAfiliadoAInstitucion(String afiliadoAInstitucion) {
        this.afiliadoAInstitucion = afiliadoAInstitucion;
    }

    public String getMotivoAfiliacion() {
        return motivoAfiliacion;
    }

    public void setMotivoAfiliacion(String motivoAfiliacion) {
        this.motivoAfiliacion = motivoAfiliacion;
    }

    public String getHablaIndigena() {
        return hablaIndigena;
    }

    public void setHablaIndigena(String hablaIndigena) {
        this.hablaIndigena = hablaIndigena;
    }

    public String getLenguaIndigena() {
        return lenguaIndigena;
    }

    public void setLenguaIndigena(String lenguaIndigena) {
        this.lenguaIndigena = lenguaIndigena;
    }

    public String getHablaEspaniol() {
        return hablaEspaniol;
    }

    public void setHablaEspaniol(String hablaEspaniol) {
        this.hablaEspaniol = hablaEspaniol;
    }

    public String getSeConsideraIndigena() {
        return seConsideraIndigena;
    }

    public void setSeConsideraIndigena(String seConsideraIndigena) {
        this.seConsideraIndigena = seConsideraIndigena;
    }

    public String getSabeLeer() {
        return sabeLeer;
    }

    public void setSabeLeer(String sabeLeer) {
        this.sabeLeer = sabeLeer;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getGradoEstudio() {
        return gradoEstudio;
    }

    public void setGradoEstudio(String gradoEstudio) {
        this.gradoEstudio = gradoEstudio;
    }

    public String getAsisteAEscuela() {
        return asisteAEscuela;
    }

    public void setAsisteAEscuela(String asisteAEscuela) {
        this.asisteAEscuela = asisteAEscuela;
    }

    public String getMotivoAbandonoEscuela() {
        return motivoAbandonoEscuela;
    }

    public void setMotivoAbandonoEscuela(String motivoAbandonoEscuela) {
        this.motivoAbandonoEscuela = motivoAbandonoEscuela;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getViveParejaEnElHogar() {
        return viveParejaEnElHogar;
    }

    public void setViveParejaEnElHogar(String viveParejaEnElHogar) {
        this.viveParejaEnElHogar = viveParejaEnElHogar;
    }

    public String getElMesPasado() {
        return elMesPasado;
    }

    public void setElMesPasado(String elMesPasado) {
        this.elMesPasado = elMesPasado;
    }

    public String getActividadElMesPasado() {
        return actividadElMesPasado;
    }

    public void setActividadElMesPasado(String actividadElMesPasado) {
        this.actividadElMesPasado = actividadElMesPasado;
    }

    public String getRazonNoHaberTrabajado() {
        return razonNoHaberTrabajado;
    }

    public void setRazonNoHaberTrabajado(String razonNoHaberTrabajado) {
        this.razonNoHaberTrabajado = razonNoHaberTrabajado;
    }

    public String getSeDesempenioComo() {
        return seDesempenioComo;
    }

    public void setSeDesempenioComo(String seDesempenioComo) {
        this.seDesempenioComo = seDesempenioComo;
    }

    public String getSeDedicaATrabajar() {
        return seDedicaATrabajar;
    }

    public void setSeDedicaATrabajar(String seDedicaATrabajar) {
        this.seDedicaATrabajar = seDedicaATrabajar;
    }

    public String getMotivoNoTrabajarTodoElAnio() {
        return motivoNoTrabajarTodoElAnio;
    }

    public void setMotivoNoTrabajarTodoElAnio(String motivoNoTrabajarTodoElAnio) {
        this.motivoNoTrabajarTodoElAnio = motivoNoTrabajarTodoElAnio;
    }

    public String getTuvoSupervisor() {
        return tuvoSupervisor;
    }

    public void setTuvoSupervisor(String tuvoSupervisor) {
        this.tuvoSupervisor = tuvoSupervisor;
    }

    public String getActividadPorSuCuenta() {
        return actividadPorSuCuenta;
    }

    public void setActividadPorSuCuenta(String actividadPorSuCuenta) {
        this.actividadPorSuCuenta = actividadPorSuCuenta;
    }

    public String getPrestaciones() {
        return prestaciones;
    }

    public void setPrestaciones(String prestaciones) {
        this.prestaciones = prestaciones;
    }

    public String getRecibioPago() {
        return recibioPago;
    }

    public void setRecibioPago(String recibioPago) {
        this.recibioPago = recibioPago;
    }

    public Integer getCuantoDinero() {
        return cuantoDinero;
    }

    public void setCuantoDinero(Integer cuantoDinero) {
        this.cuantoDinero = cuantoDinero;
    }

    public String getCadaCuanto() {
        return cadaCuanto;
    }

    public void setCadaCuanto(String cadaCuanto) {
        this.cadaCuanto = cadaCuanto;
    }

    public String getSegurosVoluntarios() {
        return segurosVoluntarios;
    }

    public void setSegurosVoluntarios(String segurosVoluntarios) {
        this.segurosVoluntarios = segurosVoluntarios;
    }

    public String getEsJubilado() {
        return esJubilado;
    }

    public void setEsJubilado(String esJubilado) {
        this.esJubilado = esJubilado;
    }

    public String getRecibeDineroPor() {
        return recibeDineroPor;
    }

    public void setRecibeDineroPor(String recibeDineroPor) {
        this.recibeDineroPor = recibeDineroPor;
    }

    public String getTieneInapam() {
        return tieneInapam;
    }

    public void setTieneInapam(String tieneInapam) {
        this.tieneInapam = tieneInapam;
    }

    public String getRecibeDineroPorAdultoMayor() {
        return recibeDineroPorAdultoMayor;
    }

    public void setRecibeDineroPorAdultoMayor(String recibeDineroPorAdultoMayor) {
        this.recibeDineroPorAdultoMayor = recibeDineroPorAdultoMayor;
    }
}
