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

public class TresCSecondActivity extends AppCompatActivity {
    Spinner tipoAsentamiento;
    Spinner tipoVialidad1;
    Spinner tipoVialidad2;
    Spinner tipoVialidad3;
    EditText nombreAsentamiento;
    EditText nombreEntrevialidad1;
    EditText nombreEntrevialidad2;
    EditText nombreVialidadPosterior;

    String tipoAsentamientoEncuesta;
    String nombreAsentamientoEncuesta;
    String entrevialidad1TipoEncuesta;
    String entrevialidad1NombreEncuesta;
    String entrevialidad2TipoEncuesta;
    String entrevialidad2NombreEncuesta;
    String vialidadPosteriorTipoEncuesta;
    String vialidadPosteriorNombreEncuesta;

    EncuestaGeneralPre encuestaGeneralPre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres_csecond);
        tipoAsentamiento=(Spinner)findViewById(R.id.spinnerTipoAsentamiento);
        tipoVialidad1=(Spinner)findViewById(R.id.spinnerTipoVialidad1);
        tipoVialidad2=(Spinner)findViewById(R.id.spinnerTipoVialidad2);
        tipoVialidad3=(Spinner)findViewById(R.id.spinnerTipoVialidad3);
        nombreAsentamiento=(EditText)findViewById(R.id.editText24);
        nombreEntrevialidad1=(EditText)findViewById(R.id.editText26);
        nombreEntrevialidad2=(EditText)findViewById(R.id.editText28);
        nombreVialidadPosterior=(EditText)findViewById(R.id.editText29);

        Intent i=getIntent();
        //encuestaGeneralPre=(EncuestaGeneralPre) i.getParcelableExtra("encuestaGeneralPre");
        Bundle bundle=i.getExtras();
        encuestaGeneralPre=(EncuestaGeneralPre)bundle.getSerializable("EncuestaGeneralPre");

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
        tipoAsentamientoEncuesta=tipoAsentamiento.getSelectedItem().toString();
        nombreAsentamientoEncuesta=nombreAsentamiento.getText().toString();
        entrevialidad1TipoEncuesta=tipoVialidad1.getSelectedItem().toString();
        entrevialidad1NombreEncuesta=nombreEntrevialidad1.getText().toString();
        entrevialidad2TipoEncuesta=tipoVialidad2.getSelectedItem().toString();
        entrevialidad2NombreEncuesta=nombreEntrevialidad2.getText().toString();
        vialidadPosteriorTipoEncuesta=tipoVialidad3.getSelectedItem().toString();
        vialidadPosteriorNombreEncuesta=nombreVialidadPosterior.getText().toString();

        encuestaGeneralPre.setC3tipoAsentamiento(tipoAsentamientoEncuesta);
        encuestaGeneralPre.setC3NombreAsentamiento(nombreAsentamientoEncuesta);
        encuestaGeneralPre.setC3Entrevialidad1Tipo(entrevialidad1TipoEncuesta);
        encuestaGeneralPre.setC3Entrevialidad1Nombre(entrevialidad1NombreEncuesta);
        encuestaGeneralPre.setC3Entrevialidad2Tipo(entrevialidad2TipoEncuesta);
        encuestaGeneralPre.setC3Entrevialidad2Nombre(entrevialidad2NombreEncuesta);
        encuestaGeneralPre.setC3VialidadPosteriorTipo(vialidadPosteriorTipoEncuesta);
        encuestaGeneralPre.setC3VialidadPosteriorNombre(vialidadPosteriorNombreEncuesta);


        Intent intent = new Intent(this, IdentificacionDelHogar.class);
        //intent.putExtra("encuestaGeneralPre",  encuestaGeneralPre);
        //intent.putExtra("EncuestaGeneralPre",encuestaGeneralPre);
        Bundle bundle=new Bundle();
        bundle.putSerializable("EncuestaGeneralPre",encuestaGeneralPre);
        startActivity(intent);
    }
}
