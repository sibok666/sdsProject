package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cuestionario.sedesol.com.democuestionario.R;

public class IdentificacionDelHogar extends AppCompatActivity {
    Spinner spinerInformanteAdecuado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion_del_hogar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinerInformanteAdecuado=(Spinner)findViewById(R.id.spinnerInformanteAdecuado);

        String [] arregloInformante={"--","Si","No"};
        ArrayAdapter adapterInformanteAdecuado = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloInformante);
        spinerInformanteAdecuado.setAdapter(adapterInformanteAdecuado);

    }

    public void evaluarInformanteAdecuado2(View view) {

        String seleccion=spinerInformanteAdecuado.getSelectedItem().toString();
        if(seleccion.equals("Si")){
            Intent intent = new Intent(this, IdentificacionDelHogarSecond.class);
            startActivity(intent);
        }else if(seleccion.equals("No")){
            Intent intent = new Intent(this, ResultadoEncuesta.class);
            startActivity(intent);
        }else if(seleccion.equals("--")){

        }
    }
}
