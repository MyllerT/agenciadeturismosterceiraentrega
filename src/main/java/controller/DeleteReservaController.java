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

@WebServlet("/DeleteReservaController")
public class DeleteReservaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idReserva = Integer.parseInt(req.getParameter("idReserva"));

        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/destino_com";
            String user = "postgres";
            String password = "123";
            connection = DriverManager.getConnection(url, user, password);

            ReservaDAO reservaDAO = new ReservaDAO(connection);
            reservaDAO.deleteReserva(idReserva);

            res.sendRedirect("ReadReservaController");
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
