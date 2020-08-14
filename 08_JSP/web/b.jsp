<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/11
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%-- 声明类的属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String ,Object> map;
%>
<%--声明静态代码块--%>
<%!
    static {
        map=new HashMap<String, Object>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }
%>
<%--声明类的方法--%>
<%!
    public int abc(){
        return 12;
    }
%>
<%--声明内部类--%>
<%!
    public static class A{
        private Integer id = 12;
        private String abc="abc";
    }
%>

<%--输出整形--%>
<%=12%>
<%--输出浮点型--%>
<%=12.12%>
<%--输出字符串--%>
<%="我是你爸爸"%>
<%--输出对象--%>
<%=map%>

<%--if语句--%>
<%
    int i=12;
    if (i==12){
        System.out.println("悠悠");
    }
%>
<%--for循环语句--%>
<%
    for (int j = 0; j <10 ; j++) {
        System.out.println(j);

    }
%>
<%--翻译后java中文件中_jspService方法内的代码都可以写--%>
<%
    String username = request.getParameter("username");
    System.out.println("username");
%>

</body>
</html>
