# Projeto Loja

Este é um projeto desenvolvido em Java que simula o sistema de gestão de uma loja. O objetivo principal é gerir o fluxo de vendas, desde o registo de clientes e produtos até à estruturação e processamento de pedidos completos.

---

## Tecnologias Utilizadas

* **Linguagem:** Java
* **IDE de Desenvolvimento:** IntelliJ IDEA
* **Controlo de Versão:** Git e GitHub Desktop

---

## Estrutura do Projeto

O sistema está organizado na pasta `src/` com as seguintes classes:

* **`Main.java`**: O ponto de entrada da aplicação, responsável por executar o programa e testar o fluxo das operações.
* **`Cliente.java`**: Representa o utilizador que realiza as compras (guardando dados como nome, contacto ou identificação).
* **`Produto.java`**: Define os artigos disponíveis na loja, contendo atributos como o nome do produto, preço unitário e stock.
* **`Pedido.java`**: Consolida a compra, associando um cliente à data da transação e gerindo a lista de itens comprados.
* **`ItemPedido.java`**: Funciona como a linha intermédia do pedido, associando um `Produto` específico à quantidade selecionada e calculando o subtotal.

---

## Funcionalidades Principais

* **Gestão de Clientes e Catálogo:** Permite instanciar novos clientes e produtos estruturados.
* **Composição Modular de Pedidos:** Um pedido é composto por múltiplos itens, garantindo que a lógica de negócio encapsula bem as relações entre objetos.
* **Cálculo Automático:** Estrutura preparada para calcular o valor total de cada item (Preço × Quantidade) e o somatório total do pedido.
---

## Explicação das Classes e Lógica do Sistema

Para estruturar a loja, o sistema utiliza o conceito de **encapsulamento** e **associação entre objetos**. Abaixo está detalhado o funcionamento de cada classe:

### 1. `Produto.java`
* **O que faz:** Representa um artigo disponível para venda no catálogo da loja.
* **Atributos comuns:** Nome, preço unitário e quantidade em stock.
* **Lógica:** Serve como a base de dados do que pode ser comprado. Cada produto é um objeto independente com o seu próprio preço.

### 2. `Cliente.java`
* **O que faz:** Representa a entidade que vai realizar as compras.
* **Atributos comuns:** Nome, e-mail/contacto ou ID do cliente.
* **Lógica:** Permite identificar quem é o comprador associado a um determinado pedido.

### 3. `ItemPedido.java` (A Classe Intermédia)
* **O que faz:** Faz a ponte entre o `Produto` e o `Pedido`. Representa uma linha do carrinho de compras.
* **Atributos comuns:** Um objeto do tipo `Produto` e a `quantidade` escolhida para esse produto específico.
* **Lógica:** Contém o método para calcular o **subtotal do item** (multiplicando o preço unitário do produto pela quantidade selecionada). Desta forma, o pedido não mexe diretamente no preço do produto, mas sim através do item do pedido.

### 4. `Pedido.java` (O Coração da Lógica)
* **O que faz:** Agrupa todas as informações de uma venda.
* **Atributos comuns:** Um objeto `Cliente` (quem compra), a data do pedido e uma **Lista (ou Array) de `ItemPedido`** (os produtos escolhidos).
* **Lógica:** Contém a função principal de negócio: percorrer a lista de itens, somar o subtotal de cada um e calcular o **Valor Total do Pedido**.

### 5. `Main.java` (O Fluxo de Execução)
É nesta classe que a mágica acontece e onde testamos toda a lógica do trabalho através do seguinte fluxo:
1. **Instanciação:** São criados os objetos de teste (ex: dois clientes e três produtos diferentes com preços e stocks definidos).
2. **Abertura do Pedido:** Cria-se um novo `Pedido` associando-o a um dos clientes.
3. **Adição de Itens:** Criam-se instâncias de `ItemPedido` (ex: "2 unidades do Produto X", "1 unidade do Produto Y") e adicionam-se essas linhas ao `Pedido`.
4. **Output/Resultados:** O programa executa os métodos para calcular o total e imprime no terminal o extrato da compra formatado (Nome do cliente, lista de produtos, quantidades, subtotais e o valor final a pagar).

---

## Funcionalidades Demonstradas

* **Composição Modular:** Demonstração prática de como um objeto (`Pedido`) pode conter uma coleção de outros objetos (`ItemPedido`).
* **Cálculo Automático Dinâmico:** O sistema calcula os subtotais e totais em tempo de execução com base nos dados inseridos no `Main`.