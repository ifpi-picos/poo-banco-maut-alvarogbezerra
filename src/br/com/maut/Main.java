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
        ContaCorrente contaCorrente = new ContaCorrente(new Cliente("Fulano de Tal", "12345678900", LocalDate.of(1985, 10, 15), new Endereco("Rua ABC", 123, "Bairro XYZ", "Cidade", "Estado")), new NotificacaoEmail());

        ContaPoupanca contaPoupanca = new ContaPoupanca(new Cliente("Fulano de Tal", "12345678900", LocalDate.of(1985, 10, 15), new Endereco("Rua ABC", 123, "Bairro XYZ", "Cidade", "Estado")), new NotificacaoSms());

        contaCorrente.deposita((double) 1000);
        contaCorrente.saca((double) 100);
        contaCorrente.transfere((double) 2000, contaPoupanca); //transferi de propósito para a conta corrente para usar menos linhas de código;

        contaPoupanca.getSaldo();
        contaPoupanca.saca(500);
        contaPoupanca.transfere(500, contaCorrente);//transferi de propósito para a conta corrente para usar menos linhas de código;
    }
}
