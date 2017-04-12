package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import cuestionario.sedesol.com.democuestionario.R;

public class Pagina3 extends AppCompatActivity {
    TextView nombreCompletoTV;
    Button botonFinalizarEncuesta;
    Spinner spinerRecibioPago;
    Spinner spinerCadaCuanto;
    Spinner spinerEsJubilado;
    Spinner spinerTieneInapam;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina3);
        Intent intent = getIntent();
        String nombreCompleto=intent.getStringExtra("nombreEncuestado");
        nombreCompletoTV= (TextView) findViewById(R.id.nombreCompletoText3);
        nombreCompletoTV.setText(nombreCompleto);
        botonFinalizarEncuesta=(Button) findViewById(R.id.buttonFinalizar);
        botonFinalizarEncuesta.setText("Finalizar con "+ nombreCompletoTV);

        spinerRecibioPago=(Spinner) findViewById(R.id.spinnerRecibioPago);
        spinerCadaCuanto=(Spinner) findViewById(R.id.spinnerCadaCuanto);
        spinerEsJubilado=(Spinner) findViewById(R.id.spinnerEsJubilado);
        spinerTieneInapam=(Spinner) findViewById(R.id.spinnerTieneINAPAM);

        String [] arregloSiNo={"--","Si","No"};
        String [] arregloSiNoNr={"--","Si","No","NS/NR"};
        String [] arregloCadaCuanto={"--","Diario","Cada semana","Cada 15 días","Cada mes","Cada año"};

        ArrayAdapter adapterSiNo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSiNo);
        spinerRecibioPago.setAdapter(adapterSiNo);

        ArrayAdapter adapterSiNoNr = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSiNoNr);
        spinerEsJubilado.setAdapter(adapterSiNoNr);
        spinerTieneInapam.setAdapter(adapterSiNoNr);

        ArrayAdapter adapterCadaC = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloCadaCuanto);
        spinerCadaCuanto.setAdapter(adapterCadaC);


    }
    public void irADatosDeintegrante(View view) {
        Intent intent = new Intent(this, DatosIntegrantes.class);
        intent.putExtra("nombreEncuestado",nombreCompletoTV.getText());
        startActivity(intent);
    }
}
