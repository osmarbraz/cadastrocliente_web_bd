package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Conexao {
    //Atributos da Classes	

    private String Usuario, Senha, Servidor, DataBase;
    private Connection Con;
    private boolean Conectado;
    private ResultSet Dados;
    private int registros;

    //Construtor da Classe
    public Conexao() {
        setSenha("");
        setUsuario("");
        setServidor("");
        setConectado(false);
        setCon(null);
        setDados(null);
        setDataBase("");
        setRegistros(0);
    }

    public Conexao(String SERV, String DB, String USU, String SENHA) {
        setSenha(SENHA);
        setUsuario(USU);
        setServidor(SERV);
        setDataBase(DB);
        setConectado(false);
        setCon(null);
        setDados(null);
        setRegistros(0);
    }

    //Modificadores
    public void setCon(Connection con) {
        Con = con;
    }

    public void setConectado(boolean conectado) {
        Conectado = conectado;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public void setServidor(String servidor) {
        Servidor = servidor;
    }

    public void setDados(ResultSet dados) {
        Dados = dados;
    }

    public void setDataBase(String DB) {
        DataBase = DB;
    }

    public void setRegistros(int reg) {
        registros = reg;
    }

    //Recuperadores
    public String getUsuario() {
        return Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public boolean getConectado() {
        return Conectado;
    }

    public Connection getCon() {
        return Con;
    }

    public String getServidor() {
        return Servidor;
    }

    public ResultSet getDados() {
        return Dados;
    }

    public String getDataBase() {
        return DataBase;
    }

    public int getRegistros() {
        return registros;
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://" + getServidor() + ":3306" + "/" + getDataBase();
            setCon(DriverManager.getConnection(URL, getUsuario(), getSenha()));
            setConectado(true);
        } catch (ClassNotFoundException e) {
            System.out.println("O Driver JDBC nao foi encontrado!");
            e.printStackTrace();
            setConectado(false);
        } catch (SQLException e) {
            if (e.getMessage().contains("Unknown database")) {
                System.out.println("O DataBase não existe!");
                e.printStackTrace();
                setConectado(false);
            } else {
                if (e.getMessage().contains("Access denied")) {
                    System.out.println("Os dados do usuário login e senha estao incorretos! \nVerifique o arquivo DadosBanco.java");
                    e.printStackTrace();
                } else {
                    if (e.getMessage().contains("Communication")) {
                        System.out.println("O servidor de banco de dados nao esta acessivel. \nVerifique se o banco de dados foi iniciado. \nVerique o endereco e/ou porta do servidor no arquivo DadosBanco.java");
                        e.printStackTrace();
                    } else {
                        System.out.println("Erro na conexao!" + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void fecharConexao() {
        try {
            if (getConectado()) {
                getCon().close();
                setConectado(false);
            }
        } catch (Exception e) {
            System.out.println("Conexão não foi fechada! \n Erro: " + e.getMessage());
        }
    }

    public void expressaoSQL(String Comando) {
        if (getConectado()) {
            try {
                Statement st = getCon().createStatement();
                if (Comando.toUpperCase().indexOf("SELECT") != -1) {
                    setDados(st.executeQuery(Comando));
                } else {
                    setDados(null);
                    setRegistros(st.executeUpdate(Comando));
                    if (Comando.toUpperCase().indexOf("UPDATE") != -1) {
                        System.out.println("Dados Atualizados!");
                    } else if (Comando.toUpperCase().indexOf("DELETE") != -1) {
                        System.out.println("Dados Removidos!");
                    } else if (Comando.toUpperCase().indexOf("INSERT") != -1) {
                        System.out.println("Dados Inseridos!");
                    }

                }
            } catch (SQLException e) {
                System.out.println("SQL Inválido! \n Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
