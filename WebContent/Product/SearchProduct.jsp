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
<jsp:include page="/index.jsp" />
<form action="${pageContext.request.contextPath}/searchProductServlet" role="form" class="form-inline" method="post">
    <div class="container" style="margin-top: 30px">
        <div class="row">
            <div class="form-group" style="margin-left:500px ">
                <input type="text" class="form-control" id="product_name" name="product_name" placeholder="选填" style="height:40px;width: 200px">
                <button class="btn btn-default" style="margin-right: 50px">查询</button>
            </div>
        </div>
        <div class="row" style="margin-left: -100px;width: 900px">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th style="font-size: 25px;">商品代码</th>
                    <th style="font-size: 25px;">商品名</th>
                    <th><button onclick="deleteProduct()" class="btn btn-default" style="float: right;margin-right: 50px">删除</button></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${proList}" var="pro">
                	<tr>
                    <td>
                        <label style="font-size: 18px">
                            <input name="chk" type="checkbox" value="${pro.product_id}" style="margin-right: 10px">${pro.product_id}
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            ${pro.product_name}
                        </label>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/productInfoServlet?product_id=${pro.product_id}">查看</a>
                        <a href="${pageContext.request.contextPath}/editProductServlet?product_id=${pro.product_id}&action=edit">修改</a>
                    </td>
                </tr>
                </c:forEach>
                
                
                </tbody>
            </table>
        </div>
        <input type="text" value="${product_name}" >
        <div class="row">
                <div class="col-md-1 col-md-offset-2">
                    <label for="">PREVIOUS</label>
                </div>
                <div class="col-md-1">
                	<c:forEach begin="1" end="${pageCount}" var="p">
                		<c:if test="${p==pageNumPro}">
                			<label for="">${p}  </label>
                		</c:if>
                		<c:if test="${p!=pageNumPro}">
                			<label  for=""><a href="${pageContext.request.contextPath}/searchProductServlet?product_name=${product_name}&pageNumPro=${p}">${p}  </a></label>
                		</c:if>
                	</c:forEach>                    
                </div>
                <div class="col-md-1">
                <label for="">NEXT</label>
            </div>
        </div>
    </div>
</form>
</body>
</html>