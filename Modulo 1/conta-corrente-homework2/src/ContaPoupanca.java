public class ContaPoupanca extends Conta implements Movimentacao {
    public static final double JUROS_MENSAIS = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    public void creditarTaxa(){
        double saldo = getSaldo();
        setSaldo(saldo*JUROS_MENSAIS);
    }
}
