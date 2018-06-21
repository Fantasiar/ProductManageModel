<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>二级类名修改页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/index.jsp" />
<div class="container" style="margin-top: 80px">
    <div class="row" >
        <div class="col-md-8 " style="background-color: #D1EEEE;border: 1px solid cornflowerblue;border-radius: 8px;height: 500px">
            <form action="" class="form-horizon" role="form" method="post">
                <div class="form-group" style="margin-top: 30px">
                    <label style="margin-left: 40px"><h3>请选择所属的一级分类，并输入修改后的二级分类名和描述信息</h3></label>
                </div>
                <div class="row">
                    <div class="col-md-4" style="margin-left: 120px">
                        <div class="form-group" style="width: 200px;">
                            <select name="fc_name" class="form-control" style="height:40px;">
                           <option selected="selected">${sc.getFc().fc_name}</option>   
                               <c:forEach items="${fcList}" var="fc">
                                	   
                                	    <c:if test="${fc.fc_name ne sc.getFc().fc_name}">
                                	    	<option>${fc.fc_name}</option>
                                	    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4" style="margin-left: 30px">
                        <div class="form-group">
                            <input name="sc_name" type="text" class="form-control" style="width:200px;height: 40px;border-radius: 6px;" value="${sc.sc_name}">
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <textarea class="form-control" rows="8" style="width:500px;border-radius: 6px;margin-left: 115px">${sc.sc_info}</textarea>
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