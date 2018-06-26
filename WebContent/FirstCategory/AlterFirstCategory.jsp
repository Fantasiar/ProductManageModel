<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改/删除一级分类</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function deleteFirstCategory(){
		var chks=document.getElementsByName("chk");
		var flag=false;
		for(var i=0;i<chks.length;i++){
			if(chks[i].checked==true){
				flag=true;
				break;
			}
		}
		if(flag){
			//提交请求
			document.forms[0].action="${pageContext.request.contextPath}/deleteFirstCategoryServlet";
			document.forms[0].submit();
		}else{
			//提示
			alert("请至少选择一个用户进行删除");
		}
	}
	</script>
</head>
<body>
	<div class="row">
          <form action="" method="post">
        <div style="width: 800px;margin-left: 30px">
            <div class="row" style="margin-top: 20px;margin-left: 20px;width: 800px;margin-top: 20px">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th style="font-size: 25px;">一级分类名</th>
                        <th><button onclick="deleteFirstCategory()" class="btn btn-danger" style="float: right;margin-right: 50px;background: #EE0000;border: 1px solid #EE0000;width: 80px">删除</button></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${fcList}" var="fc">
                    	<tr>
                        <td>
                            <label style="font-size: 18px">
                            <c:if test="${fc.isDelete()==true}">
                            	<input type="checkbox" id="chk" name="chk" value="${fc.fc_id}" style="margin-right: 10px">${fc.fc_name}
                            </c:if>
                             <c:if test="${fc.isDelete()==false}">
                            	<input type="checkbox" disabled="disabled" id="chk" name="chk" value="${fc.fc_id}" style="margin-right: 10px">${fc.fc_name}
                            </c:if>  
                            </label>
                        </td>
                        <td>
                        	
                        	<a href="${pageContext.request.contextPath}/editFirstCategoryServlet?fc_id=${fc.fc_id}&action=edit">
                        		<input type="button" class="btn btn-warning"  value="修改" style="background: #FFB90F;border:1px solid #FFB90F;float: right;margin-right: 65px">
                        	</a>
                        	<!-- <button onclick="" class="btn btn-default" style="float: right;margin-right: 50px">修改</button> -->
                        	
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row" style="margin-left: 200px">
            	<ul class="pagination">
            		<c:if test="${pageNumFc==1}">
                		<li class="disabled"><a href="#">&laquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumFc!=1}">
                		<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fc&pageNumFc=${pageNumFc-1}">&laquo;</a></li>
                	</c:if>
            		
            		<c:forEach begin="1" end="${pageCount}" var="p">
                		<c:if test="${p==pageNumFc}">
                			<li class="active"><a href="#">${p}</a></li>
                		</c:if>
                		<c:if test="${p!=pageNumFc}">
                			<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fc&pageNumFc=${p}">${p} </a></li>
                		</c:if>
                	</c:forEach> 
                	
                	<c:if test="${pageNumFc==pageCount}">
                		<li class="disabled"><a href="#">&raquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumFc!=pageCount}">
                		<li><a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fc&pageNumFc=${pageNumFc+1}">&raquo;</a></li>
                	</c:if>
				</ul>
        	</div>
        
    </div>
</form>
          
            
            
           
        </div>
	
    
</body>
</html>