<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/12
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
</style>
<body>
 <%--在jsp页面中输出九九乘法表--%>
 <table>
    <%for(int i=1;i<=9;i++){ %>
     <tr>
         <%for (int j=1;j<=i;j++){ %>
         <td><%=j+"*"+i+"="+(i*j)%></td>
    <%}%>
     </tr>
    <%}%>
 </table>
</body>
</html>
