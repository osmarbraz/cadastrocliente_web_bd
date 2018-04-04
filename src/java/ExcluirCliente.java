
import dao.ClienteDAOMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClienteDAO;

public class ExcluirCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExcluirCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExcluirClienteo at " + request.getContextPath() + "</h1>");

            int id = Integer.parseInt(request.getParameter("id"));

            ClienteDAO clientedao = new ClienteDAOMySQL();
            if (clientedao.delete(id)) {
                out.println("<p>Cliente excluído com sucesso!");
            } else {
                out.println("<p>Cliente não excluído!");
            }
            out.println("<br><br><a href=" + request.getContextPath() + "/FrmClienteListar.jsp>Voltar a lista</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
