public class Main {
    public static void main(String[] args) {
        //Contato
        Contato contato1 = new Contato(1,"55998753421","Celular");
        Contato contato2 = new Contato(2,"55456753400","Telefone");

        System.out.println("CONTATO:");
        contato1.imprimirContato();
        System.out.println("----------------------------------");
        contato2.imprimirContato();
        System.out.println("----------------------------------");

        //Endereço
        Endereco endereco1 = new Endereco(1,"Rua São Valentin",970,"n/a",
                "69093840","Manaus","AM","Brasil");

        Endereco endereco2 = new Endereco(2,"Rua Henri Matisse",412,"n/a",
                "05866040","São Paulo","SP","Brasil");

        System.out.println("ENDEREÇO:");
        endereco1.imprimirEndereco();
        System.out.println("----------------------------------");
        endereco2.imprimirEndereco();
        System.out.println("----------------------------------");

        //Cliente
        Contato[] arrayContato = {contato1,contato2};
        Endereco[] arrayEndereco = {endereco1,endereco2};
        Cliente cliente1 = new Cliente("Levi Otávio dos Santos","14576283928",arrayContato,arrayEndereco);
        Cliente cliente2 = new Cliente("Giovana Valentina","42389174566",arrayContato,arrayEndereco);

        System.out.println("CLIENTE:");
        cliente1.imprimirCliente();
        cliente2.imprimirCliente();
        System.out.println("----------------------------------");
        cliente2.imprimirContatos();
        System.out.println("----------------------------------");
        cliente2.imprimirEnderecos();
        System.out.println("----------------------------------");

        //ContaCorrente
        ContaCorrente cc1 = new ContaCorrente(cliente1,"1000","1",0);
        ContaCorrente cc2 = new ContaCorrente(cliente2,"2000","2",0);
        cc1.setChequeEspecial(200);
        cc2.setChequeEspecial(200);

        //ContaPoupança
        ContaPoupanca cp1 = new ContaPoupanca(cliente1,"1100","1",0);
        ContaPoupanca cp2 = new ContaPoupanca(cliente2,"2100","2",0);

        cc1.transferir(cp1,80);
        System.out.println(cc1.getSaldo());
        System.out.println(cp1.getSaldo());
        cp2.creditarTaxa();
        System.out.println(cp1.getSaldo());
    }
}
