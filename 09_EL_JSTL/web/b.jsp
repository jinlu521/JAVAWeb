<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //往四个域中都保存了相同的key数据
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","pageContext");
        session.setAttribute("key","session");
        application.setAttribute("key","application");

    %>
    ${ key}

</body>
</html>
