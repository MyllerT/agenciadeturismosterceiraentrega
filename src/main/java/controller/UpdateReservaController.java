package controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.ReservaDAO;
import model.Reserva;

@WebServlet("/UpdateReservaController")
public class UpdateReservaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int idReserva = Integer.parseInt(req.getParameter("idReserva"));

        try {
            // Obtenha uma conexão do pool de conexão
            Context initContext = new InitialContext();
            DataSource dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/seu_pool_de_conexao");
            Connection connection = dataSource.getConnection();

            ReservaDAO reservaDAO = new ReservaDAO(connection);
            Reserva reserva = reservaDAO.getReservaById(idReserva);
            req.setAttribute("reserva", reserva);

            RequestDispatcher rd = req.getRequestDispatcher("atualizarReserva.jsp"); // Substitua "atualizarReserva.jsp" pelo nome da sua página de atualização de reservas
            rd.forward(req, res);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Reserva reserva = new Reserva();
            reserva.setIdReserva(Integer.parseInt(req.getParameter("idReserva")));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataReserva = dateFormat.parse(req.getParameter("dataReserva"));
            reserva.setDataReserva(dataReserva);

            reserva.setDuracaoDias(Integer.parseInt(req.getParameter("duracaoDias")));

            Context initContext = new InitialContext();
            DataSource dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/seu_pool_de_conexao");
            Connection connection = dataSource.getConnection();

            ReservaDAO reservaDAO = new ReservaDAO(connection);
            reservaDAO.updateReserva(reserva);

            connection.close();

            res.sendRedirect("ReadReservaController");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
