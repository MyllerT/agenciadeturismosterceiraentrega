package model;

import java.util.Date;

public class Reserva {
    private int idReserva;

    private Date dataReserva;

    private int duracaoDias;

    public Reserva() {

    }

    public Reserva(Date dataReserva, int duracaoDias) {

        this.dataReserva = dataReserva;

        this.duracaoDias = duracaoDias;
    }


    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }


    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }


    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public void setDestino(String destinoEscolhido) {
    }

    public void setDataPartida(String dataPartida) {
    }

    public void setNumeroPessoas(int numeroPessoas) {
    }

}

