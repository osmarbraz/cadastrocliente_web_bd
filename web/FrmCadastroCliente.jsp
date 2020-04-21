<%@page import="dao.DAOFactory"%>
<%@page import="dao.cliente.ClienteDAO"%>
<%@page import="dao.cliente.ClienteDAOMySQL"%>
<%@page import="modelo.Cliente"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
    </head>
    <body>
        <h1>Dados de Cliente</h1>
        <%
            Cliente cliente = null;
            if (request.getParameter("id") != null) {
                //Recupero o DAO
                ClienteDAO clientedao = DAOFactory.getClienteDAO();
                cliente = clientedao.retrieveByPk(Integer.parseInt(request.getParameter("id")));
        %>
        <form name="FrmCadastroCliente" method="post" action="AlterarCliente">	
            <%
            } else { %>                     
            <form name="FrmCadastroCliente" method="post" action="InserirCliente">	
                <% }%>

                <input type=hidden name="id" value="<%=request.getParameter("id")%>">
                Nome: <input type=text name="nome" value="<%=cliente != null ? cliente.getNome() : ""%>"><p>
                    CPF: <input type=text name="cpf" value="<%=cliente != null ? cliente.getCpf() : ""%>"> <p>
                    <input type="reset" value="Limpar">
                <input type="submit" name="Cadastrar" value="Cadastrar"> <p>		
            </form>
            <br>
            <a href='index.jsp'>Voltar ao menu</a>        
    </body>
</html>	
