import java.util.ArrayList;

public class Pedido {

    // Cliente associado ao pedido
    private Cliente cliente;

    // Lista de itens do pedido
    private ArrayList<ItemPedido> itens;

    public Pedido(Cliente cliente){
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    // Adiciona um produto ao pedido
    public void adicionarProduto(Produto produto, int quantidade){
        if(produto.getStock() < quantidade){
            System.out.println("Stock insuficiente!");
            return;
        }

        // Guarda o stock antes da remoção
        int stockAntes = produto.getStock();

        // Remove a quantidade comprada do stock
        produto.removerStock(quantidade);

        //Criar item do pedido
        ItemPedido item = new ItemPedido(produto, quantidade);

        // Remove a quantidade comprada do stock
        itens.add(item);

        System.out.println("Produto adicionado ao pedido!");

        // Mostra alteração do stock
        System.out.println("Stock: " +  stockAntes + " -> " + produto.getStock());
    }

    // Calcula o valor total do pedido
    public double calcularTotal(){

        // Variável acumuladora
        double total = 0;

        // Percorre todos os itens do pedido
        for(ItemPedido item : itens){

            // Soma o subtotal de cada item
            total += item.calcularSubTotal();
        }

        // Retorna valor total
        return total;
    }

    // Mostra todas as informações do pedido
    public void mostrarPedido(){
        System.out.println("\n===== PEDIDO =====");

        // Mostra o nome do cliente
        System.out.println("Cliente: " + cliente.getNome());

        // Percorre todos os itens do pedido
        for(ItemPedido item : itens){

            // Mostra:
            // nome do produto
            // quantidade comprada
            // subtotal do item
            System.out.println(item.getProduto().getNome() + "| Quantidade: "
                    + item.getQuantidade()
                    + " | Subtotal: "
                    + item.calcularSubTotal()
            );
        }

        // Mostra o total final do pedido
        System.out.println("TOTAL: " + calcularTotal());
    }
}
