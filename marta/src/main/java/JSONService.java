import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("/json")
public class JSONService {
    private ProductManagerImpl mundo =  ProductManagerImpl.getInstance();
    public JSONService() { }
    @POST
    @Path("/usuario/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Usuario user) {
       //mundo.crearUsuario(user);
       return Response.status(201).entity("User added!").build();
    }

    @GET
    @Path("/ventas")
    @Produces(MediaType.APPLICATION_JSON)
    public HashMap<String,Integer> ventas(){
        return mundo.numerodeventas();
    }
    @POST
    @Path("/pedido/{nombreusuario}/{nombreproducto}/{cantidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pedido(@PathParam("nombreusuario") String nombreusu,@PathParam("cantidad") int cantidad,@PathParam("nombreproducto") String nombrepro)
    {
    mundo.RealizarPedido(nombreusu,nombrepro,cantidad);
        return Response.status(201).entity("pedido realizado ").build();

    }


}