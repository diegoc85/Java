import java.util.ArrayList;

class Pedido {
    int numeroPedido;
    String cliente;
    ArrayList<Prato> listaDePratos;
    double total;

    //Construtor
    public Pedido(int numeroPedido, String cliente){
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.listaDePratos = new ArrayList<>(); //inicializa a lista sem nada
        this.total = 0.0;
    }
    public void adicionarPrato(Prato prato){
        listaDePratos.add(prato); //Adicionando o prato na lista
        total = total + prato.preco;
    }
    public void removerPrato(Prato prato){
        if (listaDePratos.remove(prato)){
            total = total - prato.preco;
        }
    }
    public void visualizarPedido(){
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("Cliente: " + cliente);
        for(Prato p: listaDePratos){
            System.out.println("- " + p.nome + " (R$" + p.preco +") - " + p.descricao);
        }
        System.out.println("Total: R$" + total);
    }
}
