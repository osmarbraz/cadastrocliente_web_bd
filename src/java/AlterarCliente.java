
import dao.DAOFactory;
import modelo.Cliente;
import dao.cliente.ClienteDAOMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.cliente.ClienteDAO;

public class AlterarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlterarCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarCliente at " + request.getContextPath() + "</h1>");

            Cliente cliente = new Cliente();
            cliente.setClienteId(request.getParameter("id"));
            cliente.setNome(request.getParameter("nome"));
            cliente.setCpf(request.getParameter("cpf"));
            //Recupero o DAO
            ClienteDAO clientedao = DAOFactory.getClienteDAO();
            //Verifica se o cliente foi salvo
            if (clientedao.save(cliente)) {
                out.println("<p> Cliente alterado com sucesso!");
            } else {
                out.println("<p> Cliente não alterado!");
            }
            //Adiciona o link para retorno a listagem
            out.println("<br><br><a href=" + request.getContextPath() + "/FrmClienteListar.jsp>Voltar a lista</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
