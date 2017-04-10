package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 10/04/2017.
 */

public class Preguntas extends SugarRecord {
    String pregunta;
    String seccion;
    Integer numero;
    public Preguntas(){}
    public Preguntas(String pregunta, String seccion, Integer numero){
        this.pregunta=pregunta;
        this.seccion=seccion;
        this.numero=numero;
    }
}
