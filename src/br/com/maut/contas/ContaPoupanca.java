package src.br.com.maut.contas;

import src.br.com.maut.clientes.Cliente;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(Cliente titular, String tipoDeNotificacao) {
        super(titular, tipoDeNotificacao);
    }

    public void saca (double valor){
        if (this.saldo >= valor) {
            this.saldo -= (valor - valor * 0.05) ;
            System.out.println("\n Saque de " + valor + " realizado.");
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void transfere(Double valor){
        if (this.saldo >= valor) {
            this.saldo -= (valor + valor * 0.1);
            //addextrato(valor, "transferência");
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido ou transfira da sua Conta Corrente");
        }
    }
    
}
