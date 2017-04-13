package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import cuestionario.sedesol.com.democuestionario.R;

public class Pagina1 extends AppCompatActivity {
    Spinner spinerDerechohabiencia;
    Spinner spinerHablaIndigena;
    Spinner spinerHablaEspaniol;
    Spinner spinerSeConsideraIndigena;
    Spinner spinerSabeLeer;
    Spinner spinerGrado;
    Spinner spinerAnios;
    Spinner spinerAsisteAlaEsc;
    Spinner spinerMotivoNoEscuela;
    Spinner spinerEsCasado;
    Spinner spinerViveSuPareja;
    Spinner spinerListadoIntegrantes;
    Spinner spinerLenguasIndigenas;


    TextView nombreCompletoTV;
    String nombreCompletoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina1);
        Intent intent = getIntent();
        String nombreCompleto=intent.getStringExtra("nombreEncuestado");
        nombreCompletoP=intent.getStringExtra("soloNombre");
        nombreCompletoTV= (TextView) findViewById(R.id.nombreCompletoText);
        nombreCompletoTV.setText(nombreCompleto);
        spinerDerechohabiencia=(Spinner) findViewById(R.id.spinnerDerechohabiencia);
        spinerHablaIndigena=(Spinner) findViewById(R.id.spinnerHablaIndigena);
        spinerHablaEspaniol=(Spinner) findViewById(R.id.spinnerHablaEspañol);
        spinerSeConsideraIndigena=(Spinner) findViewById(R.id.spinnerSeConsideraIndigena);
        spinerLenguasIndigenas=(Spinner) findViewById(R.id.spinnerLenguasIndigenas);
        spinerSabeLeer=(Spinner) findViewById(R.id.spinnerSabeLeer);
        spinerGrado=(Spinner) findViewById(R.id.spinnerGrado);
        spinerAnios=(Spinner) findViewById(R.id.spinnerAnios);
        spinerAsisteAlaEsc=(Spinner) findViewById(R.id.spinnerAsisteALaEscuela);
        spinerMotivoNoEscuela=(Spinner) findViewById(R.id.spinnerMotivoAbandonoEscuela);
        spinerEsCasado=(Spinner) findViewById(R.id.spinnerEsCasado);
        spinerViveSuPareja=(Spinner) findViewById(R.id.spinnerViveSuPareja);
        spinerListadoIntegrantes=(Spinner) findViewById(R.id.spinnerListadoIntegrantes);

        String [] arregloDerechohabiencia={"--","Prestación en el trabajo","Jubilación","Invalidez","Algún familiar en el hogar","Muerte del asegurado",
                "Ser estudiante","Contratación propia","Algún familiar de otro hogar","Apoyo del gobierno"};
        ArrayAdapter adapterDerecho = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloDerechohabiencia);
        spinerDerechohabiencia.setAdapter(adapterDerecho);

        String [] arregloHablaIndigena={"--","Si","No"};
        ArrayAdapter adapterHablaI = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloHablaIndigena);
        spinerHablaIndigena.setAdapter(adapterHablaI);
        spinerHablaEspaniol.setAdapter(adapterHablaI);
        spinerSabeLeer.setAdapter(adapterHablaI);

        String [] arregloSeConsideraIndigena={"--","Si","No","NS/NR"};
        ArrayAdapter adapterSeCons = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSeConsideraIndigena);
        spinerSeConsideraIndigena.setAdapter(adapterSeCons);

        String [] arregloLenguasIndigenas={"--","Náhuatl","Maya","Zapoteco","Mixteco",
        "Tsotsil/tsetsal","Otomí","Totonaca","Mazateco","Chol","Huasteco",
        "Chinanteco","Mazahua","Mixe","Otro"};
        ArrayAdapter adapterLenguasI = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloLenguasIndigenas);
        spinerLenguasIndigenas.setAdapter(adapterLenguasI);

        String [] arregloGrado={"--","Kínder o preescolar","Primaria","Secundaria",
                "Preparatoria o Bachillerato","Normal básica",
            "Carrera técnica o comercial con primaria completa",
                    "Carrera técnica o comercial con secundaria completa",
                    "Carrera técnica o comercial con preparatoria completa",
                    "Profesional","Posgrado (maestría o doctorado)","Ninguno"};
        ArrayAdapter adapterGrado = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloGrado);
        spinerGrado.setAdapter(adapterGrado);

        String [] arregloAniosAprobados={"--","1 año","2 años","3 años","4 años", "5 años", "6 años"};
        ArrayAdapter adapterAnios = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloAniosAprobados);
        spinerAnios.setAdapter(adapterAnios);

        String [] arregloMotivoAbandono={"--","Concluyó sus estudios","No alcanzó el dinero para mandarlo",
                "Se necesitó su ayuda en el trabajo o en la casa","Tuvo que quedarse en casa para cuidar a otras personas",
                "Decidió empezar a trabajar","No le gusta la escuela","No hay escuela en el lugar donde vive o la escuela está muy lejos",
                "Se casó o por maternidad/paternidad","Nunca ha ido a la escuela",
                "Reprobó varias materias","Ambiente inseguro en la escuela y alrededores",
                "Sus compañeros lo molestaban mucho","Sus padres ya no quisieron que siguiera estudiando",
                "No lo aceptaron en la escuela","No había clases","Otra causa","No sabe/No responde"};
        ArrayAdapter adapterMotivo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMotivoAbandono);
        spinerMotivoNoEscuela.setAdapter(adapterMotivo);

        String [] arregloEdoCivil={"--","Vive en unión libre","Es casado(a)",
                "Es separado(a)","Es divorciado(a)","Es viudo(a)",
                "Es soltero(a)"};
        ArrayAdapter adapterEsCasado = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloEdoCivil);
        spinerEsCasado.setAdapter(adapterEsCasado);

        String [] arregloviveSuPareja={"--","Si","No vive en el hogar","NS/NR"};
        ArrayAdapter adapterPareja = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloviveSuPareja);
        spinerViveSuPareja.setAdapter(adapterPareja);

        ////ir por la lista de personas registradas e ingresarlñas al spinner
        String [] arregloIntegrantes={"--","Si","No vive en el hogar","NS/NR"};
        ArrayAdapter adapterIntegrantes = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloIntegrantes);
        spinerListadoIntegrantes.setAdapter(adapterPareja);
    }

    public void irADatosDeintegrante3(View view) {
        Intent intent = new Intent(this, Pagina2.class);
        intent.putExtra("nombreEncuestado",nombreCompletoTV.getText());
        intent.putExtra("soloNombre",nombreCompletoP);
        startActivity(intent);
    }
}
