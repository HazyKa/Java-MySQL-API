package br.com.michelhazy;

public class Endereco {
    String cidade;
    String estado;
    int cep;

    Endereco(String cidade, String estado, int cep) {
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }

    
}
