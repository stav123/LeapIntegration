<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: StefanS
  Date: 4/28/15
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<c:if test="${not empty param.deleted}">
    <div class="alert alert-success">
        <c:out value="Deleted product"></c:out>
    </div>
</c:if>
<table class="table table-striped">
    <th>ID</th>
    <th>Product Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Operation</th>
    <tr>
        <c:forEach items="${products}" var="product">
    <tr>
        <td>${product.id}</td>
        <td>${product.productName}</td>
        <td>${product.description}</td>
        <td>${product.price}</td>
        <td><a class="btn btn-danger" href='<c:url value="/remove/${product.id}"/>'/>Delete</td>
    </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
