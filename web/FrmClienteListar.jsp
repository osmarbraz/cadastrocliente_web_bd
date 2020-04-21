<%@page import="java.util.List"%>
<%@page import="dao.DAOFactory"%>
<%@page import="dao.cliente.ClienteDAO"%>
<%@page import="dao.cliente.ClienteDAOMySQL"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes</title>
    </head>
    <body>
        <h1>Listar Clientes</h1>                        
        <table border="1">    
            <td>Id</td> <td>Nome</td><td>CPF</td><td>Editar</td><td>Excluir</td>
            <% 	//Recupero o DAO
                ClienteDAO clientedao = DAOFactory.getClienteDAO();
                List<Cliente> clientes = clientedao.retrieveAll();
                for (Cliente cliente : clientes) {%>                    			
            <tr>
                <td><%=cliente.getClienteId()%></td>
                <td><%=cliente.getNome()%></td>
                <td><%=cliente.getCpf()%></td>
                <td><a href='FrmCadastroCliente.jsp?id=<%=cliente.getClienteId()%>'>Editar</a> </td>
                <td><a href='ExcluirCliente?id=<%=cliente.getClienteId()%>'>Excluir</a> </td>
            </tr>  
            <% }%>
        </table>
        <br>
        <a href='index.jsp'>Voltar ao menu</a>
    </body>
</html>
