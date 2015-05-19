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
<style>
    .form-control {
        display: block;
        width: 50%;
        height: 34px;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 1.42857143;
        color: #555;
        background-color: #fff;
        background-image: none;
        border: 1px solid #ccc;

</style>
<body>

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
                <input type="text" class="form-control" id="price" name="price" placeholder="Enter price">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Create Product</button>
            </div>
        </div>
    </form:form>
</div>


</body>


</html>