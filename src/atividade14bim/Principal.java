package atividade14bim;

public class Principal {

    public static void main(String[] args) {
        Conta minhaConta = new Conta("Mateus Pedro", 1000);
        Conta p1 = new Conta("Everte Arima", 1000); // P1
        Conta p2 = new Conta("Jussimar Leal", 1000); // P2
        
        System.out.println("------ #01 DEPÓSITO --------");
        
        Transacao transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito1 = new Deposito(transacao, transacao.getContaTitular());   
        
        deposito1.depositar(500, new DateTime().getTimestamp());
        
        System.out.println("------ #02 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito2 = new Deposito(transacao, p1); // P1
        
        deposito2.depositar(300, new DateTime().getTimestamp());
        
        System.out.println("------ #03 SAQUE --------");
        
        transacao = new Transacao(p2); // P2
        Saque saque1 = new Saque(transacao);
        
        saque1.sacar(500, new DateTime().getTimestamp());
        
        System.out.println("------ #04 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito3 = new Deposito(transacao, p2); // P2
        
        deposito3.depositar(300, new DateTime().getTimestamp());
        
        System.out.println("------ #05 SAQUE --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Saque saque2 = new Saque(transacao);
        
        saque2.sacar(1500, new DateTime().getTimestamp());
        
        System.out.println("------ #06 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito4 = new Deposito(transacao, transacao.getContaTitular());   
        
        deposito4.depositar(300, new DateTime().getTimestamp());
        
        System.out.println("------ #07 SAQUE --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Saque saque3 = new Saque(transacao);
        
        saque3.sacar(500, new DateTime().getTimestamp());
        
        System.out.println("------ #08 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito5 = new Deposito(transacao, transacao.getContaTitular());   
        
        deposito5.depositar(300, new DateTime().getTimestamp());
        
        System.out.println("------ #09 SAQUE --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Saque saque4 = new Saque(transacao);
        
        saque4.sacar(500, new DateTime().getTimestamp());
        
        System.out.println("------ #10 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito6 = new Deposito(transacao, p2);
        
        deposito6.depositar(1300, new DateTime().getTimestamp());
        
        System.out.println("------ #11 SAQUE --------");
        
        transacao = new Transacao(p1); // conta do Jussimar
        Saque saque6 = new Saque(transacao);
        
        saque6.sacar(250, new DateTime().getTimestamp());
        
        System.out.println("------ #12 SAQUE --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Saque saque7 = new Saque(transacao);
        
        saque7.sacar(500, new DateTime().getTimestamp());
        
        System.out.println("------ #13 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito7 = new Deposito(transacao, p1); // conta do Jussimar 
        
        deposito7.depositar(1300, new DateTime().getTimestamp());
        
        System.out.println("------ #14 SAQUE --------");
        
        transacao = new Transacao(p1); // conta do Jussimar
        Saque saque8 = new Saque(transacao);
        
        saque8.sacar(250, new DateTime().getTimestamp());
        
        System.out.println("------ #15 SAQUE --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Saque saque9 = new Saque(transacao);
        
        saque9.sacar(500, new DateTime().getTimestamp());
        
        System.out.println("------ #16 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito8 = new Deposito(transacao, p2); // conta do Evertt 
        
        deposito8.depositar(1300, new DateTime().getTimestamp());
        
        System.out.println("------ #17 SAQUE --------");
        
        transacao = new Transacao(p2); // conta do Evertt
        Saque saque10 = new Saque(transacao);
        
        saque10.sacar(250, new DateTime().getTimestamp());
        
        System.out.println("------ #18 DEPÓSITO --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Deposito deposito10 = new Deposito(transacao, transacao.getContaTitular());   
        
        deposito10.depositar(1300, new DateTime().getTimestamp());
        
        System.out.println("------ #19 SAQUE --------");
        
        transacao = new Transacao(minhaConta); // minha conta
        Saque saque11 = new Saque(transacao);
        
        saque11.sacar(250, new DateTime().getTimestamp());
        
        transacao.sair();
        saque1.interrupt();
        saque2.interrupt();
        saque3.interrupt();
        saque4.interrupt();
        saque6.interrupt();
        saque7.interrupt();
        saque8.interrupt();
        saque9.interrupt();
        saque10.interrupt();
        saque11.interrupt();
        deposito1.interrupt();
        deposito2.interrupt();
        deposito3.interrupt();
        deposito4.interrupt();
        deposito5.interrupt();
        deposito6.interrupt();
        deposito7.interrupt();
        deposito8.interrupt();
        deposito10.interrupt();        
        
        System.out.println(minhaConta.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}



















