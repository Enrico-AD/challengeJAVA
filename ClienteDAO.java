package br.com.fiap.dao;

import br.com.fiap.to.ClienteTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    private Connection con;

    public ClienteDAO() {
        this.con = ConnectionFactory.getInstance().getConexao();
    }

    public String save(ClienteTO cliente) {
        if (cliente == null) {
            return "Cliente não pode ser nulo";
        }

        // Validações dos campos
        if (cliente.getIdCliente() == null || cliente.getNomeCliente() == null || cliente.getPlaca() == null ||
                cliente.getCpf() == null || cliente.getEmail() == null) {
            return "Todos os campos devem estar preenchidos.";
        }

        String sql = "INSERT INTO ddd_cliente (id_cliente, nome_cliente, placa, cpf, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getPlaca());
            ps.setString(4, cliente.getCpf());
            ps.setString(5, cliente.getEmail());
            return ps.executeUpdate() > 0 ? "Inserido com sucesso" : "Erro ao inserir";
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String updateCliente(ClienteTO cliente) {
        if (cliente == null) {
            return "Cliente não pode ser nulo";
        }

        if (cliente.getIdCliente() == null) {
            return "idCliente deve estar preenchido.";
        }

        String sql = "UPDATE ddd_cliente SET nome_cliente = ?, placa = ?, cpf = ?, email = ? WHERE id_cliente = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getPlaca());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEmail());
            ps.setInt(5, cliente.getIdCliente());
            return ps.executeUpdate() > 0 ? "Alterado com sucesso" : "Erro ao alterar";
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluirCliente(ClienteTO cliente) {
        if (cliente == null || cliente.getIdCliente() == null) {
            return "Cliente ou idCliente não pode ser nulo";
        }

        String sql = "DELETE FROM ddd_cliente WHERE id_cliente = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cliente.getIdCliente());
            return ps.executeUpdate() > 0 ? "Excluído com sucesso" : "Erro ao excluir";
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<ClienteTO> findAll() {
        String sql = "SELECT * FROM ddd_cliente ORDER BY placa";
        ArrayList<ClienteTO> listaCliente = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ClienteTO cliente = new ClienteTO();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome_cliente"));
                cliente.setPlaca(rs.getString("placa"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                listaCliente.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return listaCliente;
    }
}
