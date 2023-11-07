<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Criar Reserva</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Criar Reserva</h1>
        <form action="CreateReservaController" method="post">
            <div class="form-group">
                <label for="dataReserva">Data de Reserva:</label>
                <input type="date" class="form-control" id="dataReserva" name="dataReserva" required>
            </div>
            <div class="form-group">
                <label for="duracaoDias">Duração em Dias:</label>
                <input type="number" class="form-control" id="duracaoDias" name="duracaoDias" required>
            </div>
            <button type="submit" class="btn btn-primary">Criar Reserva</button>
        </form>
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
