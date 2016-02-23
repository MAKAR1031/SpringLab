<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Добавление прогноза</h1> 
        <form action="<c:url value="${sendURL}"/>" method="POST">
            <c:if test="${forecast.id != null}">
                <input type="hidden" name="id" value="${forecast.id}"/>
            </c:if>
            <table> 
                <tr>
                    <td><label for="temp">Температура</label></td>
                    <td><input id="temp" name="temp" type="text" value="${forecast.temp}"/></td>
                </tr>
                <tr>
                    <td><label for="pressure">Давление</label></td>
                    <td><input id="pressure" name="pressure" type="text" value="${forecast.pressure}"/></td>
                </tr>
                <tr>
                    <td><label for="cityName">Город</label></td>
                    <td><input id="cityName" name="cityName" type="text" value="${forecast.cityName}"/></td>
                </tr>
                <tr>
                    <td><label for="date">Дата</label></td>
                    <td><input id="date" name="date" type="text" value="${forecast.date}"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Добавить"/></td>
                </tr>
            </table>
        </form>
        <a href="<c:url value="/forecast/list"/>">Вернуться</a>
    </body>
</html>
