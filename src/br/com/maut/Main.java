package src.br.com.maut;

import java.time.LocalDate;

import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.clientes.atributos.Endereco;
import src.br.com.maut.contas.Conta;

public class Main {
    public static void main(String[] args) {
        Conta conta = Conta.abrirConta(new Cliente("Fulano de Tal", "12345678900", LocalDate.of(1985, 10, 15), new Endereco("Rua ABC", "123", "Bairro XYZ", "Cidade", "Estado", "12345-678")));
        conta.depositar((double) 100);
        conta.sacar((double) 50);
        conta.transferir((double) 2);
        conta.verSaldo();
        conta.exibeExtrato();
    }
}
