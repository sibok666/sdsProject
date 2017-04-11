package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cuestionario.sedesol.com.democuestionario.R;

public class TresCSecondActivity extends AppCompatActivity {
    Spinner tipoAsentamiento;
    Spinner tipoVialidad1;
    Spinner tipoVialidad2;
    Spinner tipoVialidad3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_csecond);
        tipoAsentamiento=(Spinner)findViewById(R.id.spinnerTipoAsentamiento);
        tipoVialidad1=(Spinner)findViewById(R.id.spinnerTipoVialidad1);
        tipoVialidad2=(Spinner)findViewById(R.id.spinnerTipoVialidad2);
        tipoVialidad3=(Spinner)findViewById(R.id.spinnerTipoVialidad3);

        String [] arregloTipoVialidad={"--","Ampliación","Andador","Avenida","Boulevard","Calle",
                "Callejón","Calzada","Cerrada","Circuito","Circunvalación","Continuación","Corredor",
                "Diagonal","Eje vial","Pasaje","Peatonal","Periférico","Privada","Prolongación","Retorno","Viaducto","Ninguno"};
        ArrayAdapter adapterTipoVialidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTipoVialidad);
        tipoVialidad1.setAdapter(adapterTipoVialidad);
        tipoVialidad2.setAdapter(adapterTipoVialidad);
        tipoVialidad3.setAdapter(adapterTipoVialidad);

        String [] arregloTipoAsentamiento={"--","Aeropuerto","Ampliación","Barrio","Cantón","Ciudad","Ciudad industrial","Colonia","Condominio",
                "Conjunto habitacional","Corredor industrial","Coto","Cuartel","Ejido","Exhacienda",
                "Fracción","Fraccionamiento","Granja","Hacienda","Ingenio","Manzana","Paraje",
                "Parque industrial","Privada","Prolongación","Pueblo","Puerto","Ranchería",
                "Rancho","Región","Residencial","Rinconada","Sección",
                "Sector","Supermanzana","Unidad","Unidad habitacional","Villa",
                "Zona federal","Zona industrial","Zona militar","Zona naval","Ninguno"};

        ArrayAdapter adapterTipoAsentamiento = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTipoAsentamiento);
        tipoAsentamiento.setAdapter(adapterTipoAsentamiento);
    }

    public void irAApartadoIdentificacionDelHogar(View view) {
        Intent intent = new Intent(this, IdentificacionDelHogar.class);
        startActivity(intent);
    }
}
