public class Cliente {

    // Nome do cliente
    private String nome;

    // Identificador único do cliente
    private String identificador;

    public Cliente(String nome, String identificador){
        this.nome = nome;
        this.identificador = identificador;
    }

    // Retorna o nome do cliente
    public String getNome(){ return nome; }

    // Retorna o identificador do cliente
    public String getIdentificador(){
        return identificador;
    }

    // Método para mostrar os dados do cliente no ecrã
    public void mostrarCliente(){
        System.out.println("Nome de cliente: " + getNome());
        System.out.println("ID do cliente: " + getIdentificador());
    }
}
