<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>共享系统</title>
</head>
<body>
    ${sessionScope.user.userName},欢迎您进入上海大学考试资源共享系统，您当前积分为${sessionScope.user.credits};
</body>
</html>