<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/res/css/style.css"/>" rel="stylesheet"/>
        <title>Error</title>
    </head>
    <body>
        <div class="main">
            <h1>${pageContext.exception.message}</h1>
        </div>
    </body>
</html>
