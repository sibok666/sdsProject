package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cuestionario.sedesol.com.democuestionario.R;

public class TresBActivity extends AppCompatActivity {
    Spinner spinerTerminoGenerico;
    Spinner spinerMargen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_b);
        spinerTerminoGenerico=(Spinner)findViewById(R.id.spinnerTerminoGenerico);
        spinerMargen=(Spinner)findViewById(R.id.spinnerMargen);

        String [] arregloTerminoGenerico={"--","Brecha","Camino","Terracería","Vereda"};
        String [] arregloMargen={"--","Derecho","Izquierdo"};
        ArrayAdapter adapterTerminoGenerico = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTerminoGenerico);
        ArrayAdapter adapterMargen = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMargen);
        spinerTerminoGenerico.setAdapter(adapterTerminoGenerico);
        spinerMargen.setAdapter(adapterMargen);
    }

    public void irAApartadoIdentificacionDelHogar(View view) {
        Intent intent = new Intent(this, IdentificacionDelHogar.class);
        startActivity(intent);
    }
}
