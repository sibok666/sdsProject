package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import cuestionario.sedesol.com.democuestionario.R;

public class Pagina2 extends AppCompatActivity {

    Spinner spinerMesPasado;
    Spinner spinerActividadesMesPasado;
    Spinner spinerMotivoNoTrabajar;
    Spinner spinerSeDesempeniaComo;
    Spinner spinerSeDedicaATrabajar;
    Spinner spinerMotivoNoTrabajo;
    Spinner spinerTuvoJefe;
    Spinner spinerActividadPorSucuenta;

    TextView nombreCompletoTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina2);
        Intent intent = getIntent();
        String nombreCompleto=intent.getStringExtra("nombreEncuestado");
        nombreCompletoTV= (TextView) findViewById(R.id.nombreText);
        nombreCompletoTV.setText(nombreCompleto);

        spinerMesPasado=(Spinner)findViewById(R.id.spinnerMesPasado);
        spinerActividadesMesPasado=(Spinner)findViewById(R.id.spinnerActividadesMesPasado);
        spinerMotivoNoTrabajar=(Spinner)findViewById(R.id.spinnerMotivoNoTrabajar);
        spinerSeDesempeniaComo=(Spinner)findViewById(R.id.spinnerSeDesempeniaComo);
        spinerSeDedicaATrabajar=(Spinner)findViewById(R.id.spinnerSeDedicaATrabajar);
        spinerMotivoNoTrabajo=(Spinner)findViewById(R.id.spinnerMotivoNoTrabajo);
        spinerTuvoJefe=(Spinner)findViewById(R.id.spinnerTuvoJefe);
        spinerActividadPorSucuenta=(Spinner)findViewById(R.id.spinnerActividadPorSucuenta);

        String [] arregloMesPasado={"--","Trabajó",
                "Tenía trabajo pero no trabajó",
                "Estudió y trabajó",
                "No trabajó ni buscó trabajo",
                "Buscó trabajo",
                "Estudió",
                "Realizó quehaceres domésticos"};
        ArrayAdapter adapterMesP = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMesPasado);
        spinerMesPasado.setAdapter(adapterMesP);

        String[] arregloActividadesMesPasado={"--","¿vender o hacer algún producto o realizar trabajos de albañilería, plomería, carpintería u otro?",
                "¿prestar algún servicio a cambio de un pago (cortar el cabello, dar clases, lavar ropa ajena,u otro)?",
                "¿realizar actividades agropecuarias por su cuenta como cultivar o criar animales?",
                "¿ayudar en las tierras o en el negocio de un familiar u otra persona?",
                "No trabajó",
                "No hubo trabajo"};
        ArrayAdapter adapterActMesP = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloActividadesMesPasado);
        spinerActividadesMesPasado.setAdapter(adapterActMesP);

        String[] arregloMotivoNoTrabajar={"--","Se enfermó o estuvo incapacitado(a) para trabajar (temporalmente)",
                "Se jubiló o pensionó",
                "Estuvo cuidando personas (niños/as, personas adultas mayores, personas con discapacidad, enfermos)",
                "Estuvo capacitándose",
                "Enfermedad crónica, discapacidad o invalidez (permanente)",
                "Edad avanzada","Vivió de la renta de alguna propiedad",
                "Otra causa"};
        ArrayAdapter adapterMotivoNoTrabajar = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMotivoNoTrabajar);
        spinerMotivoNoTrabajar.setAdapter(adapterMotivoNoTrabajar);

        String [] arregloSeDesempeniaComo={"--","albañil",
                "artesano",
                "ayudante de algún oficio",
                "ayudante en rancho o negocio familiar sin retribución",
                "ayudante en rancho o negocio no familiar sin retribución",
                "chofer (transporte de pasajero o carga)",
                "ejidatario o comunero",
                "empleado del gobierno",
                "empleado del sector privado",
                "empleado doméstico",
                "jornalero agrícola",
                "miembro de un grupo u organización de productores",
                "miembro de una cooperativa (de producción o servicios)",
                "obrero",
                "patrón o empleador de un negocio",
                "profesionista independiente",
                "promotor de desarrollo humano o gestor social",
                "trabajador por cuenta propia",
                "vendedor ambulante",
                "otra ocupación",
                "No sabe /No responde"};
        ArrayAdapter adapterSeDesem= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSeDesempeniaComo);
        spinerSeDesempeniaComo.setAdapter(adapterSeDesem);

        String [] arregloSeDedicaATrabajar={"--","unos meses al año?",
                "todo el año?",
                "no sabe /No responde"};
        ArrayAdapter adapterSeDedica = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSeDedicaATrabajar);
        spinerSeDedicaATrabajar.setAdapter(adapterSeDedica);

        String [] arregloMotivoNoTrabajo={"--","Sólo trabaja cuando lo llaman o solicitan sus servicios",
                "Sólo trabaja en periodo vacacional/Porque asiste a la escuela",
                "No necesita trabajar todo el año",
                "Sólo cuando encuentra o tiene trabajo",
                "Sólo en tiempo de siembra o cosecha",
                "Por motivos climatológicos",
                "No le interesa trabajar todo el año",
                "Otro",
                "No sabe/No responde"};
        ArrayAdapter adapterMotNoT = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMotivoNoTrabajo);
        spinerMotivoNoTrabajo.setAdapter(adapterMotNoT);

        String [] arregloSiNo={"--","Si","No"};
        ArrayAdapter adapterSiNo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloSiNo);
        spinerTuvoJefe.setAdapter(adapterSiNo);
        spinerActividadPorSucuenta.setAdapter(adapterSiNo);

    }
    public void irADatosDeintegrante4(View view) {
        Intent intent = new Intent(this, Pagina3.class);
        intent.putExtra("nombreEncuestado",nombreCompletoTV.getText());
        startActivity(intent);
    }
}
