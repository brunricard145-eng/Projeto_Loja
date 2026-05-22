public class ItemPedido {
    // Produto associado ao item do pedido
    private Produto produto;

    // Quantidade do produto comprada
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Retorna o produto do item
    public Produto getProduto(){ return produto; }

    // Retorna a quantidade comprada
    public int getQuantidade(){ return quantidade; }

    // Calcula o subtotal do item
    public double calcularSubTotal(){
        return produto.getPreco() * quantidade;
    }
}


