public class Main {
    public static void main(String[] args) {
        //Contato
        Contato contato1 = new Contato(1,"55998753421","Celular");
        Contato contato2 = new Contato(2,"55456753400","Telefone");

        //Endereço
        Endereco endereco1 = new Endereco(1,"Rua São Valentin",970,"n/a",
                "69093840","Manaus","AM","Brasil");

        Endereco endereco2 = new Endereco(2,"Rua Henri Matisse",412,"n/a",
                "05866040","São Paulo","SP","Brasil");

        //Cliente
        Contato[] arrayContato1 = {contato1};
        Endereco[] arrayEndereco1 = {endereco1};
        Cliente cliente1 = new Cliente("Levi Otávio dos Santos","14576283928",arrayContato1,arrayEndereco1);
        Contato[] arrayContato2 = {contato2};
        Endereco[] arrayEndereco2 = {endereco2};
        Cliente cliente2 = new Cliente("Giovana Valentina","42389174566",arrayContato2,arrayEndereco2);

        //ContaCorrente
        ContaCorrente cc1 = new ContaCorrente(cliente1,"1000","1",0);
        ContaCorrente cc2 = new ContaCorrente(cliente2,"2000","2",0);
        cc1.setChequeEspecial(200);
        cc2.setChequeEspecial(200);
        cc1.depositar(100);
        cc1.sacar(10);
        cc1.transferir(cc2,100);
        cc2.imprimir();
        System.out.println("----------------------");
        cc1.imprimir();
        System.out.println("----------------------");

        //ContaPoupança
        ContaPoupanca cp1 = new ContaPoupanca(cliente1,"1100","1",0.0);
        ContaPoupanca cp2 = new ContaPoupanca(cliente2,"2100","2",0.0);
        cp2.depositar(100);
        cp2.transferir(cp1,10);
        cp1.creditarTaxa();
        cp2.imprimir();
        System.out.println("----------------------");
        cp1.imprimir();
    }
}
