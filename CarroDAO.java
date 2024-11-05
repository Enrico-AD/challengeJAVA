package br.com.fiap.dao;

import br.com.fiap.to.CarroTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO extends Repository {

    private Connection con;

    public CarroDAO() {
        this.con = ConnectionFactory.getInstance().getConexao(); // Inicializa a conexão corretamente
    }

    public Connection getCon() {
        return con;
    }

    public String save(CarroTO carro) { // Aceita CarroTO diretamente
        String sql = "INSERT INTO ddd_carro (placa, cor, descricao) VALUES (?, ?, ?)";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());

            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir.";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String updateCarro(CarroTO carro) { // Aceita CarroTO diretamente
        String sql = "UPDATE ddd_carro SET cor = ?, descricao = ? WHERE placa = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getCor());
            ps.setString(2, carro.getDescricao());
            ps.setString(3, carro.getPlaca());

            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso.";
            } else {
                return "Erro ao alterar.";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluirCarro(CarroTO carro) {
        String sql = "DELETE FROM ddd_carro WHERE placa = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, carro.getPlaca());

            if (ps.executeUpdate() > 0) {
                return "Excluído com sucesso.";
            } else {
                return "Erro ao excluir.";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<CarroTO> findAll() {
        String sql = "SELECT * FROM ddd_carro";
        ArrayList<CarroTO> listaCarros = new ArrayList<>();

        try (PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) { // Usa try-with-resources para ResultSet
            while (rs.next()) {
                CarroTO carro = new CarroTO();
                carro.setPlaca(rs.getString("placa"));
                carro.setCor(rs.getString("cor"));
                carro.setDescricao(rs.getString("descricao"));
                listaCarros.add(carro);
            }
            return listaCarros;
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }
}
