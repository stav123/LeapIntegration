    <%--
      Created by IntelliJ IDEA.
      User: StefanS
      Date: 4/27/15
      Time: 10:51 PM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
    <head>
        <title></title>
    </head>
    <body>

    Hello from products page.<br/>

    <c:forEach var="prod" items="${products}">
        ${prod.price}
        ${prod.id}
        <%--TODO fix the formatting--%>
    </c:forEach>


    </body>
    </html>
