package cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import cuestionario.sedesol.com.democuestionario.R;
import cuestionario.sedesol.com.democuestionario.cuestionario.sedesol.paginas.hogar.AgregarIntegrante;

public class IdentificacionDelHogarSecond extends AppCompatActivity {
    Spinner spinerIdentificacion;
    Spinner spinerIdentificacionEdad;
    Spinner spinerVivienda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identificacion_del_hogar_second);
        spinerIdentificacion=(Spinner)findViewById(R.id.spinnerIdentificacion);
        String [] arregloIdentificacion={"--","Credencial para votar vigente",
                "Cartilla del Servicio Militar Nacional",
                "Pasaporte vigente",
                "Constancia de identidad, edad y residencia con fotografía expedida por la autoridad municipal (LOCALIDADES DE HASTA 10,000 HABITANTES)",
                "Formas migratorias",
                "Cédula de identidad personal",
                "Credencial del Instituto Nacional de las Personas Adultas Mayores (INAPAM)",
                "Cédula profesional",
                "Ninguno"};
        ArrayAdapter adapterIdentificacion = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloIdentificacion);
        spinerIdentificacion.setAdapter(adapterIdentificacion);

        spinerIdentificacionEdad=(Spinner)findViewById(R.id.spinnerIdentificacionEdad);
        String [] arregloIdentificacionEdad={"--","Clave Única de Registro de Población (CURP)","Acta de nacimiento","Ninguno"};
        ArrayAdapter adapterIdentificacionEdad = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloIdentificacionEdad);
        spinerIdentificacionEdad.setAdapter(adapterIdentificacionEdad);

        spinerVivienda=(Spinner)findViewById(R.id.spinnerVivienda);

        String [] arregloVivienda={"--","Casa independiente","Departamento en edificio/unidad habitacional",
                "Vivienda o cuarto en vecindad",
                "Vivienda o cuarto en la azotea",
                "Anexo a casa",
                "Local no construido para habitación",
                "Vivienda en terreno familiar compartido",
                "Vivienda móvil",
                "Refugio",
                "Vivienda en construcción no habitada",
                "Asilo, orfanato o convento"};
        ArrayAdapter adapterVivienda = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arregloVivienda);
        spinerVivienda.setAdapter(adapterVivienda);

    }

    public void irAAgregarIntegrante2(View view) {
            Intent intent = new Intent(this, AgregarIntegrante.class);
            startActivity(intent);
    }
}
