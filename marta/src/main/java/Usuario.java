import java.util.Vector;
import java.util.ArrayList;

public class Usuario {


    String nombre;
    String email;
    ArrayList<producto> misproductos;

    public Usuario(String nombre,String email) {
        this.nombre = nombre;
        misproductos = new ArrayList<producto>();
        this.email = email;
    }

    public Usuario()
    {
        misproductos = new ArrayList<producto>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setObjetos(ArrayList<producto> productos) {
        this.misproductos = productos ;
    }
       public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean añadirproducto(producto nuevo)//afegir objecte
    {
        if(nuevo!=null)
        {
            misproductos.add(nuevo);
            return true;
        }
        return false;
    }

    public ArrayList<producto> getProductos() {
        return misproductos;
    }

}
