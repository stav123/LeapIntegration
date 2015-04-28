<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: StefanS
  Date: 4/27/15
  Time: 10:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach items="${products}" var="product">
  <c:out value="${product.id}"></c:out>
  <c:out value="${product.productName}"></c:out>
  <c:out value="${product.price}"></c:out>
  <c:out value="${product.description}"></c:out>

</c:forEach>
</body>
</html>
