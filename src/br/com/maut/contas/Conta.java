package src.br.com.maut.contas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.br.com.maut.clientes.Cliente;
import src.br.com.maut.clientes.atributos.Endereco;
import src.br.com.maut.notificacao.Notificacao;

public abstract class Conta implements Notificacao {
    private static int agencia = 001;
    private final int numero;
    protected double saldo; //posso deixar protected mesmo estando diferente do diagrama?
    //private Cliente titular;
    //List<Transacao> extrato;
    private Cliente cliente;
    private String tipoDeNotificacao;
    private static int proximoNumeroConta = 1;
    
    public Conta(Cliente cliente, String tipoDeNotificacao) {
        this.numero = proximoNumeroConta;
        proximoNumeroConta++;  
        this.saldo = 0;
        this.cliente = cliente;
        this.tipoDeNotificacao = tipoDeNotificacao;
        //this.extrato = new ArrayList<>();
    }

    //Deve retornar um boolean
    public void deposita(Double valor) {
        if (valor >= 0){
            this.saldo += valor;
            //addextrato(valor, "deposito");
            enviaNotificacao("Depósito", valor);
        } else {
            this.saldo += valor*-1;
            //addextrato(valor*-1, "deposito");
            enviaNotificacao("Depósito", valor*-1);
        }
    }

    //deve retornar um double
    public void saca(Double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            //addextrato(valor*-1, "saque");
            enviaNotificacao("Saque", valor);
        } else {
            System.out.println("\n Valor superior ao disponível na conta. \nPor favor insira um valor válido.");
        }
    }

    public void transfere(Double valor){}

    @Override
    public void enviaNotificacao(String operacao, double valor) {
        System.out.println(operacao + " de R$ " + valor + " realizada com sucesso. Comprovante enviado ao " + this.tipoDeNotificacao + " cadastrado.");
    }

}

/*    //Métodos relacionados ao atributo extrato que eu apaguei
    private void addextrato(Double valor, String tipo) {
        Transacao x = new Transacao(LocalDate.now(), valor, tipo);
        //this.extrato.add(x);
    }

    public void exibeExtrato(){
        System.out.println("Transações: ");
        //this.extrato.forEach(t -> System.out.println(t));
    } */