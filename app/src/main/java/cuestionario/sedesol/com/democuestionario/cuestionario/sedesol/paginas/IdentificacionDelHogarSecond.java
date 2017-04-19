package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import cuestionario.entidades.EncuestaGeneral;
import cuestionario.entidades.EncuestaGeneralPre;
import cuestionario.sedesol.com.democuestionario.R;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar.AgregarIntegrante;

import static android.content.ContentValues.TAG;

public class IdentificacionDelHogarSecond extends AppCompatActivity {
    Spinner spinerIdentificacion;
    Spinner spinerIdentificacionEdad;
    Spinner spinerVivienda;
    Spinner spinerCompartenGastos;
    Spinner spinerCompartenAlimentos;
    Spinner spinerTelefono;
    EditText folio;
    EditText folioEdad;
    EditText numeroHabitantes;
    EditText numeroHogares;
    EditText numeroIntegrantesHogar;
    EditText numeroTelefono;
    EncuestaGeneralPre encuestaGeneralPre;
    String folioEncuesta;
    String folioEdadEncuesta;
    String numeroHabitantesEncuesta;
    String numeroHogaresEncuesta;
    String numeroIntegrantesHogarEncuesta;
    String numeroTelefonoEncuesta;
    String documOficialInformanteEncuesta;
    String documOficialInformanteFolioEncuesta;
    String documOficialInformanteEdadEncuesta;
    String documOficialInformanteEdadFolioEncuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion_del_hogar_second);

        Intent i=getIntent();
        //encuestaGeneralPre=(EncuestaGeneralPre) i.getParcelableExtra("encuestaGeneralPre");
        Bundle bundle=i.getExtras();
        encuestaGeneralPre=(EncuestaGeneralPre)bundle.getSerializable("EncuestaGeneralPre");
        spinerIdentificacion=(Spinner)findViewById(R.id.spinnerIdentificacion);
        spinerCompartenGastos=(Spinner)findViewById(R.id.spinnerCompartenGastos);
        spinerCompartenAlimentos=(Spinner)findViewById(R.id.spinnerCompartenAlimentos);
        spinerTelefono=(Spinner)findViewById(R.id.spinnerTelefono);
        folio=(EditText)findViewById(R.id.editText25);
        folioEdad=(EditText)findViewById(R.id.editText30);
        numeroHabitantes=(EditText)findViewById(R.id.editText31);
        numeroHogares=(EditText)findViewById(R.id.editText32);
        numeroIntegrantesHogar=(EditText)findViewById(R.id.editText33);
        numeroTelefono=(EditText)findViewById(R.id.editText34);

        String [] arregloIdentificacion={"--","Credencial para votar vigente",
                "Cartilla del Servicio Militar Nacional",
                "Pasaporte vigente",
                "Constancia de identidad, edad y residencia con fotografía expedida por la autoridad municipal (LOCALIDADES DE HASTA 10,000 HABITANTES)",
                "Formas migratorias",
                "Cédula de identidad personal",
                "Credencial del Instituto Nacional de las Personas Adultas Mayores (INAPAM)",
                "Cédula profesional",
                "Ninguno"};
        ArrayAdapter adapterIdentificacion = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloIdentificacion);
        spinerIdentificacion.setAdapter(adapterIdentificacion);

        spinerIdentificacionEdad=(Spinner)findViewById(R.id.spinnerIdentificacionEdad);
        String [] arregloIdentificacionEdad={"--","Clave Única de Registro de Población (CURP)","Acta de nacimiento","Ninguno"};
        ArrayAdapter adapterIdentificacionEdad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloIdentificacionEdad);
        spinerIdentificacionEdad.setAdapter(adapterIdentificacionEdad);

        spinerVivienda=(Spinner)findViewById(R.id.spinnerVivienda);

        String [] arregloVivienda={"--","Casa independiente","Departamento en edificio/unidad habitacional",
                "Vivienda o cuarto en vecindad",
                "Vivienda o cuarto en la azotea",
                "Anexo a casa",
                "Local no construido para habitación",
                "Vivienda en terreno familiar compartido",
                "Vivienda móvil",
                "Refugio",
                "Vivienda en construcción no habitada",
                "Asilo, orfanato o convento"};
        ArrayAdapter adapterVivienda = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloVivienda);
        spinerVivienda.setAdapter(adapterVivienda);

    }

    public void irAAgregarIntegrante2(View view) {
        Integer numeroH=0;
        Integer numeroHog=0;
        folioEncuesta=folio.getText().toString();
        folioEdadEncuesta=folioEdad.getText().toString();
        numeroHabitantesEncuesta=numeroHabitantes.getText().toString();
        numeroHogaresEncuesta=numeroHogares.getText().toString();
        numeroIntegrantesHogarEncuesta=numeroIntegrantesHogar.getText().toString();
        numeroTelefonoEncuesta=numeroTelefono.getText().toString();
        documOficialInformanteEncuesta=spinerIdentificacion.getSelectedItem().toString();
        documOficialInformanteEdadEncuesta=spinerIdentificacionEdad.getSelectedItem().toString();

        encuestaGeneralPre.setDocumentoOficialInformante(documOficialInformanteEncuesta);
        encuestaGeneralPre.setDocumentoOficialInformanteFolio(folioEncuesta);
        encuestaGeneralPre.setDocumentoOficialInformanteParaEdad(documOficialInformanteEdadEncuesta);
        encuestaGeneralPre.setDocumentoOficialInformanteParaEdadFolio(folioEdadEncuesta);
        encuestaGeneralPre.setNumeroTelefono(numeroTelefonoEncuesta);

        if(numeroHogaresEncuesta.equals("")){

        }else{
            numeroHog=Integer.parseInt(numeroHogaresEncuesta);
        }
        if(numeroHabitantesEncuesta.equals("")){

        }else{
            numeroH=Integer.parseInt(numeroHabitantesEncuesta);
        }
        encuestaGeneralPre.setNumeroDeHogares(numeroHog);
        encuestaGeneralPre.setPersonasEnVivienda(numeroH);
        guardarEncuestaLocal(encuestaGeneralPre);

        Intent intent = new Intent(this, AgregarIntegrante.class);
        intent.putExtra("encuestaGeneralPre", (Parcelable) encuestaGeneralPre);
        startActivity(intent);
    }

    public void guardarEncuestaLocal(EncuestaGeneralPre encuestaGeneralPre){
        Log.d(TAG, "Se intentarà guardar la enuesta de manera local-----------"+new Date());
        encuestaGeneralPre.setGuardadoEnBDRemota(0);
        encuestaGeneralPre.setFechaFin(new Date());
        EncuestaGeneral e=new EncuestaGeneral(
                encuestaGeneralPre.getIdEncuesta(),encuestaGeneralPre.getFolio(),encuestaGeneralPre.getLatitud(),
                encuestaGeneralPre.getLongitud(),encuestaGeneralPre.getClaveEncuestador(),encuestaGeneralPre.getNombreEncuestador(),
                encuestaGeneralPre.getFechaInicio(),encuestaGeneralPre.getFechaFin(),encuestaGeneralPre.getGuardadoEnBDRemota(),encuestaGeneralPre.getEntidadFederativa(),
                encuestaGeneralPre.getClaveEntidad(),encuestaGeneralPre.getMunicipio(),encuestaGeneralPre.getClaveMunicipio(),encuestaGeneralPre.getLocalidad(),
                encuestaGeneralPre.getClaveLocalidad(),encuestaGeneralPre.getClaveAgeb(),encuestaGeneralPre.getClaveManzana(),encuestaGeneralPre.getDomicilioGeografico(),
                encuestaGeneralPre.getA3tipoAdminCarretera(),encuestaGeneralPre.getA3derechoTransito(),encuestaGeneralPre.getA3codigoCarretera(),encuestaGeneralPre.getA3Origen(),encuestaGeneralPre.getA3Destino(),
                encuestaGeneralPre.getA3Km(),encuestaGeneralPre.getA3Metros(),encuestaGeneralPre.getB3TerminoGenerico(),encuestaGeneralPre.getB3Origen(),encuestaGeneralPre.getB3Destino(),
                encuestaGeneralPre.getB3Margen(),encuestaGeneralPre.getB3Km(),encuestaGeneralPre.getB3Metros(),encuestaGeneralPre.getC3TipoVialidad(),encuestaGeneralPre.getC3NombreVialidad(),
                encuestaGeneralPre.getC3NumeroExt(),encuestaGeneralPre.getC3letra(),encuestaGeneralPre.getC3NumExtAnt(),encuestaGeneralPre.getC3NumInterior(),encuestaGeneralPre.getC3LetraInterior(),
                encuestaGeneralPre.getC3Cp(),encuestaGeneralPre.getC3tipoAsentamiento(),encuestaGeneralPre.getC3NombreAsentamiento(),encuestaGeneralPre.getC3Entrevialidad1Tipo(),
                encuestaGeneralPre.getC3Entrevialidad1Nombre(),encuestaGeneralPre.getC3Entrevialidad2Tipo(),encuestaGeneralPre.getC3Entrevialidad2Nombre(),
                encuestaGeneralPre.getC3VialidadPosteriorTipo(),encuestaGeneralPre.getC3VialidadPosteriorNombre(),encuestaGeneralPre.getC3Referencia(),
                encuestaGeneralPre.getInformanteAdecuado(),encuestaGeneralPre.getDocumentoOficialInformante(),encuestaGeneralPre.getDocumentoOficialInformanteCodigo(),
                encuestaGeneralPre.getDocumentoOficialInformanteFolio(),encuestaGeneralPre.getDocumentoOficialInformanteParaEdad(),encuestaGeneralPre.getDocumentoOficialInformanteParaEdadCodigo(),
                encuestaGeneralPre.getDocumentoOficialInformanteParaEdadFolio(),encuestaGeneralPre.getTipoVivienda(),encuestaGeneralPre.getPersonasEnVivienda(),
                encuestaGeneralPre.getNumeroDeHogares(),encuestaGeneralPre.getNumeroDePersonasEnElHogar(),
                encuestaGeneralPre.getCompartenGastos(),encuestaGeneralPre.getHabitanMismaVivienda(),
                encuestaGeneralPre.getTieneTelefono(),encuestaGeneralPre.getNumeroTelefono(),encuestaGeneralPre.getTelCelular(),encuestaGeneralPre.getTelRecados(),encuestaGeneralPre.getTelFijo()
        );
        e.save();
        Log.d(TAG, "Se guardo la enuesta de manera local-----------"+new Date());
    }
}
