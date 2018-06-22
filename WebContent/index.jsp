<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
</head>
<body>
<ul>
	<li><a href="${pageContext.request.contextPath}/FirstCategory/AddFirstCategory.jsp">添加一级分类</a></li>
	<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fc">修改/删除一级分类</a></li>
	<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fcPro">查询一级分类下属商品</a></li>
	<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=sc">添加二级分类</a></li>
	<li><a href="${pageContext.request.contextPath}/searchSecondCategoryServlet?action=sc">修改/删除二级分类</a></li>
	<li><a>查询二级分类下属商品</a></li>
	<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=addPro">新商品登记</a></li>
	<li><a>商品查询</a></li>
</ul>
</body>
</html>