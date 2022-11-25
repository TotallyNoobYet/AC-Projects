<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 24/11/2022
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="resources/styleView.css" !important>
<script src="https://kit.fontawesome.com/2ba6431f68.js" crossorigin="anonymous"></script>
<body>

<div class="card text-white bg-primary mb-3" style="max-width: 22rem; align-items: center">
    <div class="card-header" style="text-align: center">Customer Details</div>
    <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text"> <i class="fa-solid fa-user" style="padding-right: 1em"></i>Name: ${customer.name}</p>
        <p class="card-text"> <i class="fa-solid fa-envelope" style="padding-right: 0.5em"></i> Email: ${customer.email}</p>
    </div>
</div>
</body>

</html>
