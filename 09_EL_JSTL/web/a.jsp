<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/12
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","值");
    %>
表达式脚本输出的值是：<%= request.getAttribute("key")%>
EL表达式输出的key的值是：${key}

</body>
</html>
