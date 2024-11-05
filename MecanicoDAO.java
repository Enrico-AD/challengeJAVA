package br.com.fiap.dao;

import br.com.fiap.to.MecanicoTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MecanicoDAO {
    private Connection con;

    public MecanicoDAO() {
        this.con = ConnectionFactory.getInstance().getConexao();
    }

    public String save(MecanicoTO mecanico) {
        String sql = "INSERT INTO ddd_mecanico (id_mecanico, nome_mecanico, telefone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mecanico.getIdMecanico());
            ps.setString(2, mecanico.getNomeMecanico());
            ps.setString(3, mecanico.getTelefone());
            ps.setString(4, mecanico.getEmail());
            return ps.executeUpdate() > 0 ? "Inserido com sucesso" : "Erro ao inserir";
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String updateMecanico(MecanicoTO mecanico) {
        String sql = "UPDATE ddd_mecanico SET nome_mecanico = ?, telefone = ?, email = ? WHERE id_mecanico = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mecanico.getNomeMecanico());
            ps.setString(2, mecanico.getTelefone());
            ps.setString(3, mecanico.getEmail());
            ps.setInt(4, mecanico.getIdMecanico());
            return ps.executeUpdate() > 0 ? "Alterado com sucesso" : "Erro ao alterar";
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluirMecanico(MecanicoTO mecanico) {
        String sql = "DELETE FROM ddd_mecanico WHERE id_mecanico = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mecanico.getIdMecanico());
            return ps.executeUpdate() > 0 ? "Excluído com sucesso" : "Erro ao excluir";
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<MecanicoTO> findAll() {
        String sql = "SELECT * FROM ddd_mecanico";
        ArrayList<MecanicoTO> listaMecanicos = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MecanicoTO mecanico = new MecanicoTO();
                mecanico.setIdMecanico(rs.getInt("id_mecanico"));
                mecanico.setNomeMecanico(rs.getString("nome_mecanico"));
                mecanico.setTelefone(rs.getString("telefone"));
                mecanico.setEmail(rs.getString("email"));
                listaMecanicos.add(mecanico);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return listaMecanicos;
    }
}
