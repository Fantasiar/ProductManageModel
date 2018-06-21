<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改/删除二级分类</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function deleteSecondCategory(){
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
			document.forms[0].action="${pageContext.request.contextPath}/deleteSecondCategoryServlet";
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
<form action="" method="post" role="form">
    <div class="container">
        <div class="row" style="margin-top: 20px;margin-left: -100px;width: 900px">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th style="font-size: 25px;">二级分类名</th>
                    <th style="font-size: 25px;">所属一级类</th>
                    <th><button onclick="deleteSecondCategory()" class="btn btn-default" style="float: right;margin-right: 50px">删除</button></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${scList}" var="sc">
                	<tr>
                    <td>
                        <label style="font-size: 18px">
                            <input name="chk" type="checkbox" value="${sc.sc_id}" style="margin-right: 10px">${sc.sc_name}
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            ${sc.getFc().fc_name}
                        </label>
                    </td>
                    <td>
						<a href="${pageContext.request.contextPath}/editSecondCategoryServlet?sc_id=${sc.sc_id}&action=edit">修改</a>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row">
                <div class="col-md-1 col-md-offset-2">
                    <label for="">PREVIOUS</label>
                </div>
                <div class="col-md-1">
                	<c:forEach begin="1" end="${pageCount}" var="p">
                		<c:if test="${p==pageNumSc}">
                			<label for="">${p}  </label>
                		</c:if>
                		<c:if test="${p!=pageNumSc}">
                			<label for=""><a href="${pageContext.request.contextPath}/searchSecondCategoryServlet?action=sc&pageNumSc=${p}">${p}  </a></label>
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