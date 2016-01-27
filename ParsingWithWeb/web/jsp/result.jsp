<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>XML Parsing with Web</title>
    </head>
    <body>
        <p>${res} </p>
        <c:forEach var="gem" items="${gems}">
            <tr>
                <td>${gem}<br/></td>
            </tr>
        </c:forEach>
        <br/>
        <a href="index.jsp">Back</a>

    </body>
</html>