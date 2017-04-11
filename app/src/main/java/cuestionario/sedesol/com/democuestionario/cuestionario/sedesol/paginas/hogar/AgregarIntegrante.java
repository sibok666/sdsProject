package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar;

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

public class AgregarIntegrante extends AppCompatActivity {
    ListView listaIntegrantes;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    EditText nombre;
    TextView nombreCompleto;
    EditText apellidoP;
    EditText apellidoM;
    TableLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_integrante);
        listaIntegrantes=(ListView) findViewById(R.id.listaIntegrantes);
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList);
        listaIntegrantes.setAdapter(adapter);
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
        Button botonContestar=new Button(this);
        botonContestar.setText("Contestar");
        tableRow.addView(nombre);
        tableRow.addView(botonContestar);

    }
}
