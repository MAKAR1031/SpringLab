<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet"/>
        <title>Просмотр прогноза</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">О прогнозе</h1>
            <p>В городе <b>${forecast.cityName}</b> <b>${forecast.date}</b> 
                ожидается температура <b>${forecast.temp}</b> и давление <b>${forecast.pressure}</b></p>
            <a class="button" href="<c:url value="/forecast/list"/>">Вернуться</a>
        </div>
    </body>
</html>
