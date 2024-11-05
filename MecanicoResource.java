package br.com.fiap.resource;

import br.com.fiap.dao.MecanicoDAO;
import br.com.fiap.to.MecanicoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType; // Importação correta do MediaType
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/mecanicos")
public class MecanicoResource {

    private MecanicoDAO mecanicoDAO = new MecanicoDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMecanico(MecanicoTO mecanico) {
        String result = mecanicoDAO.save(mecanico);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMecanico(MecanicoTO mecanico) {
        String result = mecanicoDAO.updateMecanico(mecanico);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{idMecanico}")
    public Response deleteMecanico(@PathParam("idMecanico") int idMecanico) {
        MecanicoTO mecanico = new MecanicoTO();
        mecanico.setIdMecanico(idMecanico);
        String result = mecanicoDAO.excluirMecanico(mecanico);
        return Response.ok(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMecanicos() {
        ArrayList<MecanicoTO> listaMecanicos = mecanicoDAO.findAll();
        return Response.ok(listaMecanicos).build();
    }
}
