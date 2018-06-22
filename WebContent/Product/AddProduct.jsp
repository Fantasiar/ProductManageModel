<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加商品</title>
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
<jsp:include page="/index.jsp" />
<div class="container" style="margin-top: 80px">
    <div class="row" >
        <div class="col-md-8 " style="background-color: #D1EEEE;border: 1px solid cornflowerblue;border-radius: 8px;height: 1100px">
            <form action="${pageContext.request.contextPath}/addProductServlet?action=addPro" class="form-horizontal" role="form" method="post">
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品名称</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="product_name" name="product_name" placeholder="10个字以内（必填）" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品一级分类</label>
                    <div class="col-md-4">
                        <select id="fc_name" name="fc_name" class="form-control" style="height:40px;">
                                <c:forEach items="${fcList}" var="fc">
                                	<option>${fc.fc_name}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品二级分类</label>
                    <div class="col-md-4">
                        <select id="sc_name" name="sc_name" class="form-control" style="height:40px;">
                            
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">计量单位</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="measure" name="measure" placeholder="10个字以内" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">原价</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="original_price" name="original_price" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品折扣</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="discount" name="discount" placeholder="0~1的浮点数（必填）" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">成本价</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="cost_price" name="cost_price" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">型号</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="version" name="version" placeholder="选填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">供应商</label>
                    <div class="col-md-4">
                        <select id="supplier_name" name="supplier_name" class="form-control" style="height:40px;">
                                <c:forEach items="${supList}" var="sup">
                                	<option>${sup.supplier_name}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">厂商</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="publisher" name="publisher" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">保质期限</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="shelf_life" name="shelf_life" placeholder="选填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">备注</label>
                    <div class="col-md-6">
                        <textarea rows="8" id="remarks" name="remarks" style="width: 175px" placeholder="选填"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10" style="margin-left: 350px">
                        <button type="submit" class="btn btn-default">登记</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>