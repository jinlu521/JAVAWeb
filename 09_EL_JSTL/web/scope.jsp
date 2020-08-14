<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/13
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--如果四个域对象中含有相同的key--%>
<%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");

%>
<%--如果不指指定，会按照范围的输出由小到大输出--%>
 ${ key } <br>
<%--指定输出域中的对象--%>
${requestScope.key}
</body>
</html>
