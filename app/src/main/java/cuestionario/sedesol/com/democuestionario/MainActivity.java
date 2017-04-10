package cuestionario.sedesol.com.democuestionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.orm.SugarContext;

import java.util.List;

import cuestionario.entidades.Ageb;
import cuestionario.entidades.Entidad;
import cuestionario.entidades.InicializadorDatos;
import cuestionario.entidades.Localidad;
import cuestionario.entidades.Municipio;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.PageOne;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Double latitud;
    Double longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        ////obtenemos la latitud y longitud
        GPSTracker gps = new GPSTracker(MainActivity.this);
        // check if GPS enabled
        if(gps.canGetLocation()){
            latitud = gps.getLatitude();
            longitud = gps.getLongitude();
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }

        getBDEntidad();
        //getBDMunicipio();
        //getBDLocalidad();
    }

    /** Called when the user clicks the Send button */
    public void logIn(View view) {
        Intent intent = new Intent(this, PageOne.class);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void getBDEntidad(){
        List<Entidad>  listadoEntidades= Entidad.listAll(Entidad.class);
        if(listadoEntidades.size()>0){
            ///no hacemos nada el catalogo ya esta poblado
            Log.d(TAG, "Entidad Ok.");
        }else{
            Entidad e=new Entidad("PUEBLA",21);
            e.save();
            Log.d(TAG, "Entidad CREADA");
        }
    }
    public void getBDMunicipio(){
        List<Municipio>  listadoMunicipios= Municipio.listAll(Municipio.class);
        if(listadoMunicipios.size()>0){
            ///no hacemos nada el catalogo ya esta poblado
            Log.d(TAG, "Municipios OK");
        }else{
            InicializadorDatos i=new InicializadorDatos();
            i.InitMunicipio();
            Log.d(TAG, "Municipios CREADOS");
        }
    }

    public void getBDLocalidad(){
        List<Localidad>  listadoLocalidad= Localidad.listAll(Localidad.class);
        if(listadoLocalidad.size()>0){
            ///no hacemos nada el catalogo ya esta poblado
        }else{
            InicializadorDatos i=new InicializadorDatos();
            i.InitLocalidad();
        }
    }

    public void getBDAgeb(){
        List<Ageb>  listadoAgeb= Localidad.listAll(Ageb.class);
        if(listadoAgeb.size()>0){
            ///no hacemos nada el catalogo ya esta poblado
        }else{
            InicializadorDatos i=new InicializadorDatos();
            i.InitAgeb();
        }
    }
}
