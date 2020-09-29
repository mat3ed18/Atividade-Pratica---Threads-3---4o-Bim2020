package atividade14bim;

public class Deposito extends Thread {

    private Transacao operacao;
    private Conta beneficiario;

    public Deposito(Transacao operacao, Conta beneficiario) {
        this.operacao = operacao;
        this.beneficiario = beneficiario;
        System.out.println("\n\t> DEPÓSITO BANCÁRIO");
        System.out.println("\tTitular: " + this.operacao.getContaTitular().getNomeTitular());
        System.out.println("\tBeneficiário: " + this.beneficiario.getNomeTitular());
        this.start();
    }

    public Transacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Transacao operacao) {
        this.operacao = operacao;
    }

    public Conta getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Conta beneficiario) {
        this.beneficiario = beneficiario;
    }

    public void depositar(double valor, long timestamp) {
        if (this.operacao.transacao(valor, "depósito", timestamp)) {
            if (!this.operacao.getContaTitular().getNomeTitular().equals(this.beneficiario.getNomeTitular())) this.operacao.getContaTitular().setSaldo(this.operacao.getContaTitular().getSaldo() - valor);
            this.beneficiario.setSaldo(this.beneficiario.getSaldo() + valor);
            System.out.println("\tSaldo do Titular: R$ " + this.operacao.getContaTitular().getSaldo());
            System.out.println("\tSaldo do Beneficiário: R$ " + this.beneficiario.getSaldo() + "\n");
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
