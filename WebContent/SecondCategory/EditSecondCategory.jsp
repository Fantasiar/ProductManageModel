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
	<script type="text/javascript">
	$(function() {
		$("#sc_name").blur(function() {
			var sc_name=$(this).val();
			if (sc_name=="") {
				$("#checkSc").css("color","red");
				$("#checkSc").html("类名不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$.ajax({
					url:"${pageContext.request.contextPath}/checkFdsServlet?action=addSc",
					async:false,
					type:"POST",
					data:{"sc_name":sc_name},
					success:function(data){
						var isExist=data.isExist;
						var checkInfo="";
						if(isExist){
							//该用户存在
							checkInfo = "该类名已经存在";
							$("#checkSc").css("color","red");
							$("#subtn").attr("disabled",true);
						}else{
							checkInfo = "该类名可以使用"
							$("#checkSc").css("color","green");
							$("#subtn").attr("disabled",false);
						}
						$("#checkSc").html(checkInfo);
					},
					error:function(){
						alert("查询二级类名失败");
					},
					dataType:"json"
				});
			}
			
		});
		
		$("#sc_info").blur(function() {
			var sc_info=$(this).val();
			if(sc_info==""){
				$("#checkScInfo").css("color","red");
				$("#checkScInfo").html("类名描述不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$("#checkScInfo").css("color","green");
				$("#checkScInfo").html("类名描述格式正确");
				$("#subtn").attr("disabled",false);
			}
		});
	});
	
	</script>
</head>
<body>
<jsp:include page="/index.jsp" />
<div class="container" style="margin-top: 80px">
    <div class="row" >
        <div class="col-md-8 " style="background-color: #D1EEEE;border: 1px solid cornflowerblue;border-radius: 8px;height: 500px">
            <form action="${pageContext.request.contextPath}/editSecondCategoryServlet?action=update" class="form-horizon" role="form" method="post">
                <div class="form-group" style="margin-top: 30px">
                    <label style="margin-left: 40px"><h3>请选择所属的一级分类，并输入修改后的二级分类名和描述信息</h3></label>
                	<input type="hidden" value="${sc.sc_id}" name="sc_id">
          
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
                            <input id="sc_name" name="sc_name" maxlength="6" placeholder="请输入二级类名（6个字以内）" type="text" class="form-control" style="width:200px;height: 40px;border-radius: 6px;" value="${sc.sc_name}">
                        	<span id="checkSc" style="float: right;margin-top: -30px;margin-right: -90px"></span>
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <textarea id="sc_info" name="sc_info" maxlength="25" class="form-control" rows="8" style="width:500px;border-radius: 6px;margin-left: 115px">${sc.sc_info}</textarea>
                	<span id="checkScInfo" style="float: right;margin-top: -150px;"></span>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <button id="subtn" type="submit" class="btn btn-default" style="margin-left: 290px;margin-right: 20px">修改</button>
                    <button onclick="history.go(-1)" class="btn btn-default" >返回</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>