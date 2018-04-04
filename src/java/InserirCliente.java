
import modelo.Cliente;
import dao.ClienteDAOMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDAO;

public class InserirCliente extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InserirCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InserirCliente at " + request.getContextPath() + "</h1>");
            Cliente cliente = new Cliente();
            cliente.setNome(request.getParameter("nome"));
            cliente.setCpf(request.getParameter("cpf"));
            ClienteDAO clientedao = new ClienteDAOMySQL();
            if (clientedao.save(cliente)) {
                out.println("<p> Cliente inserido com sucesso!");
            } else {
                out.println("<p> Cliente não inserido!");
            }
            out.println("<br><br><a href=" + request.getContextPath() + "/index.jsp>Voltar ao menu</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
