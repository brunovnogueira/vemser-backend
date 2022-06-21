public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    void imprimirContatos(){
        if (contatos[1] == null){
            System.out.println(contatos[0]);
        }else if (contatos[0] == null){
            System.out.println(contatos[1]);
        }else {
            System.out.println(contatos[0]);
            System.out.println(contatos[1]);
        }
    }
    void imprimirEnderecos(){
        if (enderecos[1] == null){
            System.out.println(enderecos[0]);
        }else if (enderecos[0] == null){
            System.out.println(enderecos[1]);
        }else {
            System.out.println(enderecos[0]);
            System.out.println(enderecos[1]);
        }
    }
    void imprimirCliente(){
        System.out.println("Nome: "+nome);
        System.out.println("CPF: "+cpf);
    }
}
