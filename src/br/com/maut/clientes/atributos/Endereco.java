package src.br.com.maut.clientes.atributos;

public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    // Getters e Setters
    
    /* 
    @Override
    public String toString() {
        return "Endereco{" +
        "rua='" + rua + '\'' +
        ", numero='" + numero + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade='" + cidade + '\'' +
        ", estado='" + estado + '\'' +
        ", cep='" + cep + '\'' +
        '}';
    }*/
}
