<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询一级分类下属商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>
<div class="row" style="800px">
        
          <form action="${pageContext.request.contextPath}/searchFcProductServlet" role="form" class="form-inline"  method="post">
    <div class="col-md-8" style="margin-top: 30px;margin-left: 120px">
        <div class="row">
            <div class="col-md-9" >
                    <div class="form-group" style="float: right">
                        <select name="fc_name" class="form-control" style="height:40px;width: 120px;float: right;margin-right: -40px">
                                <c:forEach items="${fcList}" var="fc">
                                	<option>${fc.fc_name}</option>
                                </c:forEach>
                            </select>
                    </div>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-primary" style="margin-right: 45px;height: 40px;background: #1E90FF;border: 1px solid #1E90FF;width: 80px;float: right">查询</button>
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
                    	<input type="button" value="查看" class="btn btn-primary" style="background: #1E90FF;border: 1px solid #1E90FF;margin-right: -10px">
                    </a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <input type="hidden" value="${fcId}">
        <div class="row" style="margin-left: 200px">
            	<ul class="pagination">
            		<c:if test="${pageNumFcPro==1}">
                		<li class="disabled"><a href="#">&laquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumFcPro!=1}">
                		<li><a href="${pageContext.request.contextPath}/searchFcProductServlet?fcId=${fcId}&pageNumFcPro=${pageNumFcPro-1}">&laquo;</a></li>
                	</c:if>
            		
            		<c:forEach begin="1" end="${pageCount}" var="p">
                		<c:if test="${p==pageNumFcPro}">
                			<li class="active"><a href="#">${p}</a></li>
                		</c:if>
                		<c:if test="${p!=pageNumFcPro}">
                			<li><a href="${pageContext.request.contextPath}/searchFcProductServlet?fcId=${fcId}&pageNumFcPro=${p}">${p} </a></li>
                		</c:if>
                	</c:forEach> 
                	
                	<c:if test="${pageNumFcPro==pageCount}">
                		<li class="disabled"><a href="#">&raquo;</a></li>
                	</c:if>
                	<c:if test="${pageNumFcPro!=pageCount}">
                		<li><a href="${pageContext.request.contextPath}/searchFcProductServlet?fcId=${fcId}&pageNumFcPro=${pageNumFcPro+1}">&raquo;</a></li>
                	</c:if>
				</ul>
        	</div>
        
    </div>
</form>
          
            
            
           
        </div>



</body>
</html>