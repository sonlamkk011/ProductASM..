<%@ page import="java.util.HashMap"%>
<%@ page import="com.example.productasm.entity.Product"%>
<%@ page import="com.example.productasm.entity.Product"%>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <style>
        .invalid-feedback {
            color: red;
        }
    </style>
</head>
<body>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null) {
        errors = new HashMap<>();
    }
    Product product = (Product) request.getAttribute("product");
    if(product == null) {
        product = new Product();
    }
%>
<form class="form-horizontal"  action="/create" method="post">
    <fieldset>

        <legend>PRODUCTS</legend>

        <div class="form-group">
            <label class="col-md-4 control-label" for="name">Name</label>
            <div class="col-md-4">
                <input id="name" name="name"  class="form-control input-md" value="<%= product.getName() %>" type="text">
                <%
                    if(errors.containsKey("name"))   {
                %>
                <div class="invalid-feedback">
                    <%= errors.get("name")%>
                </div>
                <% } %>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="description">Description</label>
            <div class="col-md-4">
                <input id="description" name="description" value="<%= product.getDescription() %>" class="form-control input-md" type="text">
            </div>
        </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="detail">Detail</label>
            <div class="col-md-4">
                <textarea id="detail" name="detail"  class="form-control input-md">
                    <%= product.getDetail() %>
                </textarea>

            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="price">Price</label>
            <div class="col-md-4">
                <input id="price" name="price" class="form-control"  type="number" value="<%= product.getPrice() %>"/>
                <%
                    if(errors.containsKey("price"))   {
                %>
                <div class="invalid-feedback">
                    <%= errors.get("price")%>
                </div>
                <% } %>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="manufactureEmail"> Manufacture Email</label>
            <div class="col-md-4">
                <input id="manufactureEmail" name="manufactureEmail"  class="form-control input-md" value="<%= product.getManufactureEmail() %>"  type="text">
                <%
                    if(errors.containsKey("manufactureEmail"))   {
                %>
                <div class="invalid-feedback">
                    <%= errors.get("manufactureEmail")%>
                </div>
                <% } %>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="manufactureEmail"> Manufacture Phone</label>
            <div class="col-md-4">
                <input id="manufacturePhone" name="manufacturePhone"  class="form-control input-md" value="<%= product.getManufacturePhone() %>"  type="text">
                <%
                    if(errors.containsKey("manufacturePhone"))   {
                %>
                <div class="invalid-feedback">
                    <%= errors.get("manufacturePhone")%>
                </div>
                <% } %>

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" for="thumbnail"> Thumbnail</label>
            <div class="col-md-4">
                <input id="thumbnail" name="thumbnail" class="form-control input-md" value="<%= product.getThumbnail() %>"  type="text">
                <%
                    if(errors.containsKey("thumbnail"))   {
                %>
                <div class="invalid-feedback">
                    <%= errors.get("thumbnail")%>
                </div>
                <% } %>

            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label" ></label>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary btn-lg">Submit</button>
            </div>
        </div>
        </div>
        </div>
    </fieldset>
</form>
</body>
</html>
