<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>增加二级分类</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/index.jsp" />
<div class="container" style="margin-top: 80px">
    <div class="row" >
        <div class="col-md-8 " style="background-color: #D1EEEE;border: 1px solid cornflowerblue;border-radius: 8px;height: 500px">
            <form action="${pageContext.request.contextPath}/addSecondCategoryServlet" class="form-horizon" role="form" method="post">
                <div class="form-group" style="margin-top: 30px">
                    <label style="margin-left: 40px"><h3>请选择对应的一级分类，并输入要添加的二级分类名和描述信息</h3></label>
                </div>
                <div class="row">
                    <div class="col-md-4" style="margin-left: 120px">
                        <div class="form-group" style="width: 200px;">
                            <select name="fc_name" class="form-control" style="height:40px;">
                                <c:forEach items="${fcList}" var="fc">
                                	<option>${fc.fc_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4" style="margin-left: 30px">
                        <div class="form-group">
                            <input name="sc_name" type="text" class="form-control" placeholder="6个字以内" style="width:200px;height: 40px;border-radius: 6px;">
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <textarea name="sc_info" class="form-control" rows="8" placeholder="请输入该分类的描述信息(25个字以内)" style="width:500px;border-radius: 6px;margin-left: 115px"></textarea>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <button type="submit" class="btn btn-default" style="margin-left: 320px">添加</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>