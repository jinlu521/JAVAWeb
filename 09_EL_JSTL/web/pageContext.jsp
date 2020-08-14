<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/13
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--request.getScheme()  它可以获取请求的协议
    request.getServerName() 获取请求服务器的ip或域名
    request.getServerPort() 获取请求的服务器端口号
    request.getContextPath() 获取工程路径
    request.getMthod( )      获取请求方法
     request.getRemoteHost()%获取客户端的ip地址

    session.getId()获取会话的id编码
--%>


1. 协议：${pageContext.request.scheme} <br>
2. 服务器 ip：${pageContext.request.serverName}<br>
3. 服务器端口：${pageContext.request.serverPort}<br>
4. 获取工程路径：${pageContext.request.contextPath}<br>
5. 获取请求方法：${pageContext.request.method}<br>
6. 获取客户端 ip 地址：${pageContext.request.remoteHost}<br>

7. 获取会话的 id 编号：${pageContext.session.id}<br>

<%--使用技巧，可以直接设置在域对象中，之后通过键获取--%>

<%
    pageContext.setAttribute("req",request);
%>
${req.method}


</body>
</html>
