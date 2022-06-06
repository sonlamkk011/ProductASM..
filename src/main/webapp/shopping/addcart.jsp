<%--
  Created by IntelliJ IDEA.
  User: Diep
  Date: 06/06/2022
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    String name = (String) session.getAttribute("name");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add cart</title>
</head>
<body>
<h1>hello session</h1>
<strong> hello, <%=name%>/strong>
</body>
</html>
