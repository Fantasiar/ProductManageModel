<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
    <title>查询商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
	function deleteProduct(){
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
			document.forms[0].action="${pageContext.request.contextPath}/deleteProductServlet";
			document.forms[0].submit();
		}else{
			//提示
			alert("请至少选择一个用户进行删除");
		}
	}
	
	</script>
</head>
<body>
	<div class="row" style="width: 1000px">
           
          
       <form action="${pageContext.request.contextPath}/searchProductServlet" role="form" class="form-inline" method="post">
    <div style="margin-top: 30px;margin-left: 120px">
        <div class="row">
            <div class="form-group" style="margin-left:500px ">
                <input type="text" maxlength="10" class="form-control" id="product_name" name="product_name" placeholder="请输入商品名称" style="height:40px;width: 200px;margin-right: 10px">
                <button class="btn btn-danger" style="margin-right: 50px;height: 40px;width: 80px;background: #1E90FF;border: 1px solid #1E90FF;">查询</button>
            </div>
        </div>
        <div class="row" style="margin-left: -100px;width: 900px">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th style="font-size: 25px;">商品代码</th>
                    <th style="font-size: 25px;">商品名</th>
                    <th><button onclick="deleteProduct()" class="btn btn-danger" style="float: right;margin-right: 40px;background: #EE0000;border: 1px solid #EE0000">删除</button></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${proList}" var="pro">
                	<tr>
                    <td>
                        <label style="font-size: 18px">
                        <c:if test="${pro.isDelete()==true}">
                         	<input name="chk" type="checkbox" value="${pro.product_id}" style="margin-right: 10px">${pro.product_id}
                         </c:if>
                         <c:if test="${pro.isDelete()==false}">
                             <input name="chk" disabled="disabled" type="checkbox" value="${pro.product_id}" style="margin-right: 10px">${pro.product_id}
                         </c:if>  
                            
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            ${pro.product_name}
                        </label>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/productInfoServlet?product_id=${pro.product_id}">
                        	<input type="button" value="查看" class="btn btn-danger" style="background: #1E90FF;border: 1px solid #1E90FF;float: right;margin-right: 40px">
                        	</a>
                        <a href="${pageContext.request.contextPath}/editProductServlet?product_id=${pro.product_id}&action=edit">
                        	<input type="button" value="修改" class="btn btn-danger" style="background: #FFB90F;border: 1px solid #FFB90F;float: right;margin-right: 30px">
                        	</a>
                    </td>
                </tr>
                </c:forEach>
                
                
                </tbody>
            </table>
        </div>
        <div class="row" style="margin-left: 200px">
            	<ul class="pagination">
            		<c:if test="${pageNumPro==1}">
                		<li class="disabled"><a href="#">&laquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumPro!=1}">
                		<li><a href="${pageContext.request.contextPath}/searchProductServlet?product_id=${product_id}&pageNumPro=${pageNumPro-1}">&laquo;</a></li>
                	</c:if>
            		
            		<c:forEach begin="1" end="${pageCount}" var="p">
                		<c:if test="${p==pageNumPro}">
                			<li class="active"><a href="#">${p}</a></li>
                		</c:if>
                		<c:if test="${p!=pageNumPro}">
                			<li><a href="${pageContext.request.contextPath}/searchProductServlet?product_id=${product_id}&pageNumPro=${p}">${p} </a></li>
                		</c:if>
                	</c:forEach> 
                	
                	<c:if test="${pageNumPro==pageCount}">
                		<li class="disabled"><a href="#">&raquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumPro!=pageCount}">
                		<li><a href="${pageContext.request.contextPath}/searchProductServlet?product_id=${product_id}&pageNumPro=${pageNumPro+1}">&raquo;</a></li>
                	</c:if>
				</ul>
        	</div>
        

    </div>
</form>
             
          

      
           
        </div>

</body>
</html>