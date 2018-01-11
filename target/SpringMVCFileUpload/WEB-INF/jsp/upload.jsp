<%--
  Created by IntelliJ IDEA.
  User: Mr.W
  Date: 2018/1/11
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 文件上传必须 method="post" enctype="multipart/form-data" -->
<form action="/mvc/upload/do_upload" method="post" enctype="multipart/form-data">
    <input type="file" name="multipartFile">
    <input type="submit" value="上传">
</form>
</body>
</html>
