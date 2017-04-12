package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

import android.content.Intent;
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
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.PageOne;

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
    }

    public void agregarInterganteALista(View view) {
       String nombreCompleto=nombre.getText()+" "+apellidoP.getText()+" "+apellidoM.getText();
       // arrayList.add(nombre.getText().toString());
       // adapter.notifyDataSetChanged();
        TableRow tableRow=new TableRow(this);
        TextView nombre = new TextView(this);
        nombre.setText(nombreCompleto);
        final Button botonContestar=new Button(this);
        botonContestar.setId(renglon);
        botonContestar.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                TableRow row = (TableRow)tabla.getChildAt(botonContestar.getId());
                TextView nombre=(TextView)row.getChildAt(0);
                String nombreCompleto=""+nombre.getText();
                Intent intent = new Intent(v.getContext(), DatosIntegrantes.class);
                intent.putExtra("nombreEncuestado",nombreCompleto);
                startActivity(intent);
            }
        });
        botonContestar.setText("Contestar");
        tableRow.addView(nombre);
        tableRow.addView(botonContestar);
        tabla.addView(tableRow);
        renglon++;
    }
}
