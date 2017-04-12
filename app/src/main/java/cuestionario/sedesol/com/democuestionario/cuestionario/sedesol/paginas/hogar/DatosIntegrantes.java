package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import cuestionario.sedesol.com.democuestionario.R;

public class DatosIntegrantes extends AppCompatActivity {

    Spinner spinerDtosIntegrantes;
    Spinner spinerParentezco;
    Spinner spinertieneCurp;
    Spinner spinerSexo;
    Spinner spinerEstadoNacimiento;
    Spinner spinerTieneActa;
    Spinner spinerViveElPadre;
    Spinner spinerViveLaMadre;
    TextView nombreCompletoTV;
    TextView tieneCurpTV;
    TextView nombreCurp;
    TextView edadTV;
    TextView sexoTV;
    TextView lugarNacimientoTV;
    TextView tieneActaTV;
    TextView viveElPadreTV;
    TextView viveLaMadreTV;
    TextView parentezcoTV;
    TextView anioTV;
    TextView desdeQueAnioTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_integrantes);
        spinerDtosIntegrantes= (Spinner) findViewById(R.id.spinnerCondicionResidencia);
        Intent intent = getIntent();
        String nombreCompleto=intent.getStringExtra("nombreEncuestado");
        nombreCompletoTV= (TextView) findViewById(R.id.nombreIntegrante);
        nombreCompletoTV.setText("La siguientes preguntas se refieren a "+nombreCompleto+"");
        parentezcoTV= (TextView) findViewById(R.id.parentezcoText);
        parentezcoTV.setText("¿Qué parentesco tiene con el (JEFE (A) DEL HOGAR?");
        anioTV= (TextView) findViewById(R.id.anioNacioText);
        anioTV.setText("¿En que año nacio?");
        tieneCurpTV= (TextView) findViewById(R.id.tieneCurpText);
        tieneCurpTV.setText("¿Tiene CURP?" );
        nombreCurp= (TextView) findViewById(R.id.nombreCurpText);
        nombreCurp.setText("¿Cual es su CURP?" );
        edadTV= (TextView) findViewById(R.id.edadText);
        edadTV.setText("¿Cuántos años cumplidos tiene?" );
        sexoTV= (TextView) findViewById(R.id.sexoText);
        sexoTV.setText("¿es hombre o mujer?" );
        lugarNacimientoTV= (TextView) findViewById(R.id.lugarNacimientoText);
        lugarNacimientoTV.setText("¿En qué estado de la República Mexicana nació?" );

        tieneActaTV= (TextView) findViewById(R.id.tieneActaText);
        tieneActaTV.setText("¿Tiene acta de nacimiento?");
        viveElPadreTV= (TextView) findViewById(R.id.viveElPadreText);
        viveElPadreTV.setText("¿Vive su padre en este hogar?" );
        viveLaMadreTV= (TextView) findViewById(R.id.viveLaMadreText);
        viveLaMadreTV.setText("¿Vive su madre este hogar?" );
        desdeQueAnioTV= (TextView) findViewById(R.id.resideEnMexicoText);
        desdeQueAnioTV.setText("¿Desde que año reside en México?" );

        String [] arregloCondicionResidencia={"--","vive normalmente en su domicilio",
                "vive en otro lugar porque está trabajando, estudiando o por otra razón",
                "vive temporalmente en el domicilio porque no tiene otro lugar donde vivir",
                "vive en el domicilio aunque por ahora está en otro lugar",
                "no existe esa persona",
                "ya no vive en el hogar",
                "se murió",
                "migró"};
        ArrayAdapter adapterCondicionResidencia = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloCondicionResidencia);
        spinerDtosIntegrantes.setAdapter(adapterCondicionResidencia);

        spinerParentezco=(Spinner) findViewById(R.id.spinnerParentezco);
        String [] arregloParentezco={"--","Jefe(a)del hogar",
                "Cónyuge o compañero(a)",
                "Hijo(a)",
                "Padre o madre",
                "Hermano(a)",
                "Nieto(a)",
                "Nuera o yerno",
                "Suegro(a)",
                "Hijastro(a) / entenado(a)",
                "Sobrino(a)",
                "Otro parentesco",
                "No tiene parentesco"};
        ArrayAdapter adapterParentezco = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloParentezco);
        spinerParentezco.setAdapter(adapterParentezco);

        spinertieneCurp=(Spinner) findViewById(R.id.spinnerTieneCurp);
        String [] arregloTieneCurp={"--","Sí","Sí, pero no la tiene al momento de la encuesta","No"};
        ArrayAdapter adapterTieneCurp = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTieneCurp);
        spinertieneCurp.setAdapter(adapterTieneCurp);

        spinerSexo=(Spinner) findViewById(R.id.spinnerSexo);
        String [] arregloSexo={"--","Hombre","Mujer"};
        ArrayAdapter adapterSexo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSexo);
        spinerSexo.setAdapter(adapterSexo);

        spinerEstadoNacimiento=(Spinner) findViewById(R.id.spinnerLugarNacimiento);
        String [] arregloEstadoNacimiento={"--","Aguascalientes","Baja California","Baja California Sur",
                "Campeche","Coahuila","Colima","Chiapas","Chihuahua",
                "Distrito Federal","Durango","Guanajuato","Guerrero",
                "Hidalgo","Jalisco","México","Michoacán","Morelos",
                "Nayarit","Nuevo León","Oaxaca","Puebla","Querétaro",
                "Quintana Roo","San Luis Potosí","Sinaloa","Sonora",
                "Tabasco","Tamaulipas","Tlaxcala","Veracruz","Yucatán","Zacatecas","Extranjero"};
        ArrayAdapter adapterEdoNacimiento = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloEstadoNacimiento);
        spinerEstadoNacimiento.setAdapter(adapterEdoNacimiento);

        spinerTieneActa=(Spinner) findViewById(R.id.spinnerTieneActa);
        String [] arregloTieneActa={"--","Sí","Sí, pero no la tiene al momento de la encuesta","No"};
        ArrayAdapter adapterTieneActa= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloTieneActa);
        spinerTieneActa.setAdapter(adapterTieneActa);

        spinerViveElPadre=(Spinner) findViewById(R.id.spinnerViveElPadre);
        String [] arregloVive={"--","Sí",
                "No",
                "No vive en el hogar",
        "Ya no vive","NS/NR"};
        ArrayAdapter adapterVive = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloVive);
        spinerViveElPadre.setAdapter(adapterVive);
        spinerViveLaMadre=(Spinner) findViewById(R.id.spinnerViveLaMadre);
        spinerViveLaMadre.setAdapter(adapterVive);
    }
    public void irADatosDeintegrante2(View view) {
        Intent intent = new Intent(this, Pagina1.class);
        intent.putExtra("nombreEncuestado",nombreCompletoTV.getText());
        startActivity(intent);
    }
}
