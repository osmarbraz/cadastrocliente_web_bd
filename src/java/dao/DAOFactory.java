package dao;

import dao.cliente.ClienteDAO;
import dao.cliente.ClienteDAOMySQL;

public class DAOFactory {

    public static ClienteDAO getClienteDAO() {
        return new ClienteDAOMySQL();
    }
    
    //Outros dados vão aqui!
}
