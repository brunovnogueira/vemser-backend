//TODO: testar classe
public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial = 200;

    void imprimirContaCorrente(){
        System.out.println("Cliente: "+cliente);
        System.out.println("N° conta: "+numeroConta);
        System.out.println("Agencia: "+agencia);
        System.out.println("Saldo: "+saldo);
        System.out.println("Cheque especial: "+chequeEspecial);
    }

    boolean sacar(double valor){
        boolean status = true;
        if (valor < 0){
            System.out.println("Não é permitido sacar valor negativo.");
            status = false;
        }else if (saldo + chequeEspecial >= valor){
            saldo -= valor;
            status = true;
        }else {
            System.out.println("Você não tem saldo suficiente.");
            status = false;
        }
        return status;
    }

    boolean depositar(double valor){
        boolean status = true;
        if (valor < 0){
            System.out.println("Não é permitido depositar um valor negativo.");
            status = false;
        }else {
            saldo += valor;
            status = true;
        }
        return status;
    }

    double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    boolean transferir(ContaCorrente conta, double valor){
        boolean status = true;
        if(valor < 0){
            System.out.println("Não é permitido transferir um valor negativo.");
            status = false;
        }else {
            conta.saldo =+ valor;
            status = true;
        }
        return status;
    }
}
