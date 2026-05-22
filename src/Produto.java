public class Produto {

    // Atributos privados da classe Produto
    // private significa que só podem ser acessados dentro da classe
    private String nome;
    private double preco;
    private int stock;

    public Produto(String nome, double preco, int stock){
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public int getStock(){
        return stock;
    }

    // Adiciona quantidade ao stock
    public void adicionarStock(int quantidade){
        if(quantidade > 0){
            // Soma a quantidade ao stock atual
            stock += quantidade;
        }
    }

    // Remove produtos do stock
    public boolean removerStock(int quantidade){
        // Verifica se existe stock suficiente
        if(quantidade <= stock){

            // Remove do stock
            stock -= quantidade;

            // Operação realizada com sucesso
            return true;
        }
        // Falha na remoção
        return false;
    }

    // Calcula o valor total do stock
    public double valorTotalStock(){
       return preco * stock;
    }

    // Atualiza o preço do produto
    public void setPreco(double preco){
        this.preco = preco;
    }

    // Atualiza o stock do produto
    public void setStock(int stock){
        this.stock = stock;
    }

    // Mostra as informações do produto no ecrã
    public void mostrarProduto(){
        System.out.println("Produto: " + nome);
        System.out.println("Preco: " + preco);
        System.out.println("Stock: " + stock);
    }
}
