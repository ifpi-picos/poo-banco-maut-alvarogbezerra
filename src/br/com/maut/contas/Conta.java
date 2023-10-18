package src.br.com.maut.contas;

import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.clientes.atributos.Endereco;

public class Conta {
    private static String agencia = "001";
    private final int conta;
    private double saldo;
    private Cliente titular;

    private static int proximoNumeroConta = 1; //tirar duvida com Jesiel

    
    public Conta(Cliente titular) {
        this.conta = proximoNumeroConta;
        proximoNumeroConta++;  // duvida aqui também
        this.saldo = 0;
        this.titular = titular;
    }

    public static Conta abrirConta(Cliente titular) {
        return new Conta(titular);
    }

    public void depositar(Double valor) {
        this.saldo += valor;
        System.out.println("\n Depósito de " + valor + " realizado.");
    }

    public void sacar(Double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void transferir(Double valor){
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void verSaldo(){
        System.out.println("\n Seu saldo é de R$ " + this.saldo + " .");
    }
}