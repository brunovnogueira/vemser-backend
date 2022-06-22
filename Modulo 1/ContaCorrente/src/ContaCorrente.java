public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial = 200;


    public void imprimirContaCorrente(){
        System.out.println("Cliente \n"+cliente);
        System.out.println("N° conta: "+numeroConta);
        System.out.println("Agencia: "+agencia);
        System.out.println("Saldo: "+saldo);
        System.out.println("Cheque especial: "+chequeEspecial);
    }

    public boolean sacar(double valor){

        if (valor < 0){
            System.out.println("Não é permitido sacar valor negativo.");
            return  false;
        }else if (saldo + chequeEspecial >= valor){
            saldo -= valor;
            return true;
        }else {
            System.out.println("Você não tem saldo suficiente.");
            return false;
        }
    }

    public boolean depositar(double valor){
        if (valor <= 0){
            System.out.println("Não é permitido depositar um valor negativo ou zero.");
            return false;
        }else {
            saldo += valor;
            return true;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor){
        if(valor > saldo + chequeEspecial || valor < 0){
            System.out.println("Operação não permitida");
            return false;
        }else {
            this.saldo -= valor;
            conta.saldo += valor;
            return true;
        }
    }
}
