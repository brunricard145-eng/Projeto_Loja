import java.util.Scanner;
import java.util.ArrayList;

public class  Main{

    public static void main(String[] args) {

        // Scanner para ler entradas do utilizador
        Scanner scanner = new Scanner(System.in);

        // Listas para armazenar dados do sistema (produtos, clientes e pedidos)
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        int opcao;

        // Menu principal do sistema (loop até o utilizador sair)
        do{
            System.out.println("\n ====== SISTEMA LOJA ======");
            System.out.println("1-> Criar Produto");
            System.out.println("2-> Criar Cliente");
            System.out.println("3-> Criar Pedido");
            System.out.println("4-> Mostrar Produtos");
            System.out.println("5-> Mostrar Clientes");
            System.out.println("6-> Mostrar Pedidos");
            System.out.println("7-> Remover Produtos");
            System.out.println("8-> Atualizar produto");
            System.out.println("9-> Sair");

            System.out.println("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            // Direciona para a função correspondente à opção escolhida
            switch (opcao){
                case 1:
                    criarProduto(scanner, produtos);
                    break;

                case 2:
                    criarCliente(scanner, clientes);
                    break;

                case 3:
                    criarPedido(scanner, produtos, clientes, pedidos);
                    break;

                case 4:
                    mostrarProdutos(produtos);
                    break;

                case 5:
                    mostrarClientes(clientes);
                    break;

                case 6:
                    mostrarPedidos(pedidos);
                    break;

                case 7:
                    removerProdutos(scanner, produtos);
                    break;

                case 8:
                    atualizarProdutos(scanner, produtos);
                    break;

                case 9:
                    System.out.println("sistema Encerrado!");
                    break;
            }

        }while(opcao != 9); // condição de saída do menu

        scanner.close(); // fecha o Scanner
    }

    // ===================== CRIAR PRODUTO =====================
    public static void criarProduto(Scanner scanner, ArrayList<Produto> produtos){

        boolean continuar =  true;

        while(continuar) {

            //Nome de produto
            System.out.println("Nome do produto: ");
            String nome_produto = scanner.nextLine();

            //Preço de produto
            System.out.println("Preço do produto: ");
            double preco = scanner.nextDouble();

            if (preco < 0) {
                System.out.println("Preco inválido!");
                continue;
            }

            // Quantidade em stock
            System.out.println("Digite a quantidade no stock: ");
            int stock = scanner.nextInt();

            if (stock < 0) {
                System.out.println("Stock inválido!");
                continue;
            }

            // Criar objeto Produto com os dados inseridos
            Produto produto = new Produto(nome_produto, preco, stock);

            // Adicionar produto à lista
            produtos.add(produto);

            System.out.println("Quer adiconar mais um produto?");
            System.out.println("0-> nao");
            System.out.println("1-> sim");
            int resposta = scanner.nextInt();
            scanner.nextLine();

            if (resposta == 0) {
                continuar = false;
            }
            else if (resposta != 1) {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Produto cadastrado!");
    }

    // ===================== CRIAR CLIENTE =====================
    public static void criarCliente(Scanner scanner, ArrayList<Cliente> clientes) {

        boolean continuar = true;

        while(continuar) {

            // Nome do Clinete
            System.out.println("Nome do cliente: ");
            String nome_cliente = scanner.nextLine();

            // ID do Cliente
            System.out.println("ID do cliente: ");
            String id_cliente = scanner.nextLine();

            //Definir objeto Cliente
            Cliente cliente = new Cliente(nome_cliente, id_cliente);

            // Adicionar à lista de clientes
            clientes.add(cliente);

            System.out.println("Quer adiconar mais um cliente?");
            System.out.println("0-> nao");
            System.out.println("1-> sim");
            int resposta = scanner.nextInt();
            scanner.nextLine();

            if (resposta == 0) {
                continuar = false;
            }
            else if (resposta != 1) {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Cliente cadastrado!");
    }

    // ===================== MOSTRAR PRODUTOS =====================
    public static void mostrarProdutos(ArrayList<Produto> produtos){
        // Verifica se não há produtos
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        // Percorre a lista e mostra cada produto
        System.out.println("===== Produtos =====");
        for(Produto p : produtos ){
            p.mostrarProduto();
            System.out.println();
        }
    }

    // ===================== MOSTRAR CLIENTES =====================
    public static void mostrarClientes(ArrayList<Cliente> clientes){
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }

        System.out.println("\n===== Clientes =====");
        for(Cliente c : clientes){
            c.mostrarCliente();
            System.out.println();
        }
    }

    // ===================== MOSTRAR PEDIDOS =====================
    public static void mostrarPedidos(ArrayList<Pedido> pedidos){
        if(pedidos.isEmpty()){
            System.out.println("Nenhum pedido cadastrado!");
            return;
        }

        System.out.println("\n===== PEDIDOS =====");

        // Percorre pedidos e mostra cada um
        for(int i = 0; i < pedidos.size(); i++){
            pedidos.get(i).mostrarPedido();
            System.out.println();
        }
    }

    // ===================== CRIAR PEDIDO =====================
    public static void criarPedido(Scanner scanner, ArrayList<Produto> produtos, ArrayList<Cliente> clientes , ArrayList<Pedido> pedidos){

        // Verifica se existem clientes
        if(clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }

        // Verifica se existem produtos
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        // Lista clientes disponíveis
        System.out.println("\n ===== CLIENTES =====");
        for(int i = 0; i < clientes.size(); i++){
            System.out.println(i + " - " + clientes.get(i).getNome());
        }

        // Escolher cliente
        System.out.println("Escolha o cliente: ");
        int indiceCliente =  scanner.nextInt();

        if(indiceCliente < 0 || indiceCliente >= clientes.size()){
            System.out.println("Cliente inválido!");
            return;
        }

        Cliente clienteEscolhido = clientes.get(indiceCliente);

        // Criar novo pedido para esse cliente
        Pedido pedido = new Pedido(clienteEscolhido);

       boolean continuar = true;

        // Loop para adicionar vários produtos ao pedido
        while(continuar){

            System.out.println("\n ===== PRODUTOS =====");

            for(int i = 0; i < produtos.size(); i++){
                System.out.println(
                        i +  " - "
                        + produtos.get(i).getNome() +
                        "| Stock: " +
                        produtos.get(i).getStock()
                );
            }

            // Escolher produto
            System.out.println("Escolha o produto: ");
            int indiceProduto =  scanner.nextInt();

            // Validação do índice
            if(indiceProduto < 0 || indiceProduto >= produtos.size()){
                System.out.println("Produto inválido!");
                continue;
            }

            Produto produtoEscolhido = produtos.get(indiceProduto);

            // Quantidade do produto
            System.out.println("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if(quantidade <= 0){
                System.out.println("Quantidade inválida!");
                continue;
            }

            // Adiciona produto ao pedido
            pedido.adicionarProduto(produtoEscolhido, quantidade);

            // Funcionalidade para permitir que o cliente adiciona mais produtos
            System.out.println("Deseja adicionar mais produtos?");
            System.out.println("0-> não");
            System.out.println("1-> sim");
            int resposta = scanner.nextInt();
            scanner.nextLine();

            if(resposta == 0){
                continuar = false;
            }

            else if(resposta != 1){
                System.out.println("Opção inválida!");
            }
        }

        // Adiciona pedido à lista
        pedidos.add(pedido);

        System.out.println("\nPedido criado com sucesso!");
    }

    // ===================== REMOVER PRODUTO =====================
    public static void removerProdutos(Scanner scanner, ArrayList<Produto> produtos){

        // Verificar lista vazia
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        // Mostrar Produtos
        for(int i = 0; i < produtos.size(); i++){
            System.out.println(i + " -" + produtos.get(i).getNome());
        }

        // Escolher a índice do produto para remover
        System.out.println("Escolha o índice do produto: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        //Verificar o índice ou validar índice
        if(indice < 0 || indice >= produtos.size()){
            System.out.println("Indice inválido!");
            return;
        }

        // Guardar produto removido
        Produto produtoremovido = produtos.get(indice);

        // Remover produto da lista através do indice
        produtos.remove(indice);

        // Mostrar confirmação
        System.out.println("Produto removido: " + produtoremovido.getNome());
    }

    // ===================== ATUALIZAR PRODUTO =====================
    public static void atualizarProdutos(Scanner scanner, ArrayList<Produto> produtos){

        // Verificar lista de produtos
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto cadastrado!");
            return;
        }

        System.out.println("\n ===== PRODUTOS =====");
        for(int i = 0; i < produtos.size(); i++){
            System.out.println(i + " - " + produtos.get(i).getNome());
        }

        // Escolher produto
        System.out.println("Escolha o produto: ");

        int indice = scanner.nextInt();
        scanner.nextLine();

        if(indice < 0 || indice >= produtos.size()){
            System.out.println("Produto ínvalido!");
            return;
        }

        Produto produto = produtos.get(indice);

        // Menu de atualização
        System.out.println("1-> Atualizar Preço");

        System.out.println("2-> Atualizar Stock");

        System.out.println("3-> Atualizar Preço e Stock");

        System.out.println("Escolha: ");
        int opcaoUpdate = scanner.nextInt();

        switch (opcaoUpdate){
            case 1:
                System.out.println("Novo preço: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine();

                if(novoPreco < 0){
                    System.out.println("Preço inválado!");
                    return;
                }

                produto.setPreco(novoPreco);

                System.out.println("Preço atualizado!");
                break;

            case 2:
                System.out.println("Novo stock: ");

                int novoStock = scanner.nextInt();
                scanner.nextLine();

                if(novoStock < 0){
                    System.out.println("Preço inválado!");
                    return;
                }

                produto.setStock(novoStock);

                System.out.println("Stock atualizado!");
                break;

            case 3:
                System.out.println("Novo preço: ");
                double novoPreco1 = scanner.nextDouble();

                System.out.println("Novo stock: ");
                int novoStock1 = scanner.nextInt();
                scanner.nextLine();

                produto.setPreco(novoPreco1);
                produto.setStock(novoStock1);

                System.out.println("Preço e Stock atualizados!");
                break;

            default:
                System.out.println("Opcão inválida!");
                break;
        }
    }
}
