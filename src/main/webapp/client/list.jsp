<%@ page import="java.util.List" %>
<%@ page import="com.example.productasm.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Diep
  Date: 06/06/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Product> products = (List<Product>) request.getAttribute("productList");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>list </h1>
<ul>
    <% for (Product product : products) {%>
    <li><%= product.getName()%>
    </li>
    <a href="/shopping/add?productId=<% product.getId()%>&quantity=1">Add To Cart</a>
    <%}%>
</ul>
</body>
</html>
