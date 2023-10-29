package src.br.com.maut;

import java.time.LocalDate;
import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.clientes.atributos.Endereco;
import src.br.com.maut.contas.ContaCorrente;
import src.br.com.maut.contas.ContaPoupanca;
import src.br.com.maut.notificacao.NotificacaoEmail;
import src.br.com.maut.notificacao.NotificacaoSms;

public class Main {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente(
                new Cliente("Fulano de Tal", "12345678900", LocalDate.of(1985, 10, 15),
                        new Endereco("Rua ABC", 123, "Bairro XYZ", "Cidade", "Estado")),
                new NotificacaoEmail());

        ContaPoupanca contaPoupanca = new ContaPoupanca(
                new Cliente("Fulano de Tal", "12345678900", LocalDate.of(1985, 10, 15),
                        new Endereco("Rua ABC", 123, "Bairro XYZ", "Cidade", "Estado")),
                new NotificacaoSms());

        contaCorrente.deposita(100.0);
        contaCorrente.getSaldo();
        contaCorrente.saca(10.0);
        contaCorrente.transfere(10.0, contaPoupanca);
        contaCorrente.transfere(10.0, contaPoupanca);
        contaCorrente.transfere(10.0, contaPoupanca);
        contaCorrente.transfere(100.0, contaPoupanca);
        contaCorrente.getSaldo(); // calculo do saldo atual aqui está incorreto

        contaPoupanca.getSaldo();
        contaPoupanca.deposita(100.0);
        contaPoupanca.getSaldo();
        contaPoupanca.saca(10);
        contaPoupanca.transfere(10, contaCorrente);
        contaPoupanca.getSaldo();
    }
}
