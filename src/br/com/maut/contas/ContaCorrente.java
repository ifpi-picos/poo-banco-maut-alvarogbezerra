package src.br.com.maut.contas;

import src.br.com.maut.clientes.Cliente;

public class ContaCorrente extends Conta{
    private double chequeEspecial;
    private int numeroDeTransacoes = 2;//O cliente pode fazer duas transações grátis

    public ContaCorrente(Cliente titular, String tipoDeNotificacao) {
        super(titular, tipoDeNotificacao);
    }

    //Decrementa em 10% caso o numero permitido de transações seja superior a 2 conforme o requisito 9.
    public void cobraTaxa (double valor){
        if (numeroDeTransacoes < 0){
            this.saldo -= valor * 0.1;
        } else {
            this.numeroDeTransacoes -= 1;
        }
    }

    public void transfere(double valor, Conta contaDestino){
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } if (this.saldo < valor) {
            double aux = this.saldo - valor;
            this.chequeEspecial -= aux;
        }
        contaDestino.saldo += valor;
        cobraTaxa (valor);
        //addextrato(valor, "transferência");
        enviaNotificacao("Transferência", valor);
    }

}
