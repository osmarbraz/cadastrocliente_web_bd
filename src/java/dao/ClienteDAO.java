package dao;

import java.util.List;
import modelo.Cliente;

public interface ClienteDAO {

    public boolean save(Cliente cliente);

    public Cliente retrieveByPk(int clienteId);

    public boolean delete(int cienteId);

    public List retrieveAll();
}
