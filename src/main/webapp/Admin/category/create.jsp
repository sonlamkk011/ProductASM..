<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.productasm.entity.Product" %>
<%@ page import="com.example.productasm.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/Admin/category/Components/header.jsp"/>
<jsp:include page="/Admin/category/Components/sidebar.jsp"/>
<jsp:include page="/Admin/category/Components/navbar.jsp"/>


<body>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    Product product = (Product) request.getAttribute("product");
    if (product == null) {
        product = new Product();
    }
%>
<section class="section" style="margin-left: 400px; margin-top: 100px">
    <div class="row">
        <div class="card">
            <div class="card-body">
                <div class="col-lg-10">
                    <div class="col-md-4">
                        <label for="inputState" class="form-label">Option</label>
                        <select  class="form-select">
                            <option selected>Quan Ao</option>
                            <option selected>Giay Dep</option>
                        </select>
                    </div>
                    <form action="/category/create" method="post">
                        <div class="col-md-6">
                            <label class="col-md-6 col-form-label">Name</label>
                            <div class="col-sm-12">
                                <input type="text" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Price</label>
                            <input type="number" class="form-control" >
                        </div>

                        <div class="col-md-6">
                            <label class="col-md-6 col-form-label">Textarea</label>
                                <textarea class="form-control" style="height: 100px"></textarea>
                            </div>

                        <h5 class="card-title">Details</h5>
                        <div class="quill-editor-default">
                        </div>
                        <div class="col-md-6">
                            <label class="col-md-6 col-form-label">Thumbnails</label>
                                <input class="form-control" type="file" id="formFile">
                        </div>
                        <div class="col-md-2">
                            <label for="inputState" class="form-label">Status</label>
                            <select id="inputState" class="form-select">
                                <option selected>Active</option>
                                <option selected>Deactive</option>
                            </select>
                        </div>
                        <div class="row mb-3" style="margin-top: 30px">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
            <footer id="footer" class="footer">
                <jsp:include page="/Admin/category/Components/footer.jsp"/>
                <jsp:include page="/Admin/category/scrip.jsp"/>
</body>
</html>