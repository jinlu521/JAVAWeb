<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/13
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%--作用： set标签可以往域中保存数据--%>
 <c:set scope="request" var="abc" value="abcvalue"/>
${requestScope.abc}

<hr>
 <c:if test="${12==12}">
     <h1>12等于12</h1>
 </c:if>

<hr>

 <%--
    choose标签开始选择判断
    when标签 表示每一中判断的情况
       test属性表示当前这种情况的值

       注意：1 标签里不能使用html注释，要使用jsp注释
             2  要在otherwise标签里面判断，when 标签的扶标签一定要是choose标签
 --%>

<%
    request.setAttribute("height",178);
%>
<c:choose>
    <c:when test="${requestScope.height>190}">
        <h1>巨人</h1>
    </c:when>
    <c:when test="${requestScope.height>180}">
        <h1>标准身高</h1>
    </c:when>
    <c:otherwise>
        <h2>小矮子</h2>
    </c:otherwise>
</c:choose>

<hr>
<%-- 1 遍历1 到10 ，输出
    begin 属性设置开始的索引
    end 属性设置结束的索引
    var 属性表示循环的变量(也是当前正在遍历到数据)
    for （int i =1 ； i<10；i++）
--%>
<c:forEach begin="1" end="10" var="i">
    ${i}
</c:forEach>
<hr>

<%--
遍历Object数组
for （Object item:arr）
items 表示遍历的数据源  （遍历的集合）
var 表示当前遍历到的数据
--%>
<%
    request.setAttribute("arr",new String[]{"1","2","3"});
%>
<c:forEach items="${requestScope.arr}" var="it">
    ${it}
</c:forEach>
<hr>
<%
    HashMap<String, Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","values2");
    map.put("key3","value3");
    request.setAttribute("m",map);

//    for (Map.Entry<String,Object> entry: map.entrySet()){
//
//    }
%>
<c:forEach items="${requestScope.m}" var="entry">
    ${entry}
</c:forEach>

</body>
</html>
