<%
	Cookie cookie = new Cookie("username","kitty");
	cookie.setPath(request.getContextPath());
	response.addCookie(cookie);
%>