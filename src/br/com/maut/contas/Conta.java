package src.br.com.maut.contas;

import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.notificacao.Notificacao;

public abstract class Conta {
    private static int agencia = 001;
    private final int numero;
    protected double saldo;
    //private Cliente titular;
    private Cliente cliente;
    protected Notificacao notificacao;
    private static int proximoNumeroConta = 1;
    
    public Conta(Cliente cliente, Notificacao notificacao) {
        this.numero = proximoNumeroConta;
        proximoNumeroConta++;  
        this.saldo = 0;
        this.cliente = cliente;
        this.notificacao = notificacao;
    }

    public void deposita(Double valor) {
        if (valor >= 0){
            this.saldo += valor;
            notificacao.enviaNotificacao("Depósito", valor);
        } else {
            this.saldo += valor*-1;
            notificacao.enviaNotificacao("Depósito", valor*-1);
        }
    }

    public void saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            notificacao.enviaNotificacao("Saque", valor);
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void transfere(Double valor){}

    public void setTipoDeNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void getSaldo() {
        System.out.println("Seu saldo atual é de: " + this.saldo);
    }
}