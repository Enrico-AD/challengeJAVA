package br.com.fiap.to;

public class MecanicoTO {


    private int idMecanico;
    private String nomeMecanico;
    private String telefone;
    private String email;

    public MecanicoTO() {
    }

    // Getters e Setters
    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNomeMecanico() {
        return nomeMecanico;
    }

    public void setNomeMecanico(String nomeMecanico) {
        this.nomeMecanico = nomeMecanico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Mecanico [idMecanico=" + idMecanico + ", nomeMecanico=" + nomeMecanico +
                ", telefone=" + telefone + ", email=" + email + "]";
    }


}
