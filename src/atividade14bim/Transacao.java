package atividade14bim;

public class Transacao extends Thread {
    private int tempo;
    private boolean valida;
    private Conta contaTitular;
    private boolean fim;

    public Transacao(Conta contaTitular) {
        this.contaTitular = contaTitular;
        this.valida = true;
        this.tempo = 4000;
        this.fim = false;
        this.start();
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public boolean isValida() {
        return valida;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    public Conta getContaTitular() {
        return contaTitular;
    }

    public void setContaTitular(Conta contaTitular) {
        this.contaTitular = contaTitular;
    }

    public boolean isFim() {
        return fim;
    }

    public void setFim(boolean fim) {
        this.fim = fim;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = (int) (tempo * 1000);
    }

    public synchronized void continuar() {
        notify();
    }

    public synchronized void sair() {
        this.fim = true;
        notify();
    }

    public boolean transacao(double valor, String op, long timeStamp) {
        System.out.println("\t\t*** Aguarde... a verificação do saldo está sendo realizada na conta do(a) " + this.contaTitular.getNomeTitular());
        try {
            this.sleep(this.tempo);
        } catch (InterruptedException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        if (op.equals("saque") || op.equals("depósito")) {
            if (valor >= 0 && this.contaTitular.getSaldo() > 0 && this.contaTitular.getSaldo() >= valor) {
                System.out.println("\t\t[" + new DateTime(timeStamp).getCurrentTime() + "] >> OPERAÇÃO REALIZADA COM SUCESSO!");
                return true;
            } else if (this.contaTitular.getSaldo() <= 0) {
                System.out.println("\t\t[" + new DateTime(timeStamp).getCurrentTime() + "] >> SALDO INSUFICENTE! VOCÊ NÃO POSSUI SALDO PARA REALIZAR TRANSAÇÕES BANCÁRIAS");
                System.out.println("\n\t>>> ERRO ENCONTRADO NA OPERAÇÃO REALIZADA POR: \n\n\t" + this.contaTitular.toString() + "\n");
                return false;
            } else if (this.contaTitular.getSaldo() <= valor) {
                System.out.println("\t\t[" + new DateTime(timeStamp).getCurrentTime() + "] >> ERRO! VOCÊ PODERÁ REALIZAR " + op + "S DE ATÉ R$ " + this.contaTitular.getSaldo());
                System.out.println("\n\t>>> ERRO ENCONTRADO NA OPERAÇÃO REALIZADA POR: \n\n\t" + this.contaTitular.toString() + "\n");
                return false;
            } else if (valor <= 0) {
                System.out.println("\t\t[" + new DateTime(timeStamp).getCurrentTime() + "] >> ERRO! NÃO É PERMITIDO FAZER " + op + "S EM BRANCO");
                System.out.println("\n\t>>> ERRO ENCONTRADO NA OPERAÇÃO REALIZADA POR: \n\n\t" + this.contaTitular.toString() + "\n");
                return false;
            } else {
                return false;
            }
        } else {
            System.out.println("OPERAÇÃO INVÁLIDA");
            return false;
        }
    }

    @Override
    public void run() {
        if (fim) {
            interrupt();
        }
    }

}
