package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import cuestionario.entidades.Ageb;
import cuestionario.entidades.Localidad;
import cuestionario.entidades.Manzana;
import cuestionario.entidades.Municipio;
import cuestionario.sedesol.com.democuestionario.Cuestionario;
import cuestionario.sedesol.com.democuestionario.R;

public class PageOne extends AppCompatActivity {
    Spinner spinerMunicipio;
    Spinner spinerLocalidad;
    Spinner spinerAgeb;
    Spinner spinerManzana;
    Spinner spinerEntidad;
    Spinner spinerDomicilioGeografico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_one);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String [] arregloDomicilioGeografico={"--","Carretera","Camino","No"};
        ArrayAdapter adapterDomicilioGeografico = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloDomicilioGeografico);
        spinerDomicilioGeografico=(Spinner)findViewById(R.id.spinnerDomicilioGeografico);
        spinerDomicilioGeografico.setAdapter(adapterDomicilioGeografico);

        List<Municipio> municipios = Municipio.listAll(Municipio.class);

        if(municipios.size()>0) {
            String [] arregloEntidades={"Puebla"};
            spinerEntidad=(Spinner)findViewById(R.id.spinnerEntidad);
            ArrayAdapter adapterE = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloEntidades);
            spinerEntidad.setAdapter(adapterE);
            spinerEntidad.setSelection(0,false);

            String [] arregloMunicipios=new String [municipios.size()];
            int i=0;
            for(Municipio m:municipios){
                arregloMunicipios[i]=m.nombreMunicipio;
                i++;
            }
            ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloMunicipios );
            spinerMunicipio = (Spinner)findViewById(R.id.spinnerMunicipio);
            spinerMunicipio.setAdapter(adapter);

            spinerLocalidad = (Spinner)findViewById(R.id.spinnerLocalidad);
            spinerAgeb = (Spinner)findViewById(R.id.spinnerAgeb);
            spinerManzana=(Spinner)findViewById(R.id.spinnerManzana);
        }

        spinerMunicipio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                String municipioSeleccionado = spinerMunicipio.getSelectedItem().toString();
                List<Municipio> municipios = Municipio.find(Municipio.class,"nombre_municipio=?",municipioSeleccionado);

                for(Municipio m:municipios){
                    List<Localidad> localidades = Localidad.findWithQuery(Localidad.class, "Select * from Localidad where clave_municipio = ?",m.claveMunicipio);
                    String arregloLocalidades[]=new String[localidades.size()];
                    int i=0;
                    for(Localidad l:localidades){
                        arregloLocalidades[i]=l.nombreLocalidad;
                        i++;
                    }
                    ArrayAdapter adapterL = new ArrayAdapter<String>(PageOne.this,android.R.layout.simple_spinner_dropdown_item,arregloLocalidades);
                    spinerLocalidad.setAdapter(adapterL);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        spinerLocalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                String localidadSeleccionado = spinerLocalidad.getSelectedItem().toString();
                List<Localidad> localidades = Localidad.find(Localidad.class,"nombre_localidad=?",localidadSeleccionado);

                for(Localidad l:localidades){
                    List<Ageb> agebes = Ageb.findWithQuery(Ageb.class, "Select * from Ageb where clave_localidad = ?",l.claveLocalidad);
                    String arregloAgebes[]=new String[agebes.size()];
                    int i=0;
                    for(Ageb a:agebes){
                        arregloAgebes[i]=a.claveAgeb;
                        i++;
                    }
                    ArrayAdapter adapterA = new ArrayAdapter<String>(PageOne.this,android.R.layout.simple_spinner_dropdown_item,arregloAgebes);
                    spinerAgeb.setAdapter(adapterA);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

        spinerAgeb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View vies,
                                       int position, long id) {
                String agebSeleccionado = spinerAgeb.getSelectedItem().toString();
                List<Ageb> agebes = Ageb.find(Ageb.class,"clave_ageb=?",agebSeleccionado);

                for(Ageb a:agebes){
                    List<Manzana> manzanas = Manzana.findWithQuery(Manzana.class, "Select * from Manzana where clave_ageb = ?",a.claveAgeb);
                    String arregloManzanas[]=new String[manzanas.size()];
                    int i=0;
                    for(Manzana m:manzanas){
                        arregloManzanas[i]=m.claveManzana;
                        i++;
                    }
                    ArrayAdapter adapterA = new ArrayAdapter<String>(PageOne.this,android.R.layout.simple_spinner_dropdown_item,arregloManzanas);
                    spinerManzana.setAdapter(adapterA);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapter) {

            }
        });

    }

    /** Called when the user clicks the Send button */
    public void irAApartadoTres(View view) {

        String seleccionDomGeo=spinerDomicilioGeografico.getSelectedItem().toString();

        if(seleccionDomGeo.equals("Carretera")){
            Intent intent = new Intent(this, TresAActivity.class);
            startActivity(intent);
        }else if(seleccionDomGeo.equals("Camino")){
            Intent intent = new Intent(this, TresBActivity.class);
            startActivity(intent);
        }else if(seleccionDomGeo.equals("No")){
            Intent intent = new Intent(this, TresCActivity.class);
            startActivity(intent);
        }else if(seleccionDomGeo.equals("--")){
        ///enviamos mensaje para pedir que seleccione el tipo de domicilio geografico
        }

    }
}
