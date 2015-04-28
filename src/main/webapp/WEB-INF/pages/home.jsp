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
    <jsp:include page="bootstrap.jsp"/>
    <jsp:include page="header.jsp"/>
</head>
<body>


<c:if test="${not empty deleted}">
    <c:out value="${deleted}"/>
</c:if>

<div class="container">
    <h2>
        <center>Product Specification</center>
    </h2>

    <c:if test="${param.isAdded eq true}">
        <div class="alert alert-success"><c:out value="Product added successfully"/></div>
    </c:if>

    <form:form class="form-horizontal" role="form" action="addProduct" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="productName">Product Name :</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="productName" name="productName"
                       placeholder="Enter product name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Product Description:</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="description" name="description"
                       placeholder="Enter description">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="price">Product Price:</label>

            <div class="col-sm-10">
                <input type="number" class="form-control" id="price" name="price" placeholder="Enter price">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="description">Product Price:</label>

            <div class="col-sm-10">
                <textarea class="form-control" rows="3" id="description1"></textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Add</button>
            </div>
        </div>
    </form:form>
</div>


</body>


</html>
