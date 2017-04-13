package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cuestionario.sedesol.com.democuestionario.R;

public class TresCActivity extends AppCompatActivity {
    Spinner spinerTipoVialidad;

    String tipoVialidadEncuesta;
    String nombreVialidadEncuesta;
    Integer numeroExtEncuesta;
    String letraIntEncuesta;
    Integer numExtAntEncuesta;
    Integer numInteriorEncuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_c);
        spinerTipoVialidad=(Spinner)findViewById(R.id.spinnerTipoVialidad);

        String [] arregloTipoVialidad={"--","Ampliación","Andador","Avenida","Boulevard","Calle",
        "Callejón","Calzada","Cerrada","Circuito","Circunvalación","Continuación","Corredor",
        "Diagonal","Eje vial","Pasaje","Peatonal","Periférico","Privada","Prolongación","Retorno","Viaducto","Ninguno"};
        ArrayAdapter adapterTipoVialidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTipoVialidad);
        spinerTipoVialidad.setAdapter(adapterTipoVialidad);

    }
    public void irAApartadoTresC2(View view) {
        Intent intent = new Intent(this, TresCSecondActivity.class);
        startActivity(intent);
    }
}
