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
	$(function() {
		
		$("#fc_name").blur(function() {
			var fc_name=$(this).val();
			if(fc_name==""){
				$("#checkFc").css("color","red");
				$("#checkFc").html("类名不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$.ajax({
					url:"${pageContext.request.contextPath}/checkFdsServlet?action=addFc",
					async:false,
					type:"POST",
					data:{"fc_name":fc_name},
					success:function(data){
						var isExist=data.isExist;
						var checkInfo="";
						if(isExist){
							//该用户存在
							checkInfo = "该类名已经存在";
							$("#checkFc").css("color","red");
							$("#subtn").attr("disabled",true);
						}else{
							checkInfo = "该类名可以使用"
							$("#checkFc").css("color","green");
							$("#subtn").attr("disabled",false);
						}
						$("#checkFc").html(checkInfo);
					},
					error:function(){
						alert("查询一级类名失败");
					},
					dataType:"json"
				});
			}
			
		});
		
		$("#fc_info").blur(function() {
			var fc_info=$(this).val();
			if(fc_info==""){
				$("#checkFcInfo").css("color","red");
				$("#checkFcInfo").html("类名描述不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$("#checkFcInfo").css("color","green");
				$("#checkFcInfo").html("类名描述格式正确");
				$("#subtn").attr("disabled",false);
			}
		});
		
	});
	
	</script>
</head>
<body>
<div class="row">
            
          
          <div style="background-color: #BFEFFF;border: 1px solid cornflowerblue;border-radius: 8px;height: 500px;margin-left: 30px;margin-top: 40px;width: 740px">
            <form action="${pageContext.request.contextPath}/editFirstCategoryServlet?action=update" method="post" class="form-horizon" role="form">
                <div class="form-group" style="margin-top: 30px">
                    <label style="margin-left: 125px"><h3>请在下方文本框中输入新的分类名和描述信息</h3></label>
                	<input type="hidden" value="${fc.fc_id}" name="fc_id">
                </div>
                <div class="form-group" style="margin-top: 25px">
                    <input type="text" maxlength="6" id="fc_name" name="fc_name" class="form-control" placeholder="请输入新的一级分类名（不超过6个字）" style="width:500px;height: 40px;border-radius: 6px;margin-left: 115px" value="${fc.fc_name}">
                	<span id="checkFc" style="float: right;margin-top: -30px;margin-right: 20px"></span>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <textarea id="fc_info" class="form-control" maxlength="25" rows="8" name="fc_info" placeholder="请输入该分类的描述信息（不超过25个字）" style="width:500px;border-radius: 6px;margin-left: 115px">${fc.fc_info}</textarea>
                	<span id="checkFcInfo" style="float: right;margin-top: -150px;"></span>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <button id="subtn" type="submit" class="btn btn-default" style="margin-left: 290px;margin-right: 20px">修改</button>
                    <button onclick="history.go(-1)" class="btn btn-default" >返回</button>
                </div>
            </form>
        </div>
          
            
            
           
        </div>
</body>
</html>