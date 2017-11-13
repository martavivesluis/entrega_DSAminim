

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ProductManagerImpl implements Fachada {

    private static final Logger logger = LogManager.getLogger(ProductManagerImpl.class.getName());
    HashMap<String,Usuario> usuarios;
    HashMap<String,producto> productos;


    private static ProductManagerImpl miManager;
    private ProductManagerImpl() {
        this.usuarios = new HashMap<String, Usuario>();
    }

    public static ProductManagerImpl getInstance() {
        if(miManager ==null)
            miManager = new ProductManagerImpl();
        return miManager;
    }
    public boolean añadirusuario(Usuario usuario) {
        if(usuario==null) {
            logger.error("no podem afegir-ho perque està buit");
            return false;
        }
        Usuario t = usuarios.put(usuario.getNombre(),usuario);
        if(t!=null) {
            logger.error("l'usuari ja existeix");
            return false;
        }
        logger.info("usuari afegit");
        return true;
    }
    public boolean añadirproducto(producto miproducto) {
        if(miproducto==null) {
            logger.error("no podem afegir-ho perque està buit");
            return false;
        }
        producto nuevoproducto = productos.put(miproducto.getNombre(),miproducto);
        if(nuevoproducto!=null) {
            logger.error("ja existeix");
            return false;
        }
        logger.info("afegit");
        return true;
    }
    public ArrayList<producto> listarPorPrecio() {
        ArrayList<producto> productosporprecio = new ArrayList<producto>(productos.values());
        Collections.sort(productosporprecio, new Comparator<producto>(){
            public int compare(producto product1, producto product2) {
                Integer idea1 = new Integer(product1.getPrecio());
                Integer idea2 = new Integer(product2.getPrecio());
                return idea1.compareTo(idea2);
            }
        });
        logger.info("retornem llistat ordenat");
        return productosporprecio;}
    public void RealizarPedido(String nombrecliente, String nombreproducto, int cantidad) {
        Usuario misuario = new Usuario();
        producto miproducto = new producto();
        int i = 0;
        if (usuarios.containsKey(nombrecliente)) {
            misuario = usuarios.get(nombrecliente);
            while (i < cantidad) {
                miproducto = productos.get(nombreproducto);
                if (miproducto == null) {
                    logger.error("el producte no existeix");
                    i=cantidad;
                } else {
                    misuario.añadirproducto(miproducto);
                    i++;

                }
            }
        } else {

            logger.info("el usuari no existeix");
        }
    }
    public ArrayList<producto> misPedidos(String nombre)
    {
        if(usuarios.get(nombre)==null) {
            logger.error("este usuario no ha realizado ningun pedido");
            return null;
        }
        for (producto miproducto :usuarios.get(nombre).getProductos()) {
            logger.info("misproductos pedidos son"+miproducto);
        }

        return usuarios.get(nombre).getProductos();
    }
    public HashMap<String,Integer> numerodeventas()
    {
        int contador=0;int numeroventas=0;
        ArrayList<producto> miarray = new ArrayList<producto>();
        HashMap<String,Integer> misventas= new HashMap<String,Integer>(); //nom producte, total ventas
        for (producto miproducto: productos.values())//primer busquem el primer producte
        {
            for(Usuario miusuario : usuarios.values())
            {contador = 0;
                while(contador<miusuario.misproductos.size())
                {
                    if(miusuario.misproductos.get(contador).toString().equals(miproducto.getNombre()))
                    {
                       numeroventas++;
                       contador++;
                       logger.info("aquest usuari ho ha comprat");
                    }
                    else{
                        contador++;
                    }
                }


            }
            misventas.put(miproducto.getNombre(),numeroventas);

        {

        }
        }
          return misventas;
    }
    public void reiniciarSingleton()
    {
        miManager = null;
    }
}
