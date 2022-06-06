<%@ page import="java.util.HashMap"%>
<%@ page import="com.example.productasm.entity.Product" %>
<%@ page import="com.example.productasm.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/Admin/category/Components/header.jsp" />


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

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Form Elements</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Forms</li>
                <li class="breadcrumb-item active">Elements</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Create Product</h5>
                        <form>
                            <div class="row mb-3">
                                <label  class="col-sm-2 col-form-label">Name</label>
                                <div class="col-sm-10">
                                    <input  id="name" name="name" placeholder="NAME" class="form-control input-md" value="<%= product.getName() %>" type="text">
                                    <%
                                        if(errors.containsKey("name"))   {
                                    %>
                                    <div class="invalid-feedback">
                                        <%= errors.get("name")%>
                                    </div>
                                    <% } %>
                                </div>
                                </div>
                            <div class="row mb-3">
                                <label  class="col-sm-2 col-form-label">Description</label>
                                <div class="col-sm-10">
                                    <input type="email" class="form-control" id="description" name="description" placeholder="DESCRIPTION" value="<%= product.getDescription() %>">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label  class="col-sm-2 col-form-label">Detail</label>
                                <div class="col-sm-10">
                                  <textarea id="detail" name="detail" placeholder="DETAILS" class="form-control input-md">
                                         <%= product.getDetail() %>
                                 </textarea>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label"> Price</label>
                                <div class="col-sm-10">
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

                            <div class="row mb-3">
                                <label class="col-sm-2 col-form-label"> Manufacture Email</label>
                                <div class="col-sm-10">
                                    <input id="manufactureEmail" name="manufactureEmail" placeholder="MANUFACTURE EMAIL" class="form-control input-md" value="<%= () %>"  type="text">
                                    <%
                                        if(errors.containsKey("price"))   {
                                    %>
                                    <div class="invalid-feedback">
                                        <%= errors.get("price")%>
                                    </div>
                                    <% } %>
                                </div>
                            </div>

                            <div class="row mb-3">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary">Submit Form</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </section>

</main><!-- End #main -->
</body>

</html>