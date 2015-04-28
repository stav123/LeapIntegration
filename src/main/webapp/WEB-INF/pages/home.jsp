<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<form:form action="addProduct" method="POST" commandName="productModel">
    <table border="0px">
        <tr>
            <td align="center" colspan="2"><h2>Available products</h2></td>
        </tr>
        <tr>
            <td>Product name:</td>
            <td><form:input path="productName"></form:input></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="description"></form:input></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><form:input path="price"></form:input></td>
        </tr>
        <tr>

        </tr>
    </table>
    <input type="submit" value="Submit"/>
</form:form>

</body>


</html>
