package br.com.fiap.to;

public class CarroTO {


    private String placa;
    private String cor;
    private String descricao;


    public CarroTO() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "placa: " + placa + "\n" +
                "cor: " + cor + "\n" +
                "descricao: " + descricao + "\n\n";
    }
}
