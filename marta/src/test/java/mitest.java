import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

public class mitest {
    ProductManagerImpl mimundo;

    @Before
    public void setUp() {
        mimundo.getInstance();
    }

    @After
    public void tearDown() {

        mimundo.getInstance().reiniciarSingleton();
    }

    @Test
    public void testverventas() {
        logger.info("iniciem test");
        Usuario t = new Usuario("marta","martavivesluis@gmail.com");
        Usuario u = new Usuario("anna","anna@gmail.com");
        Usuario v = new Usuario("maria","marialuis@gmail.com");
        producto o = new producto("lampara",20);
        producto p = new producto("ordenador",50);
        producto q =new producto("lapiz",80);
        mimundo.añadirusuario(t);
        mimundo.añadirusuario(u);
        mimundo.añadirusuario(v);
        mimundo.añadirproducto(o);
        mimundo.añadirproducto(p);
        mimundo.añadirproducto(q);
        mimundo.RealizarPedido("marta","lampara",5);
        mimundo.RealizarPedido("anna","lampara",3);
        assertEquals(8, mimundo.numerodeventas());//si aumenta numero de ventas pedido realizado


    }
}
