package cuestionario.sedesol.com.democuestionario;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import cuestionario.entidades.Ageb;
import cuestionario.entidades.Entidad;
import cuestionario.entidades.InicializadorDatos;
import cuestionario.entidades.Localidad;
import cuestionario.entidades.Manzana;
import cuestionario.entidades.Municipio;
import cuestionario.entidades.Usuario;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.PageOne;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Double latitud;
    Double longitud;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////obtenemos la latitud y longitud
        //GPSTracker gps = new GPSTracker(MainActivity.this);
        // check if GPS enabled
        //if(gps.canGetLocation()){
        //    latitud = gps.getLatitude();
        //    longitud = gps.getLongitude();
        //}else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
        //    gps.showSettingsAlert();
        //}

        List<Usuario> usuarios = Usuario.listAll(Usuario.class);

        if(usuarios.size()>0){
            Intent intent = new Intent(this, IniciarSesion.class);
            Log.d(TAG, "Usuario ya registrado");
            startActivity(intent);
        }

        progress=new ProgressDialog(this);

    }

    /** Called when the user clicks the Send button */
    public void IniciarUso(View view) {
        ///
        EditText nombre=(EditText) findViewById(R.id.nombreRegistro);
        EditText direccion=(EditText) findViewById(R.id.direccionRegistro);
        EditText edad=(EditText) findViewById(R.id.edadRegistro);
        EditText telefono=(EditText) findViewById(R.id.telefonoRegistro);
        EditText contrasenia=(EditText) findViewById(R.id.contraseniaRegistro);
        EditText confirmacionContrasenia=(EditText) findViewById(R.id.confirmacionContraseniaRegistro);

        String nombreR=nombre.getText().toString();
        String direccionR=direccion.getText().toString();
        String edadR=edad.getText().toString();
        String telefonoR=telefono.getText().toString();
        String contraseniaR=contrasenia.getText().toString();
        String confirmacionContraseniaR=contrasenia.getText().toString();

        Integer edadRI=0;

        try{
            edadRI=Integer.parseInt(edadR);
        }catch(Exception e){

        }

        String usuario="test";
        if(contraseniaR.equals("")){
            usuario="test";
        }
        Log.d(TAG, "Start time-----------"+new Date());
        Usuario u=new Usuario(nombreR,direccionR,edadRI,telefonoR,contraseniaR,usuario);
        u.save();
        progress.setTitle("Cargando");
        progress.setMessage("Espera mientras configuramos...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        getBDEntidad();
        getBDMunicipio();
        InitLocalidad();
        InitAgeb();
        InitManzana();
        // To dismiss the dialog
        progress.dismiss();
        Intent intent = new Intent(this, IniciarSesion.class);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        Log.d(TAG, "Finish time-----------"+new Date());
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


    public int InitLocalidad(){
        Log.d(TAG,"Loading localidades...");
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.localidades);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = TextUtils.split(line, ",");
                Localidad l=new Localidad(s[0],s[1],s[2]);
                l.save();
            }
        }catch(Exception e){

        }
        Log.d(TAG, "DONE loading localidades.");
        return 1;
    }
    public int InitAgeb(){
        Log.d(TAG,"Loading ageb...");
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.ageb);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = TextUtils.split(line, ",");
                Ageb a=new Ageb(s[0],s[1],s[2]);
                a.save();
            }
        }catch(Exception e){

        }
        Log.d(TAG, "DONE loading ageb.");
        return 1;
    }

    public int InitManzana(){
        Log.d(TAG,"Loading manzana...");
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.manzana);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = TextUtils.split(line, ",");
                Manzana m=new Manzana(s[0],s[1],s[2]);
                m.save();
            }
        }catch(Exception e){

        }
        Log.d(TAG, "DONE loading manzana.");
        return 1;
    }

    public int InitPregunta(){
        Log.d(TAG,"Loading manzana...");
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.manzana);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = TextUtils.split(line, ",");
                Manzana m=new Manzana(s[0],s[1],s[2]);
                m.save();
            }
        }catch(Exception e){

        }
        Log.d(TAG, "DONE loading manzana.");
        return 1;
    }

}
