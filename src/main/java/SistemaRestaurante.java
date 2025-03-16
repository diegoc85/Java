import java.util.ArrayList;
import java.util.Scanner;

public class SistemaRestaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Prato> cardapio = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        int numeroPedido = 1; //Numero de pedidos

        while (true){
            System.out.println("\n== MENU DO RESTAURANTE ==");
            System.out.println("1. Adicionar prato ao cardápio");
            System.out.println("2. Remover prato do cardápio");
            System.out.println("3. Criar novo pedido");
            System.out.println("4. Visualizar pedidos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Nome do prato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do prato: R$ ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descrição do prato: ");
                    String descricao = scanner.nextLine();
                    cardapio.add(new Prato(nome, preco, descricao));
                    System.out.println("Prato adicionado ao cardápio!");
                    System.out.println("Prato: " + nome + ", Preço: " + preco);
                    break;

                case 2:
                    System.out.println("Digite o nome do prato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    boolean removido = cardapio.removeIf(prato -> prato.nome!=null && prato.nome.equalsIgnoreCase(nomeRemover));
                    if(removido){
                        System.out.println("Prato removido do cardápio!");
                    }else{
                        System.out.println("Prato não encontrado no cardápio!");
                    }

                    break;

                case 3:
                    System.out.print("Nome do cliente: ");
                    String cliente = scanner.nextLine();
                    Pedido novoPedido = new Pedido(numeroPedido++, cliente);
                    if(cardapio.isEmpty()){
                        System.out.println(("O cardápio está vazio. Adicione pratos ao cardápio antes de criar um pedido."));
                        break;
                    }
                    System.out.println("==== Cardápio Disponível ====");
                    for (Prato p: cardapio){
                        System.out.println("- " + p.nome + "(R$ " + p.preco + ") - " + p.descricao);
                    }
                    System.out.println("Escolha os pratos pelo nome (digite 'fim' para encerrar):");
                    while (true) {
                        String pratoEscolhido = scanner.nextLine();
                        if (pratoEscolhido.equalsIgnoreCase("fim")) break;

                        boolean pratoEncontrado = false;
                        for (Prato p : cardapio) {
                            if (p.nome.equalsIgnoreCase(pratoEscolhido)) {
                                novoPedido.adicionarPrato(p);
                                pratoEncontrado = true;
                                break;
                            }
                        }
                        if(!pratoEncontrado){
                            System.out.println("Prato não encontrado no cardápio. Tente novamente!");
                        }
                    }
                    pedidos.add(novoPedido);
                    System.out.println("Pedido criado com sucesso!");
                    break;

                case 4:
                    for (Pedido p : pedidos) {
                        p.visualizarPedido();
                        System.out.println("----------------------");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }












}
