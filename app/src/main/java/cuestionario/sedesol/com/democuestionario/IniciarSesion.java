package cuestionario.sedesol.com.democuestionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.List;

import cuestionario.entidades.Usuario;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.PageOne;

import static android.content.ContentValues.TAG;

public class IniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
