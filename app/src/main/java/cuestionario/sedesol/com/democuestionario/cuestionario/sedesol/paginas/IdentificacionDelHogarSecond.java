package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cuestionario.entidades.EncuestaGeneral;
import cuestionario.entidades.EncuestaGeneralPre;
import cuestionario.sedesol.com.democuestionario.AddNewAnswer;
import cuestionario.sedesol.com.democuestionario.GPSTracker;
import cuestionario.sedesol.com.democuestionario.JSONParser;
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


    ////variables para el guardado
    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    private int success;//to determine JSON signal insert success/fail
    // url to insert new idiom (change accordingly)
    private static String url_insert_new = "http://www.dox.com.mx/sdsProject/insertnew.php";
    // JSON Node names
    private static final String TAG_SUCCESS = "success";



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

        String [] arregloSiNo={"--","Si","No"};

        ArrayAdapter adapterSiNo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSiNo);
        spinerCompartenGastos.setAdapter(adapterSiNo);
        spinerCompartenAlimentos.setAdapter(adapterSiNo);
        spinerTelefono.setAdapter(adapterSiNo);
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
        GPSTracker gps=new GPSTracker(this);
        encuestaGeneralPre.setLatitud((long)gps.getLatitude());
        encuestaGeneralPre.setLongitud((long)gps.getLongitude());

        guardarEncuestaLocal(encuestaGeneralPre);

        Intent intent = new Intent(this, AgregarIntegrante.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("EncuestaGeneralPre",encuestaGeneralPre);
        //intent.putExtra("EncuestaGeneralPre",encuestaGeneralPre);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void guardarEncuestaLocal(EncuestaGeneralPre encuestaGeneralPre){
        Log.d(TAG, "Se intentarà guardar la enuesta de manera local-----------"+new Date());
        encuestaGeneralPre.setGuardadoEnBDRemota(0);
        encuestaGeneralPre.setFechaFin(new Date());
        encuestaGeneralPre.setTelCelular(0);
        encuestaGeneralPre.setTelFijo(0);
        encuestaGeneralPre.setTelRecados(0);
        encuestaGeneralPre.setNumeroDePersonasEnElHogar(0);

        ///chcamos campos null y los inicializamos para que e constructor no cause error
        if(encuestaGeneralPre.getA3codigoCarretera()==null){encuestaGeneralPre.setA3codigoCarretera("");}
        if(encuestaGeneralPre.getA3derechoTransito()==null){encuestaGeneralPre.setA3derechoTransito("");}
        if(encuestaGeneralPre.getA3Destino()==null){encuestaGeneralPre.setA3Destino("");}
        if(encuestaGeneralPre.getA3Km()==null){encuestaGeneralPre.setA3Km("");}
        if(encuestaGeneralPre.getA3Metros()==null){encuestaGeneralPre.setA3Metros("");}
        if(encuestaGeneralPre.getA3Origen()==null){encuestaGeneralPre.setA3Origen("");}

        if(encuestaGeneralPre.getB3Origen()==null){encuestaGeneralPre.setB3Origen("");}
        if(encuestaGeneralPre.getB3Destino()==null){encuestaGeneralPre.setB3Destino("");}
        if(encuestaGeneralPre.getB3Km()==null){encuestaGeneralPre.setB3Km("");}
        if(encuestaGeneralPre.getB3Margen()==null){encuestaGeneralPre.setB3Margen("");}
        if(encuestaGeneralPre.getB3TerminoGenerico()==null){encuestaGeneralPre.setB3TerminoGenerico("");}

        if(encuestaGeneralPre.getC3Cp()==null){encuestaGeneralPre.setC3Cp("");}
        if(encuestaGeneralPre.getC3Entrevialidad1Nombre()==null){encuestaGeneralPre.setC3Entrevialidad1Nombre("");}
        if(encuestaGeneralPre.getC3Entrevialidad1Tipo()==null){encuestaGeneralPre.setC3Entrevialidad1Tipo("");}
        if(encuestaGeneralPre.getC3Entrevialidad2Nombre()==null){encuestaGeneralPre.setC3Entrevialidad2Nombre("");}
        if(encuestaGeneralPre.getC3Entrevialidad2Tipo()==null){encuestaGeneralPre.setC3Entrevialidad2Tipo("");}
        if(encuestaGeneralPre.getC3letra()==null){encuestaGeneralPre.setC3letra("");}
        if(encuestaGeneralPre.getC3LetraInterior()==null){encuestaGeneralPre.setC3LetraInterior("");}
        if(encuestaGeneralPre.getC3NombreAsentamiento()==null){encuestaGeneralPre.setC3NombreAsentamiento("");}
        if(encuestaGeneralPre.getC3NombreVialidad()==null){encuestaGeneralPre.setC3NombreVialidad("");}
        if(encuestaGeneralPre.getC3NumeroExt()==null){encuestaGeneralPre.setC3NumeroExt("");}
        if(encuestaGeneralPre.getC3NumInterior()==null){encuestaGeneralPre.setC3NumInterior("");}
        if(encuestaGeneralPre.getC3NumExtAnt()==null){encuestaGeneralPre.setC3NumExtAnt("");}
        if(encuestaGeneralPre.getC3Referencia()==null){encuestaGeneralPre.setC3Referencia("");}
        if(encuestaGeneralPre.getC3TipoVialidad()==null){encuestaGeneralPre.setC3TipoVialidad("");}
        if(encuestaGeneralPre.getC3NombreVialidad()==null){encuestaGeneralPre.setC3NombreVialidad("");}
        if(encuestaGeneralPre.getC3VialidadPosteriorNombre()==null){encuestaGeneralPre.setC3VialidadPosteriorNombre("");}
        if(encuestaGeneralPre.getC3VialidadPosteriorTipo()==null){encuestaGeneralPre.setC3VialidadPosteriorTipo("");}

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
        ////intentamos guardar en la BD remota
        new InsertNewAnswer().execute();
        if (success==1){
            Toast.makeText(getApplicationContext(), "New idiom saved...", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "New idiom FAILED to saved...", Toast.LENGTH_LONG).show();
        }
    }
    class InsertNewAnswer extends AsyncTask<String, String, String> {
        //capture values from EditText
        String folio=encuestaGeneralPre.getFolio();
        Long latitud=encuestaGeneralPre.getLatitud();
        Long longitud=encuestaGeneralPre.getLongitud();
        String claveEncuestador=encuestaGeneralPre.getClaveEncuestador();
        String nombreEncuestador=encuestaGeneralPre.getNombreEncuestador();
        Date fechaInicio=encuestaGeneralPre.getFechaInicio();
        Date fechaFin=encuestaGeneralPre.getFechaFin();
        Integer guardadoEnBdRemota=encuestaGeneralPre.getGuardadoEnBDRemota();
        String entidadFederativa=encuestaGeneralPre.getEntidadFederativa();
        String claveEntidad=encuestaGeneralPre.getClaveEntidad();
        String municipio=encuestaGeneralPre.getMunicipio();
        String claveMunicipio=encuestaGeneralPre.getClaveMunicipio();
        String localidad=encuestaGeneralPre.getLocalidad();
        String claveLocalidad=encuestaGeneralPre.getClaveLocalidad();
        String claveAgeb=encuestaGeneralPre.getClaveAgeb();
        String claveManzana=encuestaGeneralPre.getClaveManzana();
        String domicilioGografico=encuestaGeneralPre.getDomicilioGeografico();
        String a3tipoAdminCarretera=encuestaGeneralPre.getA3tipoAdminCarretera();
        String a3derechoTransito=encuestaGeneralPre.getA3derechoTransito();
        String a3codigoCarretera=encuestaGeneralPre.getA3codigoCarretera();
        String a3Origen=encuestaGeneralPre.getA3Origen();
        String a3Destino=encuestaGeneralPre.getA3Destino();
        String a3Km=encuestaGeneralPre.getA3Km();
        String a3Metros=encuestaGeneralPre.getA3Metros();
        String b3TerminoGenerico=encuestaGeneralPre.getB3TerminoGenerico();
        String b3Origen=encuestaGeneralPre.getB3Origen();
        String b3Destino=encuestaGeneralPre.getB3Destino();
        String b3Margen=encuestaGeneralPre.getB3Margen();
        String b3Km=encuestaGeneralPre.getB3Km();
        String b3Metros=encuestaGeneralPre.getB3Metros();
        String c3TipoVialidad=encuestaGeneralPre.getC3TipoVialidad();
        String c3NombreVialidad=encuestaGeneralPre.getC3NombreVialidad();
        String c3NumeroExt=encuestaGeneralPre.getC3NumeroExt();
        String c3letra=encuestaGeneralPre.getC3letra();
        String c3NumExtAnt=encuestaGeneralPre.getC3NumExtAnt();
        String c3NumInterior=encuestaGeneralPre.getC3NumInterior();
        String c3LetraInterior=encuestaGeneralPre.getC3LetraInterior();
        String c3Cp=encuestaGeneralPre.getC3Cp();
        String c3tipoAsentamiento=encuestaGeneralPre.getC3tipoAsentamiento();
        String c3NombreAsentamiento=encuestaGeneralPre.getC3NombreAsentamiento();
        String c3Entrevialidad1Tipo=encuestaGeneralPre.getC3Entrevialidad1Tipo();
        String c3Entrevialidad1Nombre=encuestaGeneralPre.getC3Entrevialidad1Nombre();
        String c3Entrevialidad2Tipo=encuestaGeneralPre.getC3Entrevialidad2Tipo();
        String c3Entrevialidad2Nombre=encuestaGeneralPre.getC3Entrevialidad2Nombre();
        String c3VialidadPosteriorTipo=encuestaGeneralPre.getC3VialidadPosteriorTipo();
        String c3VialidadPosteriorNombre=encuestaGeneralPre.getC3VialidadPosteriorNombre();
        String c3Referencia=encuestaGeneralPre.getC3Referencia();
        String informanteAdecuado=encuestaGeneralPre.getInformanteAdecuado();
        String documentoOficialInformante=encuestaGeneralPre.getDocumentoOficialInformante();
        String documentoOficialInformanteCodigo=encuestaGeneralPre.getDocumentoOficialInformanteCodigo();
        String documentoOficialInformanteFolio=encuestaGeneralPre.getDocumentoOficialInformanteFolio();
        String documentoOficialInformanteParaEdad=encuestaGeneralPre.getDocumentoOficialInformanteParaEdad();
        String documentoOficialInformanteParaEdadCodigo=encuestaGeneralPre.getDocumentoOficialInformanteParaEdadCodigo();
        String documentoOficialInformanteParaEdadFolio=encuestaGeneralPre.getDocumentoOficialInformanteParaEdadFolio();
        String tipoVivienda=encuestaGeneralPre.getTipoVivienda();
        Integer personasEnVivienda=encuestaGeneralPre.getPersonasEnVivienda();
        Integer numeroDeHogares=encuestaGeneralPre.getNumeroDeHogares();
        Integer numeroDePersonasEnElHogar=encuestaGeneralPre.getNumeroDePersonasEnElHogar();
        String compartenGastos=encuestaGeneralPre.getCompartenGastos();
        String habitanMismaVivienda=encuestaGeneralPre.getHabitanMismaVivienda();
        String tieneTelefono=encuestaGeneralPre.getTieneTelefono();
        String numeroTelefono=encuestaGeneralPre.getNumeroTelefono();
        Integer telCelular=encuestaGeneralPre.getTelCelular();
        Integer telRecados=encuestaGeneralPre.getTelRecados();
        Integer telFijo=encuestaGeneralPre.getTelFijo();

        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(IdentificacionDelHogarSecond.this);
            pDialog.setMessage("Guardando encuesta...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Inserting the new idiom
         * */
        protected String doInBackground(String... args) {


            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("folio",folio));
            params.add(new BasicNameValuePair("latitud",""+latitud));
            params.add(new BasicNameValuePair("longitud",""+longitud));
            params.add(new BasicNameValuePair("claveEncuestador",claveEncuestador));
            params.add(new BasicNameValuePair("nombreEncuestador",nombreEncuestador));
            //convertimos fecha a formato Mysql
            SimpleDateFormat fechaF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaInicioF=fechaF.format(fechaInicio);
            String fechaFinF=fechaF.format(fechaFin);
            params.add(new BasicNameValuePair("fechaInicio",fechaInicioF));
            params.add(new BasicNameValuePair("fechaFin",fechaFinF));
            params.add(new BasicNameValuePair("guardadoEnBdRemota",""+guardadoEnBdRemota));
            params.add(new BasicNameValuePair("entidadFederativa",entidadFederativa));
            params.add(new BasicNameValuePair("claveEntidad",claveEntidad));
            params.add(new BasicNameValuePair("municipio",municipio));
            params.add(new BasicNameValuePair("claveMunicipio",claveMunicipio));
            params.add(new BasicNameValuePair("localidad",localidad));
            params.add(new BasicNameValuePair("claveLocalidad",claveLocalidad));
            params.add(new BasicNameValuePair("claveAgeb",claveAgeb));
            params.add(new BasicNameValuePair("claveManzana",claveManzana));
            params.add(new BasicNameValuePair("domicilioGografico",domicilioGografico));
            params.add(new BasicNameValuePair("a3tipoAdminCarretera",a3tipoAdminCarretera));
            params.add(new BasicNameValuePair("a3derechoTransito",a3derechoTransito));
            params.add(new BasicNameValuePair("a3codigoCarretera",a3codigoCarretera));
            params.add(new BasicNameValuePair("a3Origen",a3Origen));
            params.add(new BasicNameValuePair("a3Destino",a3Destino));
            params.add(new BasicNameValuePair("a3Km",a3Km));
            params.add(new BasicNameValuePair("a3Metros",a3Metros));
            params.add(new BasicNameValuePair("b3TerminoGenerico",b3TerminoGenerico));
            params.add(new BasicNameValuePair("b3Origen",b3Origen));
            params.add(new BasicNameValuePair("b3Destino",b3Destino));
            params.add(new BasicNameValuePair("b3Margen",b3Margen));
            params.add(new BasicNameValuePair("b3Km",b3Km));
            params.add(new BasicNameValuePair("b3Metros",b3Metros));
            params.add(new BasicNameValuePair("c3TipoVialidad",c3TipoVialidad));
            params.add(new BasicNameValuePair("c3NombreVialidad",c3NombreVialidad));
            params.add(new BasicNameValuePair("c3NumeroExt",c3NumeroExt));
            params.add(new BasicNameValuePair("c3letra",c3letra));
            params.add(new BasicNameValuePair("c3NumExtAnt",c3NumExtAnt));
            params.add(new BasicNameValuePair("c3NumInterior",c3NumInterior));
            params.add(new BasicNameValuePair("c3LetraInterior",c3LetraInterior));
            params.add(new BasicNameValuePair("c3Cp",c3Cp));
            params.add(new BasicNameValuePair("c3tipoAsentamiento",c3tipoAsentamiento));
            params.add(new BasicNameValuePair("c3NombreAsentamiento",c3NombreAsentamiento));
            params.add(new BasicNameValuePair("c3Entrevialidad1Tipo",c3Entrevialidad1Tipo));
            params.add(new BasicNameValuePair("c3Entrevialidad1Nombre",c3Entrevialidad1Nombre));
            params.add(new BasicNameValuePair("c3Entrevialidad2Tipo",c3Entrevialidad2Tipo));
            params.add(new BasicNameValuePair("c3Entrevialidad2Nombre",c3Entrevialidad2Nombre));
            params.add(new BasicNameValuePair("c3VialidadPosteriorTipo",c3VialidadPosteriorTipo));
            params.add(new BasicNameValuePair("c3VialidadPosteriorNombre",c3VialidadPosteriorNombre));
            params.add(new BasicNameValuePair("c3Referencia",c3Referencia));
            params.add(new BasicNameValuePair("informanteAdecuado",informanteAdecuado));
            params.add(new BasicNameValuePair("documentoOficialInformante",documentoOficialInformante));
            params.add(new BasicNameValuePair("documentoOficialInformanteCodigo",documentoOficialInformanteCodigo));
            params.add(new BasicNameValuePair("documentoOficialInformanteFolio",documentoOficialInformanteFolio));
            params.add(new BasicNameValuePair("documentoOficialInformanteParaEdad",documentoOficialInformanteParaEdad));
            params.add(new BasicNameValuePair("documentoOficialInformanteParaEdadCodigo",documentoOficialInformanteParaEdadCodigo));
            params.add(new BasicNameValuePair("documentoOficialInformanteParaEdadFolio",documentoOficialInformanteParaEdadFolio));
            params.add(new BasicNameValuePair("tipoVivienda",tipoVivienda));
            params.add(new BasicNameValuePair("personasEnVivienda",""+personasEnVivienda));
            params.add(new BasicNameValuePair("numeroDeHogares",""+numeroDeHogares));
            params.add(new BasicNameValuePair("numeroDePersonasEnElHogar",""+numeroDePersonasEnElHogar));
            params.add(new BasicNameValuePair("compartenGastos",compartenGastos));
            params.add(new BasicNameValuePair("habitanMismaVivienda",habitanMismaVivienda));
            params.add(new BasicNameValuePair("tieneTelefono",tieneTelefono));
            params.add(new BasicNameValuePair("numeroTelefono",numeroTelefono));
            params.add(new BasicNameValuePair("telCelular",""+telCelular));
            params.add(new BasicNameValuePair("telRecados",""+telRecados));
            params.add(new BasicNameValuePair("telFijo",""+telFijo));

            // getting JSON Object
            // Note that create product url accepts GET method
            try {
            JSONObject json = jsonParser.makeHttpRequest(url_insert_new,
                    "GET", params);

            // check log cat from response
            Log.d("Inserting", json.toString());

            // check for success tag

                success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // successfully save new idiom
                } else {
                    // failed to add new idiom
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //return null;
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once done
            pDialog.dismiss();
        }

    }
}
