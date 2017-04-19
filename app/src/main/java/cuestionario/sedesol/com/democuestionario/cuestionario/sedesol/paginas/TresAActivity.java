package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import cuestionario.entidades.EncuestaGeneralPre;
import cuestionario.sedesol.com.democuestionario.R;

public class TresAActivity extends AppCompatActivity {
    Spinner spinerTipoAdministracion;
    Spinner spinerDerechoTransito;
    String tipoAdministracionEncuesta="";
    String derechoATranstoEncuesta="";
    EditText codigoCarretera;
    EditText origen;
    EditText destino;
    EditText Km;
    EditText metros;
    String codigoCarreteraEncuesta="";
    String origenEncuesta="";
    String destinoEncuesta="";
    String KmEncuesta="";
    String metrosEncuesta="";
    EncuestaGeneralPre encuestaGeneralPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_a);

        Intent i=getIntent();
        //encuestaGeneralPre=(EncuestaGeneralPre) i.getSerializableExtra("encuestaGeneralPre");
        Bundle bundle=i.getExtras();
        encuestaGeneralPre=(EncuestaGeneralPre)bundle.getSerializable("EncuestaGeneralPre");

        spinerTipoAdministracion=(Spinner)findViewById(R.id.spinnerTipoAdministracion);
        spinerDerechoTransito=(Spinner)findViewById(R.id.spinnerDerechoTransito);

        codigoCarretera= (EditText) findViewById(R.id.textCarretera);
        origen= (EditText) findViewById(R.id.textOrigen);
        destino= (EditText) findViewById(R.id.textDestino);
        Km= (EditText) findViewById(R.id.editTextKm);
        metros= (EditText) findViewById(R.id.editTextMetros);



        String [] arregloTipoAdministracion={"--","Estatal", "Federal","Municipal","Particular"};
        String [] arregloDerechoTransito={"--","Cuota","Libre"};
        ArrayAdapter adapterTipoAdministracion = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTipoAdministracion);
        ArrayAdapter adapterDerechoTransito = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloDerechoTransito);
        spinerTipoAdministracion.setAdapter(adapterTipoAdministracion);
        spinerDerechoTransito.setAdapter(adapterDerechoTransito);

    }
    public void irAApartadoIdentificacionDelHogar(View view) {
        tipoAdministracionEncuesta=spinerTipoAdministracion.getSelectedItem().toString();
        derechoATranstoEncuesta=spinerDerechoTransito.getSelectedItem().toString();
        ///el siguiente campofalta en las entidades encuesta
        codigoCarreteraEncuesta=codigoCarretera.getText().toString();
        origenEncuesta=origen.getText().toString();
        destinoEncuesta=destino.getText().toString();
        KmEncuesta=Km.getText().toString();
        metrosEncuesta=metros.getText().toString();

        encuestaGeneralPre.setA3derechoTransito(derechoATranstoEncuesta);
        encuestaGeneralPre.setA3tipoAdminCarretera(tipoAdministracionEncuesta);
        encuestaGeneralPre.setA3codigoCarretera(codigoCarreteraEncuesta);
        encuestaGeneralPre.setA3Origen(origenEncuesta);
        encuestaGeneralPre.setA3Destino(destinoEncuesta);
        encuestaGeneralPre.setA3Km(KmEncuesta);
        encuestaGeneralPre.setA3Metros(metrosEncuesta);

        Intent intent = new Intent(this, IdentificacionDelHogar.class);
        //intent.putExtra("EncuestaGeneralPre",encuestaGeneralPre);
        Bundle bundle=new Bundle();
        bundle.putSerializable("EncuestaGeneralPre",encuestaGeneralPre);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
