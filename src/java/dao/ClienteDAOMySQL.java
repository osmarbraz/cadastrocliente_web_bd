package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 * Implementação em MySQL para a interface ClientaDAO.
 *
 */
public class ClienteDAOMySQL implements ClienteDAO {

    /**
     * Realiza a inserção ou atualização dos dados de cliente.
     *
     * @param cliente Um objeto cliente a ser inserido ou atualizado.
     *
     * @return Verdadeiro ou falso se conseguiu fazer o salvamento.
     */
    @Override
    public boolean save(Cliente cliente) {
        boolean resultado = false;
        //Instancia a conexão com o banco de dados
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        //Abre a conexão
        MinhaConexao.conectar();
        //Recupera a conexão com o banco
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = null;
            //Verifica se é para realizar uma atualizaçào ou inserção.
            if (cliente.getClienteId() != -1) {
                sql = "update cliente set NOME = ?, CPF = ? where CLIENTEID = ?";
            } else {
                sql = "insert into cliente (NOME, CPF)  values  (?,?)";
            }
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            if (cliente.getClienteId() != -1) {
                pstmt.setInt(3, cliente.getClienteId());
            }

            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    /**
     * Recupera todos os objetos do banco de dados.
     *
     * @return Uma lista com todos os objetos cliente do banco de dados.
     */
    @Override
    public List retrieveAll() {
        Cliente cliente = null;
        //Instancia a conexão com o banco de dados
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        //Abre a conexão
        MinhaConexao.conectar();
        //Recupera a conexão com o banco
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        try {
            String sql = "select * from cliente";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getInt("clienteId"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lista;
    }

    /**
     * Exclui um registro de cliente do banco de dados.
     *
     * @param clienteId Id do cliente a ser excluído.
     * @return Verdadeiro ou falso se conseguiu fazer a exclusão.
     */
    @Override
    public boolean delete(int clienteId) {
        boolean resultado = false;
        //Instancia a conexão com o banco de dados
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        //Abre a conexão
        MinhaConexao.conectar();
        //Recupera a conexão com o banco
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from cliente where clienteId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clienteId);
            pstmt.executeUpdate();
            resultado = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    /**
     * Recupera um objeto cliente do banco de dados apartir do seu Id.
     *
     * @param clienteId Id do cliente a ser recuperado.
     *
     * @return Um objeto cliente do banco de dados ou null se não encontrar o
     * cliente.
     */
    @Override
    public Cliente retrieveByPk(int clienteId) {
        //Objeto a ser retornado
        Cliente cliente = null;
        //Instancia a conexão com o banco de dados
        Conexao MinhaConexao = new Conexao(DadosBanco.SERVIDOR, DadosBanco.DATABASE, DadosBanco.USUARIO, DadosBanco.SENHA);
        //Abre a conexão
        MinhaConexao.conectar();
        //Recupera a conexão com o banco
        Connection conn = MinhaConexao.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from cliente where clienteId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clienteId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setClienteId(rs.getString("clienteId"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return cliente;
    }
}
