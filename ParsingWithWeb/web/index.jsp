<%--
  Created by IntelliJ IDEA.
  User: maxsel
  Date: 20.01.16
  Time: 2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>XML Parsing with Web</title>
    </head>
    <body>
        <h3>Choose parser:</h3>
        <form name="simple" action="parser_action" method="POST">
            <input type="submit" name="parser" value="DOM"/>
            <input type="submit" name="parser" value="SAX"/>
            <input type="submit" name="parser" value="StAX"/>
        </form>
    </body>
</html>
