<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet"/>
        <title>Удалить прогноз</title>
    </head>
    <body>
        <div class="main">
            <h1 class="title">Удалить прогноз</h1>
            <form action="<c:url value="/forecast/removeConfirm"/>" method="POST">
                <p>Вы дейстительно хотите удалить прогноз?</p>
                <input type="hidden" name="id" value="${forecast.id}"/>
                <input type="submit" value="Удалить"/>
            </form>
            <a class="button" href="<c:url value="/forecast/list"/>">Вернуться</a>
        </div>
    </body>
</html>
