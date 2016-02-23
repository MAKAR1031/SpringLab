<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удалить прогноз</title>
    </head>
    <body>
        <form action="<c:url value="/forecast/removeConfirm"/>" method="POST">
            <p>Вы дейстительно хотите удалить прогноз?</p>
            <input type="hidden" name="id" value="${forecast.id}"/>
            <input type="submit" value="Удалить"/>
        </form>
        <a href="<c:url value="/forecast/list"/>">Вернуться</a>
    </body>
</html>
