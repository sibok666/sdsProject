package cuestionario.sedesol.com.democuestionario;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import cuestionario.entidades.EncuestaSeguimiento;
import cuestionario.entidades.Localidad;
import cuestionario.entidades.Usuario;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.GetAllActivity;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.PageOne;
import cuestionario.utils.Util;

import static android.content.ContentValues.TAG;

public class IniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<EncuestaSeguimiento> encuestas=EncuestaSeguimiento.listAll(EncuestaSeguimiento.class);
        if(encuestas.size()>0){

        }else{
            inicializarBDSeguimiento();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
    }

    public void IniciarSesion(View view) {

        //Note.find(Note.class, "name = ? and title = ?", "satya", "title1");
        //List<Usuario> usuarios = Usuario.find(Usuario.class, "usuario = ? and contrasenia = ?", "test", "test");
        //if(usuarios.size()>=1){
            Intent intent = new Intent(this, PageOne.class);
            startActivity(intent);
        //}

    }

    public void verEncuestas(View view){
        Intent intent = new Intent(this, GetAllActivity.class);
        startActivity(intent);
    }

    public void registrarUsuario(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void verMenu(View view){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }


    public void inicializarBDSeguimiento(){
        Log.d(TAG,"Loading bd seguimiento...");
        final Resources resources =  getResources();
        InputStream inputStream = resources.openRawResource(R.raw.seguimiento_bd_inicial_2017);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Util util=new Util();
        byte []arregloBytes=null;
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = TextUtils.split(line, ",");
                Date d=util.stringADate(s[0]);
                EncuestaSeguimiento en=new EncuestaSeguimiento(d,s[1],s[2],s[3],s[4],s[5],s[6],s[7],s[8],s[9],s[10],s[11],s[12],arregloBytes,arregloBytes,arregloBytes,arregloBytes,arregloBytes,arregloBytes,arregloBytes,arregloBytes,arregloBytes,arregloBytes,0);
                en.save();
            }
        }catch(Exception e){

        }
        Log.d(TAG, "DONE BD seguimiento.");
    }

}
