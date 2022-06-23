public class ContaCorrente extends Conta implements Movimentacao{
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        double saldo = getSaldo();
        if (valor > 0 && retornarSaldoComChequeEspecial() >= valor){
            setSaldo(saldo -= valor);
            return true;
        } else {
            System.out.println("Operação não permitida.");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        double saldo = getSaldo();
        if (valor > 0 && valor <= retornarSaldoComChequeEspecial()){
            setSaldo(saldo -= valor);
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial(){
        return super.getSaldo() + chequeEspecial;
    }
}
