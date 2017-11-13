import java.util.ArrayList;

public class producto {
    String nombre;
    int precio;
    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setNombre(String nom)
    {
        this.nombre = nom;
    }
    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    public producto(String nombre,int precio) {
        this.nombre = nombre;
        this.precio= precio;
    }
    public producto() {
    }

}
