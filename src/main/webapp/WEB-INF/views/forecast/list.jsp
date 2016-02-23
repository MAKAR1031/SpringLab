<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Дата</th>
                <th>Температура, градусы</th>
                <th>Давление, мм.р.с.</th>
                <th>Город</th>
                <th colspan="3">Действия</th>
            </tr>
            <c:forEach var="forecast" items="${forecasts}">
                <tr>
                    <td>${forecast.date}</td>
                    <td>${forecast.temp}</td>
                    <td>${forecast.pressure}</td>
                    <td>${forecast.cityName}</td>
                    <td><a href="<c:url value="${forecast.id}"/>">Посмотреть</a></td>
                    <td><a href="<c:url value="${forecast.id}/edit"/>">Редактировать</a></td>
                    <td><a href="<c:url value="${forecast.id}/remove"/>">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="<c:url value="add"/>">Добавить</a>
    </body>
</html>
