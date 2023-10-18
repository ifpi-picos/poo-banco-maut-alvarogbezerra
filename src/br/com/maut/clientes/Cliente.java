package src.br.com.maut.clientes;
import java.time.LocalDate;
import java.util.ArrayList;

import src.br.com.maut.clientes.atributos.Endereco;

public class Cliente {
    private String nome;
    private final String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;
    
    public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }
    
}
