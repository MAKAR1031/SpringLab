<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Просмотр прогноза</title>
    </head>
    <body>
        <p>В городе <b>${forecast.cityName}</b> <b>${forecast.date}</b> 
            ожидается температура <b>${forecast.temp}</b> и давление <b>${forecast.pressure}</b></p>
        <a href="<c:url value="/forecast/list"/>">Вернуться</a>
    </body>
</html>
