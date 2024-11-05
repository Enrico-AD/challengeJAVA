package br.com.fiap.bo;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.to.CarroTO;

import java.util.ArrayList;

public class CarroBO {
    private CarroDAO carroDAO;

    // Construtor que inicializa o CarroDAO
    public CarroBO() {
        this.carroDAO = new CarroDAO();
    }

    // Método para buscar todos os carros
    public ArrayList<CarroTO> findAll() {
        return carroDAO.findAll(); // Chama o método findAll do DAO
    }

    // Método para salvar um carro
    public String save(CarroTO carro) { // O parâmetro deve ser do tipo CarroTO
        return carroDAO.save(carro); // Chama o método save do DAO
    }

    // Método para atualizar um carro
    public String updateCarro(CarroTO carro) {
        return carroDAO.updateCarro(carro); // Chama o método updateCarro do DAO
    }

    // Método para excluir um carro
    public String excluirCarro(CarroTO carro) {
        return carroDAO.excluirCarro(carro); // Chama o método excluirCarro do DAO
    }
}
