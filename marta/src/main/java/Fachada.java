import java.util.Collection;
import java.util.ArrayList;
import java.util.Vector;

public interface Fachada {
    public ArrayList<producto> listarPorPrecio();
    public void RealizarPedido(String nombrecliente, String nombreproducto, int cantidad);//anirem reben producte/cantitat
    public  ArrayList<producto> misPedidos(String nombre);
}
