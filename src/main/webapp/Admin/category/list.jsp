<%@ page import="com.example.productasm.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/Admin/category/Components/header.jsp"/>
<jsp:include page="/Admin/category/Components/sidebar.jsp"/>
<jsp:include page="/Admin/category/Components/navbar.jsp"/>


<section class="section" style="margin-left: 450px; margin-top: 100px">
    <div class="row">
        <div class="col-lg-10">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Category List</h5>
                    <a href="<%=request.getContextPath()%>/category/create" class="btn btn-primary me-2">Add New</a>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">CreatedAt</th>
                            <th scope="col">UpdatedAt</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Category> categories = (ArrayList<Category>) request.getAttribute("categoryList");
                            for(Category category : categories) {%>

                        <tr>
                            <td><%= category.getId()%></td>
                            <td><%= category.getName() %></td>
                            <td><%= category.getCreatedAt() %></td>
                            <td><%= category.getUpdatedAt() %></td>
                        </tr>
                        <a class="btn btn-primary" href="category/update?id=<%= category.getId() %>">Edit</a>
                        <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal<%= category.getId() %>">Delete</button>
                        <div class="modal fade" id="exampleModal<%= category.getId() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        Are you sure delete <%= category.getName() %>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <a href="/category/delete?id=<%= category.getId() %>" class="btn btn-danger">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </table>
                </div>
            </div>
            <%}%>
        </div>
    </div>

    <jsp:include page="/Admin/category/scrip.jsp"/>

</section>

</html>
