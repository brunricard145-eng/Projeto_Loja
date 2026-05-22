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