package br.com.fiap.resource;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType; // Importação correta do MediaType
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/clientes")
public class ClienteResource {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCliente(ClienteTO cliente) {
        String result = clienteDAO.save(cliente);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCliente(ClienteTO cliente) {
        String result = clienteDAO.updateCliente(cliente);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{idCliente}")
    public Response deleteCliente(@PathParam("idCliente") int idCliente) {
        ClienteTO cliente = new ClienteTO();
        cliente.setIdCliente(idCliente);
        String result = clienteDAO.excluirCliente(cliente);
        return Response.ok(result).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClientes() {
        ArrayList<ClienteTO> listaClientes = clienteDAO.findAll();
        return Response.ok(listaClientes).build();
    }
}
