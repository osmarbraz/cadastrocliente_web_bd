package modelo;

/**
 * Classe que representa a abstração principal do sistema.
 *
 */
public class Cliente {

    /**
     * Serve para identificar um cliente.
     */
    private int clienteId;
    /**
     * Nome do Cliente.
     */
    private String nome;
    /**
     * CPF do cliente
     */
    private String cpf;

    /**
     * Construtor sem argumentos da classe.
     */
    public Cliente() {
        this(-1, "", "");
    }

    /**
     * Construtor com argumentos da classe.
     *
     * @param clienteId Um id de cliente.
     * @param nome Um nome de cliente.
     * @param cpf Um cpf de cliente.
     */
    public Cliente(int clienteId, String nome, String cpf) {
        setClienteId(clienteId);
        setNome(nome);
        setCpf(cpf);
    }

    /**
     * Retorna o id de um cliente.
     *
     * @return Um inteido com o id do cliente.
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Modifica o id de um cliente.
     *
     * @param clienteId Um inteiro com o id de um cliente.
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Modifica o id de um cliente.
     *
     * @param clienteId Um literal com o id de um cliente.
     */
    public void setClienteId(String clienteId) {
        this.setClienteId(Integer.parseInt(clienteId));
    }

    /**
     * Retorna o nome de um cliente.
     *
     * @return Uma string com o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome de um cliente.
     *
     * @param nome Um literal com o nome de um cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o cpf de um cliente.
     *
     * @return Uma string com o cpf.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Modifica o CPF de um cliente.
     *
     * @param cpf Um literal com o cpf de um cliente.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna uma string com o estado do objeto.
     *
     * @return Uma string com os dados de cliente concatenados.
     */
    public String paraString() {
        return ("clienteId:" + getClienteId() + " - Nome :" + getNome() + " - CPF :" + getCpf());
    }
}
