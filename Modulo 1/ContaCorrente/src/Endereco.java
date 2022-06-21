import org.w3c.dom.ls.LSOutput;

public class Endereco {
    int tipo; //1-Residencial, 2-Comercial
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco() {
        if (this.tipo == 1) {
            System.out.println("Tipo: " + this.tipo + " - Residencial");
        } else if (this.tipo == 2) {
            System.out.println("Tipo: " + this.tipo + " - Comercial");
        }
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Número: " + this.numero);
        System.out.println("Complemento: " + this.complemento);
        System.out.println("CEP: " + this.cep);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Estado: " + this.estado);
        System.out.println("País: " + this.pais);
    }

    public String toString() {
        return this.tipo + " - " + this.logradouro + ", " + this.numero + " - " + this.complemento + "- CEP: " + this.cep + "\n" + this.cidade + " - " + this.estado + " - " + this.pais;
    }

}
