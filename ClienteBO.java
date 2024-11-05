package br.com.fiap.bo;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.to.ClienteTO;

import java.util.ArrayList;

public class ClienteBO {

    private ClienteDAO clienteDAO;

    // Construtor que inicializa o ClienteDAO
    public ClienteBO() {
        this.clienteDAO = new ClienteDAO();
    }

    // Método para buscar todos os clientes
    public ArrayList<ClienteTO> findAll() {
        return clienteDAO.findAll(); // Chama o método findAll do DAO
    }

    // Método para salvar um cliente
    public String save(ClienteTO cliente) { // O parâmetro deve ser do tipo ClienteTO
        return clienteDAO.save(cliente); // Chama o método save do DAO
    }

    // Método para atualizar um cliente
    public String updateCliente(ClienteTO cliente) {
        return clienteDAO.updateCliente(cliente); // Chama o método update do DAO
    }

    // Método para excluir um cliente
    public String excluirCliente(ClienteTO cliente) {
        return clienteDAO.excluirCliente(cliente); // Chama o método excluir do DAO
    }
}
