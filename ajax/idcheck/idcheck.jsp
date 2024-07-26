<%@ page contentType="text/xml; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String user_id = request.getParameter("user_id");
	//form이 없다면 null
	//form은 있지만 입력하지 않았으면 ""
	
	if (user_id == null) { //nullpointerException 방지
		user_id = "";
	}
	
	// 데이터베이스 연동을 통한 아이디 중복검사 결과를 얻어오는 과정에 대한 가정
	// 검사한 id값이 jquery와 같다면 사용가능
	// 그외 나머지는 사용 불가능
	boolean result = false;
	if (user_id.equals("jquery")) {
		result = true;
	}
%>
<?xml version='1.0' encoding='UTF-8'?>
<id_check>
	<result><%=result%></result>
</id_check>