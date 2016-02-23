<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet"/>
        <title>Главная страница</title>
    </head>
    <body>
        <div class="main">
            <a class="button" href='<c:url value="/forecast/list"/>'>Список прогнозов</a>
        </div>
    </body>
</html>
