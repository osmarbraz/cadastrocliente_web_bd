package dao.cliente;

import java.util.List;
import modelo.Cliente;

/**
 * DAO é um Design Pattern que encapsula e abstrai o acesso aos dados.
 *
 * Operações para acesso aos dados de cliente.
 *
 */
public interface ClienteDAO {

    public boolean save(Cliente cliente);

    public Cliente retrieveByPk(int clienteId);

    public boolean delete(int cienteId);

    public List retrieveAll();
}
