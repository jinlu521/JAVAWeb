<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/13
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--以下几种情况为空--%>
<%--1 值为null的时候，为空--%>
<%--2 值为空串的时候，为空--%>
<%--3 值是Object类型数组，长度为零的时候--%>
<%--4 list集合，元素个数为零--%>
<%--5 map集合，元素个数为零--%>

<%-- 值为null的时候，为空--%>
<%
    request.setAttribute("key",null);

    request.setAttribute("key1",new Object[]{0});
%>
<%--empty函数判断这个key是够为空--%>
 ${empty key}
<%--有内容 输出就是false--%>
${empty key1}
<hr>
${12==12?"你好":"你好尼玛"}
</body>
</html>
