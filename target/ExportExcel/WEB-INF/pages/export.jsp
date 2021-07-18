<%--
  Created by IntelliJ IDEA.
  User: yht
  Date: 2021/5/30
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
    <script src="js/jquery-3.5.1.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 主题内容 -->
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10 page-main">
            <table class="table table-striped table-bordered text-center" style="margin-top:80px">
                <thead>
                <tr>
                    <th class="text-center">姓名</th>
                    <th class="text-center">地址</th>
                    <th class="text-center">年龄</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userList}" >
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.address}</td>
                        <td>${user.age}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/export">导出数据</a>
            </div>
        </div>

    </div>
</div>
</body>
</html>
