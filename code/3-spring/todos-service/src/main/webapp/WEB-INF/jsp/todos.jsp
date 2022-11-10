<%@ page import="com.example.entity.Todo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="	https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body class="container">
<div class="display-1">todos</div>
<hr/>
Welcome : <span class="text text-danger">${user}</span>
<a href="/logout">logout</a>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <form action="/new-todo" method="post">
            <div class="alert alert-info">
                <div class="d-flex justify-content-center align-items-center">
                    <input name="title"/>&nbsp;
                    <button class="btn btn-dark">Submit</button>
                </div>
            </div>
        </form>
        <ul class="list-group">
            <c:forEach var="todo" items="${todos}" varStatus="vs">
            <li class="list-group-item ${todo.completed?'bg-success':''}">
                <div class="d-flex justify-content-around">
                    <div>${vs.index+1}</div>
                    <div>${todo.title}</div>
                    <div>${todo.completed?'completed':'pending'}</div>
                    <div><a href="delete-todo?id=${todo.id}" class="btn btn-sm btn-danger">delete</a></div>
                </div>
            </li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-2"></div>
</div>

</body>
</html>