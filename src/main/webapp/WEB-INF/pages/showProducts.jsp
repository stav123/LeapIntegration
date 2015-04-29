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

    <script type="text/javascript">
        $(document).ready(function () {
            $(".triggerRemove").click(function (e) {
                e.preventDefault();
                $("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
                $("#modalRemove").modal();
            });
        })

        $(document).ready(function () {
            $(".triggerEdit").click(function (e) {
                e.preventDefault();
                $("#modalRemove").modal();
            });
        })
    </script>
</head>
<body>

<div class="bs-example">
    <!-- Modal HTML -->
    <div id="modalRemove" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confirmation</h4>
                </div>
                <div class="modal-body">
                    <p>Do you really want to remove the product?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <a href="" class="btn btn-danger removeBtn">Delete Product</a>
                </div>
            </div>
        </div>
    </div>
</div>

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
        <td><a class="btn btn-danger triggerRemove" href='<c:url value="/remove/${product.id}"/>'/>Delete</td>
        <td><a href="#myModal" class="btn btn-warning triggerEdit" data-toggle="modal">Edit</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>

</body>
</html>
