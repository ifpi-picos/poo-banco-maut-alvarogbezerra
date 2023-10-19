package src.br.com.maut.contas;

import java.time.LocalDate;

//Perguntar a Jesiel se devo remover essa classe ou não já que comentei o extrato
public class Transacao {
    LocalDate data;
    double valor;
    String tipo;

    public Transacao(LocalDate data, double valor, String tipo) {
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "data=" + data + ", valor=" + valor + ", tipo=" + tipo;
    };

}
