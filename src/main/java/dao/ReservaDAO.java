package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createReserva(Reserva reserva) {
        try {
            String query = "INSERT INTO reservas (dataReserva, duracaoDias) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new java.sql.Date(reserva.getDataReserva().getTime()));
            preparedStatement.setInt(2, reserva.getDuracaoDias());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reserva> getReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try {
            String query = "SELECT * FROM reservas";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reserva reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("idReserva"));
                reserva.setDataReserva(resultSet.getDate("dataReserva"));
                reserva.setDuracaoDias(resultSet.getInt("duracaoDias"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public Reserva getReservaById(int idReserva) {
        Reserva reserva = null;
        try {
            String query = "SELECT * FROM reservas WHERE idReserva = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReserva);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(resultSet.getInt("idReserva"));
                reserva.setDataReserva(resultSet.getDate("dataReserva"));
                reserva.setDuracaoDias(resultSet.getInt("duracaoDias"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    public void updateReserva(Reserva reserva) {
        try {
            String query = "UPDATE reservas SET dataReserva = ?, duracaoDias = ? WHERE idReserva = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new java.sql.Date(reserva.getDataReserva().getTime()));
            preparedStatement.setInt(2, reserva.getDuracaoDias());
            preparedStatement.setInt(3, reserva.getIdReserva());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReserva(int idReserva) {
        try {
            String query = "DELETE FROM reservas WHERE idReserva = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idReserva);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reserva com ID " + idReserva + " foi excluída com sucesso.");
            } else {
                System.out.println("Nenhuma reserva encontrada com o ID " + idReserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
