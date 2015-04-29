<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: StefanS
  Date: 4/29/15
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <jsp:include page="bootstrap.jsp"/>
  <jsp:include page="header.jsp"/>
</head>
<body>


<form:form class="form-horizontal" role="form" action="update" method="POST">

  <div class="form-group">
    <label class="control-label col-sm-2" for="id">Product ID :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="id" name="id" value="${product.id}" readonly="readonly">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="productName">Product Name :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="description">Product Description:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="description" name="description" value="${product.description}">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-2" for="price">Product Price:</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="price" name="price" value="${product.price}">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Add</button>
    </div>
  </div>
</form:form>
</body>
</html>
