<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>一级类名修改页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		
	</script>
</head>
<body>
<jsp:include page="/index.jsp" />
<div class="container" style="margin-top: 80px">
    <div class="row" >
        <div class="col-md-8 " style="background-color: #D1EEEE;border: 1px solid cornflowerblue;border-radius: 8px;height: 500px">
            <form action="${pageContext.request.contextPath}/editFirstCategoryServlet?action=update" method="post" class="form-horizon" role="form">
                <div class="form-group" style="margin-top: 30px">
                    <label style="margin-left: 125px"><h3>请在下方文本框中输入新的分类名和描述信息</h3></label>
                	<input type="hidden" value="${fc.fc_id}" name="fc_id">
                </div>
                <div class="form-group" style="margin-top: 25px">
                    <input type="text" name="fc_name" class="form-control" style="width:500px;height: 40px;border-radius: 6px;margin-left: 115px" value="${fc.fc_name}">
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <textarea class="form-control" rows="8" name="fc_info" style="width:500px;border-radius: 6px;margin-left: 115px">${fc.fc_info}</textarea>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <button type="submit" class="btn btn-default" style="margin-left: 290px;margin-right: 20px">修改</button>
                    <button onclick="history.go(-1)" class="btn btn-default" >返回</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>