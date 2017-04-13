package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import cuestionario.sedesol.com.democuestionario.R;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.IdentificacionDelHogarSecond;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.PageOne;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.ResultadoEncuesta;

public class AgregarIntegrante extends AppCompatActivity {
    ListView listaIntegrantes;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    EditText nombre;
    TextView nombreCompleto;
    EditText apellidoP;
    EditText apellidoM;
    TableLayout tabla;
    Integer renglon=0;
    String nombreCompletoP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_integrante);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        //listaIntegrantes.setAdapter(adapter);
        nombre=(EditText) findViewById(R.id.textNombre);
        apellidoP=(EditText) findViewById(R.id.apellidoP);
        apellidoM=(EditText) findViewById(R.id.apellidoM);
        tabla= (TableLayout) findViewById(R.id.tablaIntegrantes);
        TableRow tableRow=new TableRow(this);

    }

    public void agregarInterganteALista(View view) {
       String nombreCompleto=nombre.getText()+" "+apellidoP.getText()+" "+apellidoM.getText();
       // arrayList.add(nombre.getText().toString());
       // adapter.notifyDataSetChanged();
        TableRow tableRow=new TableRow(this);
        TextView nombre = new TextView(this);
        nombre.setText(nombreCompleto);
        TextView estatus = new TextView(this);
        estatus.setText("No OK");
        estatus.setTextColor(Color.RED);
        final Button botonContestar=new Button(this);
        botonContestar.setId(renglon);
        botonContestar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TableRow row = (TableRow)tabla.getChildAt(botonContestar.getId());
                TextView nombre=(TextView)row.getChildAt(0);
                String nombreCompleto=""+nombre.getText();
                Intent intent = new Intent(v.getContext(), DatosIntegrantes.class);
                intent.putExtra("nombreEncuestado",nombreCompleto);
                nombreCompletoP=nombreCompleto;
                startActivity(intent);
            }
        });
        botonContestar.setText("Contestar");

        final Button botonEliminar=new Button(this);
        botonEliminar.setId(renglon);
        botonEliminar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TableRow row = (TableRow)tabla.getChildAt(botonEliminar.getId());
                tabla.removeView(row);
            }
        });
        botonEliminar.setText("Eliminar");
        botonEliminar.setTextColor(Color.RED);
        //#0bd423

        tableRow.addView(nombre);
        tableRow.addView(botonContestar);
        tableRow.addView(botonEliminar);
        tableRow.addView(estatus);

        tabla.addView(tableRow);
        renglon++;
    }

}
