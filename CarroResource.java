package br.com.fiap.resource;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType; // Importação correta do MediaType
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/carros")
public class CarroResource {

    private CarroDAO carroDAO = new CarroDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON) // Consome JSON
    public Response saveCarro(CarroTO carro) {
        String result = carroDAO.save(carro);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON) // Consome JSON
    public Response updateCarro(CarroTO carro) {
        String result = carroDAO.updateCarro(carro);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{placa}")
    public Response deleteCarro(@PathParam("placa") String placa) {
        CarroTO carro = new CarroTO();
        carro.setPlaca(placa);
        String result = carroDAO.excluirCarro(carro);
        return Response.ok(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) // Produz JSON
    public Response getAllCarros() {
        ArrayList<CarroTO> listaCarros = carroDAO.findAll();
        return Response.ok(listaCarros).build();
    }
}
