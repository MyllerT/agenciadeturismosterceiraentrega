import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ReservaDAO;
import model.Reserva;

@WebServlet("/ReadReservaController")
public class ReadReservaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/destino_com";
            String user = "postgres";
            String password = "123";
            connection = DriverManager.getConnection(url, user, password);

            ReservaDAO reservaDAO = new ReservaDAO(connection);
            List<Reserva> reservas = reservaDAO.getReservas();

            RequestDispatcher rd = req.getRequestDispatcher("reservas.jsp"); // Substitua "reservas.jsp" pelo nome da sua página de exibição de reservas
            rd.forward(req, res);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
