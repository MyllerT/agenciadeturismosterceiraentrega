<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Reserva</title>
    <!-- Adicione o link para o arquivo CSS do Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Atualizar Reserva</h1>
        <form action="UpdateReservaController" method="post">
            <input type="hidden" name="idReserva" value="${reserva.idReserva}">
            <div class="form-group">
                <label for="dataReserva">Data de Reserva:</label>
                <input type="date" class="form-control" id="dataReserva" name="dataReserva" value="${reserva.dataReserva}" required>
            </div>
            <div class="form-group">
                <label for="duracaoDias">Duração em Dias:</label>
                <input type="number" class="form-control" id="duracaoDias" name="duracaoDias" value="${reserva.duracaoDias}" required>
            </div>
            <button type="submit" class="btn btn-primary">Atualizar Reserva</button>
        </form>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
