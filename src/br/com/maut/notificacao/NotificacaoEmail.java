package src.br.com.maut.notificacao;

public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviaNotificacao(String operacao, double valor) {
        System.out.println(operacao + " de R$ " + valor + " realizada com sucesso. Comprovante enviado ao e-mail cadastrado.");
    }
}
