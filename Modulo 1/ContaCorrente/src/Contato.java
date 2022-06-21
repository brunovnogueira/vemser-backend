public class Contato {
    String descricao;
    String telefone;
    int tipo; //1-residencial, 2-comercial

    void imprimirContato(){
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Telefone "+this.telefone);

        if (this.tipo == 1){
            System.out.println("Tipo: "+this.tipo+" - Residencial");
        } else if (this.tipo == 2){
            System.out.println("Tipo: "+this.tipo+" - Comercial");
        }
    }
    public String toString(){
        return this.descricao+" - "+this.telefone+" - "+this.tipo;
    }
}
