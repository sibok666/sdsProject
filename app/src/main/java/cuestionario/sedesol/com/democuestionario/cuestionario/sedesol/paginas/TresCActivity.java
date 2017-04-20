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

public class TresCActivity extends AppCompatActivity {
    Spinner spinerTipoVialidad;
    EditText nombreVialidad;
    EditText numeroExterior;
    EditText numeroInterior;
    EditText numeroExtAnt;
    EditText letraExt;
    EditText letraInterior;

    EncuestaGeneralPre encuestaGeneralPre;
    String tipoVialidadEncuesta;
    String nombreVialidadEncuesta;
    Integer numeroExtEncuesta;
    String letraExteriorEncuesta;
    String letraIntEncuesta;
    Integer numExtAntEncuesta;
    Integer numInteriorEncuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_c);
        spinerTipoVialidad=(Spinner)findViewById(R.id.spinnerTipoVialidad);
        nombreVialidad=(EditText)findViewById(R.id.editText19);
        numeroExterior=(EditText)findViewById(R.id.editText20);
        letraExt=(EditText)findViewById(R.id.editText21);
        numeroExtAnt=(EditText)findViewById(R.id.editText22);
        numeroInterior=(EditText)findViewById(R.id.editText23);
        letraInterior=(EditText)findViewById(R.id.editText16);

        Intent i=getIntent();
        //encuestaGeneralPre=(EncuestaGeneralPre) i.getParcelableExtra("encuestaGeneralPre");
        Bundle bundle=i.getExtras();
        encuestaGeneralPre=(EncuestaGeneralPre)bundle.getSerializable("EncuestaGeneralPre");
        String [] arregloTipoVialidad={"--","Ampliación","Andador","Avenida","Boulevard","Calle",
        "Callejón","Calzada","Cerrada","Circuito","Circunvalación","Continuación","Corredor",
        "Diagonal","Eje vial","Pasaje","Peatonal","Periférico","Privada","Prolongación","Retorno","Viaducto","Ninguno"};
        ArrayAdapter adapterTipoVialidad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTipoVialidad);
        spinerTipoVialidad.setAdapter(adapterTipoVialidad);

    }
    public void irAApartadoTresC2(View view) {
        tipoVialidadEncuesta=spinerTipoVialidad.getSelectedItem().toString();
        nombreVialidadEncuesta=nombreVialidad.getText().toString();
        if(numeroExterior.getText().toString().equals("")){
            numeroExtEncuesta=0;
        }else{
            numeroExtEncuesta=Integer.parseInt(numeroExterior.getText().toString());
        }
        letraExteriorEncuesta=letraExt.getText().toString();
        if(numeroExtAnt.getText().toString().equals("")){
            numExtAntEncuesta=0;
        }else{
            numExtAntEncuesta=Integer.parseInt(numeroExtAnt.getText().toString());
        }
        if(numeroInterior.getText().toString().equals("")){
            numInteriorEncuesta=0;
        }else{
            numInteriorEncuesta=Integer.parseInt(numeroInterior.getText().toString());
        }
        letraIntEncuesta=letraInterior.getText().toString();

        encuestaGeneralPre.setC3TipoVialidad(tipoVialidadEncuesta);
        encuestaGeneralPre.setC3NombreAsentamiento(nombreVialidadEncuesta);
        encuestaGeneralPre.setC3NumeroExt(""+numeroExtEncuesta);
        encuestaGeneralPre.setC3NumExtAnt(""+numeroExtAnt);
        encuestaGeneralPre.setC3letra(letraExteriorEncuesta);
        encuestaGeneralPre.setC3LetraInterior(letraIntEncuesta);
        encuestaGeneralPre.setC3NumInterior(""+numInteriorEncuesta);


        Intent intent = new Intent(this, TresCSecondActivity.class);
        //intent.putExtra("encuestaGeneralPre", encuestaGeneralPre);
        //intent.putExtra("EncuestaGeneralPre",encuestaGeneralPre);
        Bundle bundle=new Bundle();
        bundle.putSerializable("EncuestaGeneralPre",encuestaGeneralPre);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
