package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import cuestionario.entidades.EncuestaGeneralPre;
import cuestionario.sedesol.com.democuestionario.R;

public class TresBActivity extends AppCompatActivity {
    Spinner spinerTerminoGenerico;
    Spinner spinerMargen;
    EditText origen;
    EditText destino;
    EditText Km;
    EditText metros;

    String terminoGenericoEncuesta;
    String origenEncuesta;
    String destinoEncuesta;
    String margenEncuesta;
    String KmEncuesta;
    String metrosEncuesta;
    EncuestaGeneralPre encuestaGeneralPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_b);
        spinerTerminoGenerico=(Spinner)findViewById(R.id.spinnerTerminoGenerico);
        spinerMargen=(Spinner)findViewById(R.id.spinnerMargen);
        origen=(EditText) findViewById(R.id.editText);
        destino=(EditText) findViewById(R.id.editText2);
        Km=(EditText) findViewById(R.id.editText3);
        metros=(EditText) findViewById(R.id.editText18);

        Intent i=getIntent();
        //encuestaGeneralPre=(EncuestaGeneralPre) i.getParcelableExtra("encuestaGeneralPre");
        Bundle bundle=i.getExtras();
        encuestaGeneralPre=(EncuestaGeneralPre)bundle.getSerializable("EncuestaGeneralPre");
        String [] arregloTerminoGenerico={"--","Brecha","Camino","Terracería","Vereda"};
        String [] arregloMargen={"--","Derecho","Izquierdo"};
        ArrayAdapter adapterTerminoGenerico = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTerminoGenerico);
        ArrayAdapter adapterMargen = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMargen);
        spinerTerminoGenerico.setAdapter(adapterTerminoGenerico);
        spinerMargen.setAdapter(adapterMargen);
    }

    public void irAApartadoIdentificacionDelHogar(View view) {
        terminoGenericoEncuesta=spinerTerminoGenerico.getSelectedItem().toString();
        margenEncuesta=spinerMargen.getSelectedItem().toString();
        origenEncuesta=origen.getText().toString();
        destinoEncuesta=destino.getText().toString();
        KmEncuesta=Km.getText().toString();
        metrosEncuesta=metros.getText().toString();

        encuestaGeneralPre.setB3TerminoGenerico(terminoGenericoEncuesta);
        encuestaGeneralPre.setB3Margen(margenEncuesta);
        encuestaGeneralPre.setB3Origen(origenEncuesta);
        encuestaGeneralPre.setB3Destino(destinoEncuesta);
        encuestaGeneralPre.setB3Km(KmEncuesta);
        encuestaGeneralPre.setB3Metros(metrosEncuesta);

        Intent intent = new Intent(this, IdentificacionDelHogar.class);
        //intent.putExtra("encuestaGeneralPre", encuestaGeneralPre);
        //intent.putExtra("EncuestaGeneralPre",encuestaGeneralPre);
        Bundle bundle=new Bundle();
        bundle.putSerializable("EncuestaGeneralPre",encuestaGeneralPre);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
