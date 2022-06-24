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

        Cliente cliente1 = new Cliente("Levi Otávio dos Santos","14576283928");
        Cliente cliente2 = new Cliente("Giovana Valentina","42389174566");
        cliente1.getContatos().add(contato1);
        cliente1.getEnderecos().add(endereco1);
        cliente2.getContatos().add(contato2);
        cliente2.getEnderecos().add(endereco2);

        //ContaCorrente
        ContaCorrente cc1 = new ContaCorrente(cliente1,"1000","1",0);
        cc1.setChequeEspecial(200);

        //ContaPagamento
        ContaPagamento cPag = new ContaPagamento(cliente1,"3000","4",0);

        //ContaPoupança
        ContaPoupanca cp2 = new ContaPoupanca(cliente2,"2100","2",0.0);

        cc1.depositar(100);
//        cc1.sacar(10);
//        cc1.imprimir();
        cc1.transferir(cPag,20);
//        cc1.imprimir();
//        cPag.imprimir();
        cPag.transferir(cp2,10);
        cPag.imprimir();
        cp2.imprimir();
    }
}
