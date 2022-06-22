public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        for (int i = 0;i<2;i++){
            if (contatos[i] != null){
                System.out.println(contatos[i]);
            }
        }
    }
    public void imprimirEnderecos(){
        for (int i=0;i<2;i++){
            if (enderecos[i] != null){
                System.out.println(enderecos[i]);
            }
        }
    }
    public void imprimirCliente(){
        System.out.println("Nome: "+nome);
        System.out.println("CPF: "+cpf);
    }

    public String toString(){
        return "Nome: "+nome+"\nCPF: "+cpf;
    }
}
