package atividade14bim;

public class Saque extends Thread {

    private Conta contaTitular;
    private Transacao operacao;

    public Saque(Transacao operacao) {
        this.operacao = operacao;
        this.contaTitular = this.operacao.getContaTitular();
        System.out.println("\n\tSAQUE BANCÁRIO");
        System.out.println("\tTitular: " + this.contaTitular.getNomeTitular());
        this.start();
    }

    public Conta getContaTitular() {
        return contaTitular;
    }

    public void setContaTitular(Conta contaTitular) {
        this.contaTitular = contaTitular;
    }

    public Transacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Transacao operacao) {
        this.operacao = operacao;
    }

    public void sacar(double valor, long timestamp) {
        if (this.operacao.transacao(valor, "saque", timestamp)) {
            this.contaTitular.setSaldo(this.contaTitular.getSaldo() - valor);
            System.out.println("\tSaldo atual: R$ " + this.contaTitular.getSaldo() + "\n");
            this.operacao.sair();
        } else {
            this.operacao.sair();
        }
    }

    @Override
    public void run() {
        try {
            this.sleep(this.operacao.getTempo());
            if (this.operacao.isFim()) {
                interrupt();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
