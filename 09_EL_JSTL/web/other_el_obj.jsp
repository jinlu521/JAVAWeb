<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/13
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
输出请求 参数username的值<br>
${param.username}<br>
输出请求参数username利用多个参数的方法<br>
${paramValues.username[0]}
<hr>
${header}
<hr>
${initParam}
</body>
</html>
