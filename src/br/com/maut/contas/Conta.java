package src.br.com.maut.contas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.clientes.atributos.Endereco;

public class Conta {
    private static String agencia = "001";
    private final int conta;
    private double saldo;
    private Cliente titular;
    List<Transacao> extrato;

    private static int proximoNumeroConta = 1; //tirar duvida com Jesiel
    
    public Conta(Cliente titular) {
        this.conta = proximoNumeroConta;
        proximoNumeroConta++;  // duvida aqui também
        this.saldo = 0;
        this.titular = titular;
        this.extrato = new ArrayList<>();
    }

    public static Conta abrirConta(Cliente titular) {
        return new Conta(titular);
    }

    public void depositar(Double valor) {
        this.saldo += valor;
        addextrato(valor, "deposito");
        System.out.println("\n Depósito de " + valor + " realizado.");
    }

    public void sacar(Double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            addextrato(valor*-1, "saque");
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void transferir(Double valor){
        if (this.saldo >= valor) {
            this.saldo -= valor;
            addextrato(valor, "transferência");
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void verSaldo(){
        System.out.println("\n Seu saldo é de R$ " + this.saldo + " .");
    }

    private void addextrato(Double valor, String tipo) {
        Transacao x = new Transacao(LocalDate.now(), valor, tipo);
        this.extrato.add(x);
    }

    public void exibeExtrato(){
        System.out.println("Transações: ");
        this.extrato.forEach(t -> System.out.println(t));
    }
}