package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cuestionario.sedesol.com.democuestionario.R;

public class TresAActivity extends AppCompatActivity {
    Spinner spinerTipoAdministracion;
    Spinner spinerDerechoTransito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_a);

        spinerTipoAdministracion=(Spinner)findViewById(R.id.spinnerTipoAdministracion);
        spinerDerechoTransito=(Spinner)findViewById(R.id.spinnerDerechoTransito);

        String [] arregloTipoAdministracion={"--","Estatal", "Federal","Municipal","Particular"};
        String [] arregloDerechoTransito={"--","Cuota","Libre"};
        ArrayAdapter adapterTipoAdministracion = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTipoAdministracion);
        ArrayAdapter adapterDerechoTransito = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloDerechoTransito);
        spinerTipoAdministracion.setAdapter(adapterTipoAdministracion);
        spinerDerechoTransito.setAdapter(adapterDerechoTransito);

    }
    public void irAApartadoIdentificacionDelHogar(View view) {
        Intent intent = new Intent(this, IdentificacionDelHogar.class);
        startActivity(intent);
    }
}
