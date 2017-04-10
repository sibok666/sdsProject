package cuestionario.entidades;

import com.orm.SugarRecord;

/**
 * Created by asuarezr on 10/04/2017.
 */

public class Usuario extends SugarRecord{
    String nombre;
    String direccion;
    Integer edad;
    String telefono;
    String contrasenia;
    String usuario;

    public Usuario(){}

    public Usuario(String nombre,String direccion,Integer edad, String telefono,String contrasenia,String usuario){
        this.nombre=nombre;
        this.direccion=direccion;
        this.edad=edad;
        this.telefono=telefono;
        this.contrasenia=contrasenia;
        this.usuario=usuario;
    }
}
