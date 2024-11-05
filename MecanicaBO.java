package br.com.fiap.bo;

import br.com.fiap.dao.MecanicoDAO;
import br.com.fiap.to.MecanicoTO;

import java.util.ArrayList;

public class MecanicaBO {

    private MecanicoDAO mecanicoDAO;

    // Construtor que inicializa o MecanicoDAO
    public MecanicaBO() {
        this.mecanicoDAO = new MecanicoDAO();
    }

    // Método para buscar todos os mecânicos
    public ArrayList<MecanicoTO> findAll() {
        return mecanicoDAO.findAll(); // Chama o método findAll do DAO
    }

    // Método para salvar um mecânico
    public String save(MecanicoTO mecanico) { // O parâmetro deve ser do tipo MecanicoTO
        return mecanicoDAO.save(mecanico); // Chama o método save do DAO
    }

    // Método para atualizar um mecânico
    public String updateMecanico(MecanicoTO mecanico) {
        return mecanicoDAO.updateMecanico(mecanico); // Chama o método updateMecanico do DAO
    }

    // Método para excluir um mecânico
    public String excluirMecanico(MecanicoTO mecanico) {
        return mecanicoDAO.excluirMecanico(mecanico); // Chama o método excluirMecanico do DAO
    }
}
