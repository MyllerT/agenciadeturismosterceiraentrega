package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ReservaDAO;
import model.Reserva;

@WebServlet("/CreateReservaController")
public class CreateReservaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/destino_com";
            String user = "postegres";
            String password = "123";
            connection = DriverManager.getConnection(url, user, password);

            Reserva reserva = new Reserva();


            ReservaDAO reservaDAO = new ReservaDAO(connection);
            reservaDAO.createReserva(reserva);

            res.sendRedirect("ReadReservaController");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
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
