<%@ page import="com.jinlu.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: gec
  Date: 2020/8/12
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Person person = new Person();

    person.setName(11);
    person.setPhones(new String []{ "13888081898","15242787397"});
    ArrayList<String> st = new ArrayList<>();
    st.add("锦州");
    st.add("大连");
    person.setCities(st);
    HashMap<String, Object> map= new HashMap<>();
    map.put("key1","varlue1");
    map.put("key2","vlaue2");
    person.setMap(map);

    //随便放到四个域中一个
    request.setAttribute("p",person);

%>
<%-- 大括号中写域中设置的key,即就会出输出对应的value--%>
    输出person:${ p} <br>
    输出person中的name属性：${p.name}<br>
    输出person中的phones数组属性值：${p.phones[0]}<br>
    输出person中的list集合属性值：${p.cities}<br>
    输出person中的list集合属性值中的某一个元素：${p.cities[0]}<br>
    输出person中的Map集合：${p.map}<br>
    输出person中的Map集合中某一个key的值：${p.map.key1}

</body>
</html>
