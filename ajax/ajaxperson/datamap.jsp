<%@ page contentType="application/json; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
 Map<String, String> map = new HashMap<>();
 
 map.put("NAME", "SCOTT");
 map.put("BIRTH", "24/05/23");
 map.put("PET", "TIGER");
 map.put("JOB", "PROGRAMMER");
 
 Gson gson = new Gson();
 out.print(gson.toJson(map));
 %>