<%--
  Created by IntelliJ IDEA.
  User: yht
  Date: 2021/5/30
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
        <div class="col-sm-4 col-sm-offset-4">
            <a href="${pageContext.request.contextPath}/toExport" class="btn btn-primary">查看数据</a>
        </div>
    </div>

</div>
</body>
</html>
