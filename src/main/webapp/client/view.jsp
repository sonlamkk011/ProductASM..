<%@ page import="com.example.productasm.util.ShoppingCartHelper" %>
<%@ page import="com.example.productasm.entity.ShoppingCart" %>
<%@ page import="com.example.productasm.entity.CartItem" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: Diep
  Date: 06/06/2022
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(request);
    ShoppingCart shoppingCart = shoppingCartHelper.getCart();
    Locale loc = new Locale("vi", "VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>

<body>
<h1>view shopping cart</h1>
<ul>
    <%for (CartItem cartItem : shoppingCart.getListItems()) {%>
    <li><%= cartItem.getProductName()%>&nbsp;
    <li><%= nf.format(cartItem.getUnitPrice())%>&nbsp;
    <li><%= cartItem.getQuantity()%>&nbsp;
        <a href=""> REMOVE</a>
        <a href="/shopping/add?productId=<%cartItem.getProductId();%>&quantity=1"> +</a>
        <a href="/shopping/add?productId=<%cartItem.getProductId();%>&quantity=-1"> -</a>
        <a href="/shopping/remove?productId=<%= cartItem.getProductId()%>"></a>
    </li>
    <%}%>
</ul>
<strong>Total Price: <%=nf.format(shoppingCart.getTotalPrice())%>(VND)</strong>

</body>
</html>
