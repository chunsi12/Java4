<%@ page contentType="application/json; charset=UTF-8" %>
<%@ page import="data.person.Person" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
//자바 코드 선언
  Person p1 = new Person("김자바", 30,"여");
  Gson g = new Gson();
  String json = g.toJson(p1);
%>
<%= json %>  