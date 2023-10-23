package src.br.com.maut.contas;

import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.notificacao.Notificacao;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(Cliente titular, Notificacao notificacao) {
        super(titular, notificacao);
    }

    @Override
    public void deposita(Double valor) {
        if (valor >= 0){
            this.saldo += valor * 1.1;
            notificacao.enviaNotificacao("Depósito", valor);
        } else {
            this.saldo += (valor*-1) * 1.1;
            notificacao.enviaNotificacao("Depósito", valor*-1);
        }
    }

    @Override
    public void saca (double valor){
        if (this.saldo >= valor) {
            this.saldo -= (valor - valor * 0.05) ;
            System.out.println("\n Saque de " + valor + " realizado.");
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void transfere(double valor, Conta contaDestino){
        if (this.saldo >= valor) {
            this.saldo -= (valor + valor * 0.1);
            this.notificacao.enviaNotificacao("Transferência", valor);
            contaDestino.saldo += valor;
            getSaldo();
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido ou transfira da sua Conta Corrente");
        }
    }
    
}
