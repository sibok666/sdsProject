package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cuestionario.entidades.EncuestaGeneralPre;
import cuestionario.sedesol.com.democuestionario.R;

public class GetAllActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;
    TextView t10;
    TextView t11;
    Integer posicion=0;
    private ProgressDialog pDialog;

    List<EncuestaGeneralPre> listaEncuestas=new ArrayList<EncuestaGeneralPre>();
    EncuestaGeneralPre encuesta;

    Button encuestaAnterior;
    Button encuestaSiguiente;
    Button encuestaFinal;

    SupportMapFragment mapFragment;
    private GoogleMap mMap;
    Marker mMarker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all);
        t1=(TextView) findViewById(R.id.entidadText);
        t2=(TextView) findViewById(R.id.claveEntidadtext);
        t3=(TextView) findViewById(R.id.municipioText);
        t4=(TextView) findViewById(R.id.localidadText);
        t5=(TextView) findViewById(R.id.claveAgebText);
        t6=(TextView) findViewById(R.id.claveManzanaText);
        t7=(TextView) findViewById(R.id.fechaInicioText);
        t8=(TextView) findViewById(R.id.fechaFinText);
        t9=(TextView) findViewById(R.id.numeroEncuestaText);
        t10=(TextView) findViewById(R.id.latitudText);
        t11=(TextView) findViewById(R.id.longitudText);

        encuestaAnterior=(Button)findViewById(R.id.buttonEncuestaAnterior);
        encuestaSiguiente=(Button)findViewById(R.id.buttonEncuestaSiguiente);
        encuestaFinal=(Button)findViewById(R.id.buttonEncuestaFinal);

        encuestaFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!listaEncuestas.isEmpty()){
                    mostrarEncuesta(listaEncuestas.size()-1);
                }
            }
        });

        encuestaSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!listaEncuestas.isEmpty()){
                    if(posicion>=listaEncuestas.size()-1){
                        mostrarEncuesta(posicion);
                    }else{
                        posicion++;
                        mostrarEncuesta(posicion);
                    }
                }
            }
        });

        encuestaAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!listaEncuestas.isEmpty()){
                    if(posicion<=0){
                        posicion=0;
                        mostrarEncuesta(posicion);
                    }else{
                        posicion--;
                        mostrarEncuesta(posicion);
                    }
                }
            }
        });

        mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    public String mostrar(){
        HttpClient httpClient=new DefaultHttpClient();
        HttpPost httpPost=new HttpPost("http://www.dox.com.mx/sdsProject/getall.php");
        String resultado="";
        HttpResponse response;

        try{
            response=httpClient.execute(httpPost);
            HttpEntity entity=response.getEntity();
            resultado=fromStream(entity.getContent());

        }catch(Exception e){
            e.printStackTrace();
        }

        return resultado;
    }


    public String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

    public boolean filtrarDatos(){
        listaEncuestas.clear();
        String data=mostrar();
        if(!data.equalsIgnoreCase("")){
            try{
                JSONObject jsonObject=new JSONObject(data);
                JSONArray jsonArray=jsonObject.optJSONArray("encuestasAplicadas");

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                for(int i=0;i<jsonArray.length();i++){
                    encuesta=new EncuestaGeneralPre();
                    JSONObject jsonArrayChild=jsonArray.getJSONObject(i);
                    encuesta.setFechaInicio(formatter.parse(jsonArrayChild.optString("fechaInicio")));
                    encuesta.setFechaFin(formatter.parse(jsonArrayChild.optString("fechaFin")));
                    encuesta.setEntidadFederativa(jsonArrayChild.optString("entidadFederativa"));
                    encuesta.setClaveAgeb(jsonArrayChild.optString("claveAgeb"));
                    encuesta.setClaveManzana(jsonArrayChild.optString("claveManzana"));
                    encuesta.setLocalidad(jsonArrayChild.optString("localidad"));
                    encuesta.setMunicipio(jsonArrayChild.optString("municipio"));
                    encuesta.setClaveEntidad(jsonArrayChild.optString("claveEntidad"));
                    encuesta.setLatitud(jsonArrayChild.optDouble("latitud"));
                    encuesta.setLongitud(jsonArrayChild.optDouble("longitud"));
                    encuesta.setIdEncuesta(jsonArrayChild.optInt("idEncuesta"));
                    listaEncuestas.add(encuesta);
                }
            }catch (JSONException e){
                e.printStackTrace();
            }catch (ParseException p){
                p.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public void obtenerListadoEncuestas(View view) {
        new Mostrar().execute();
    }

    public void mostrarEncuesta(final Integer posicion){
        final SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                encuesta=listaEncuestas.get(posicion);
                t9.setText("Identificador: "+encuesta.getIdEncuesta());
                t1.setText("Entidad: "+encuesta.getEntidadFederativa());
                t2.setText("Clave: "+encuesta.getClaveEntidad());
                t3.setText("Municipio: "+encuesta.getMunicipio());
                t4.setText("Localidad: "+encuesta.getLocalidad());
                t5.setText("Clave ageb: "+encuesta.getClaveAgeb());
                t6.setText("Clave Manzana: "+encuesta.getClaveManzana());
                t7.setText("Fecha de inicio: "+format.format(encuesta.getFechaInicio()));
                t8.setText("Fecha de finalización: "+format.format(encuesta.getFechaFin()));
                t10.setText("Latitud: "+encuesta.getLatitud());
                t11.setText("Longitud: "+encuesta.getLongitud());
                mMarker=mMap.addMarker(new MarkerOptions().position(new LatLng(encuesta.getLatitud(), encuesta.getLongitud())).title("Ubicacion"));
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(mMarker.getPosition(), 16);
                mMap.animateCamera(cameraUpdate);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    class Mostrar extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... params) {
            if(filtrarDatos()){
                mostrarEncuesta(posicion);
            }
            pDialog.dismiss();
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(GetAllActivity.this);
            pDialog.setMessage("Obteniendo información...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

    }
}
