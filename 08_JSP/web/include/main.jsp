<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/12
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主体信息<br>
<%-- 这就是静态包含
    filt属性指定你要包含的jsp页面的路径
    地址中的第一个斜杠表示为http://ip:port/工程名/ 映射到代码的web目录
包含页脚信息--%>
    <%----%>
    <%--<%@include file="/include/footer.jsp"%>--%>

    <%--动态包含--%>
    <%--page 属性是指定你要包含的jsp页面的路径
        动态包含也可以像静态包含一样，把被包含的内容执行输出到包含位置--%>
<%-- <jsp:include page="/include/footer.jsp">
    <jsp:param  name="username" value ="bbj"/>
    <jsp:param name="password" value="root"></jsp:param>
 </jsp:include>--%>


<%--这就是请求转发的标签
<jsp:forward page=""></jsp:forward> 是请求转发的标签，它的功能是请求转发
page 是设置请求转发的路径
--%>
<jsp:forward page="/a.jsp"></jsp:forward>
</body>
</html>
