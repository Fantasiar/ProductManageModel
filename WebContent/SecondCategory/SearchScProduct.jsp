<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询二级分类下属商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	$(function() {
		
		
		$("#fc_name").blur(function() {
			var fc_name=$(this).val();
			$.ajax({
				url:"${pageContext.request.contextPath}/addProductServlet?action=findSc",
				async:false,
				type:"POST",
				data:{"fc_name":fc_name},
				success:function(data){
					var con="";
					$.each(data,function(i,sc){
					con+="<option>"+sc.sc_name+"</option>"
					});
					$("#sc_name").html(con);
				},
				error:function(){
					alert("获取二级分类失败");
				},
				dataType:"json"
			});
		});
			
	})
	</script>
</head>
<body>
<div class="row" style="width: 900px">
            
         <form action="${pageContext.request.contextPath}/searchScProductServlet" role="form" class="form-inline" method="post">
    <div style="margin-top: 30px;margin-left: 120px">
        <div class="row">
            <div class="col-md-6" style="margin-right: -50px;margin-left: 30px">
                <div class="form-group" style="float: right;margin-right: -30px">
                    <select id="fc_name" name="fc_name" class="form-control" style="height:40px;width: 120px">
                                <c:forEach items="${fcList}" var="fc">
                                	<option>${fc.fc_name}</option>
                                </c:forEach>
                    </select>
                </div>
            </div>
            <div class="col-md-3" >
                <div class="form-group" style="float: right;margin-right: -30px">
                    <select id="sc_name" name="sc_name" class="form-control" style="height:40px;width: 120px">
                            
                    </select>
                </div>
            </div>
            <div class="col-md-3">
                <button class="btn btn-danger" style="margin-left: 30px;height: 40px;width: 80px;background: #1E90FF;border: 1px solid #1E90FF;">查询</button>
            </div>
        </div>
        <div class="row" style="margin-left: -100px;width: 900px">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th style="font-size: 25px;">商品代码</th>
                    <th style="font-size: 25px;">商品名</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${proList}" var="pro">
                	<tr>
                    <td>
                        <label style="font-size: 18px">
                            ${pro.product_id}
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            ${pro.product_name}
                        </label>
                    </td>
                    <td>
                    <a href="${pageContext.request.contextPath}/productInfoServlet?product_id=${pro.product_id}">
                    	<input type="button" class="btn btn-danger" value="查看" style="background: #1E90FF;border: 1px solid #1E90FF;margin-right: 110px;float: right">
                    </a>
                    </td>
                </tr>
                </c:forEach>
                
                </tbody>
            </table>
        </div>
        <div class="row" style="margin-left: 200px">
            	<ul class="pagination">
            		<c:if test="${pageNumScPro==1}">
                		<li class="disabled"><a href="#">&laquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumScPro!=1}">
                		<li><a href="${pageContext.request.contextPath}/searchScProductServlet?scId=${scId}&pageNumScPro=${pageNumScPro-1}">&laquo;</a></li>
                	</c:if>
            		
            		<c:forEach begin="1" end="${pageCount}" var="p">
                		<c:if test="${p==pageNumScPro}">
                			<li class="active"><a href="#">${p}</a></li>
                		</c:if>
                		<c:if test="${p!=pageNumScPro}">
                			<li><a href="${pageContext.request.contextPath}/searchScProductServlet?scId=${scId}&pageNumScPro=${p}">${p} </a></li>
                		</c:if>
                	</c:forEach> 
                	
                	<c:if test="${pageNumScPro==pageCount}">
                		<li class="disabled"><a href="#">&raquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumScPro!=pageCount}">
                		<li><a href="${pageContext.request.contextPath}/searchScProductServlet?scId=${scId}&pageNumScPro=${pageNumScPro+1}">&raquo;</a></li>
                	</c:if>
				</ul>
        	</div>
        
    </div>
</form>
             
            
           
        </div>
</body>
</html>