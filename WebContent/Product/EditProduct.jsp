<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改商品信息</title>
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
		
		$("#product_name").blur(function() {
			var product_name=$(this).val();
			if (product_name=="") {
				$("#checkPro").css("color","red");
				$("#checkPro").html("商品名不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$.ajax({
					url:"${pageContext.request.contextPath}/checkFdsServlet?action=addPro",
					async:false,
					type:"POST",
					data:{"product_name":product_name},
					success:function(data){
						var isExist=data.isExist;
						var checkInfo="";
						if(isExist){
							//该用户存在
							checkInfo = "该商品名已经存在";
							$("#checkPro").css("color","red");
							$("#subtn").attr("disabled",true);
						}else{
							checkInfo = "该商品名可以使用"
							$("#checkPro").css("color","green");
							$("#subtn").attr("disabled",false);
						}
						$("#checkPro").html(checkInfo);
					},
					error:function(){
						alert("查询商品名失败");
					},
					dataType:"json"
				});
			}
			
		});
		
		$("#measure").blur(function() {
			var measure=$(this).val();
			if(measure==""){
				$("#checkMeasure").css("color","red");
				$("#checkMeasure").html("计量单位不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$("#checkMeasure").css("color","green");
				$("#checkMeasure").html("计量单位格式正确");
				$("#subtn").attr("disabled",false);
			}
		});
		
		$("#original_price").blur(function() {
			var original_price=$(this).val();
			if(original_price==""){
				$("#checkOP").css("color","red");
				$("#checkOP").html("原价不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				if (original_price>0 && original_price<1000000) {
					$("#checkOP").css("color","green");
					$("#checkOP").html("原价格式正确");
					$("#subtn").attr("disabled",false);
				}else {
					$("#checkOP").css("color","red");
					$("#checkOP").html("原价数额过大");
					$("#subtn").attr("disabled",false);
				}
				
			}
		});
		
		$("#discount").blur(function() {
			var discount=$(this).val();
			if(discount==""){
				$("#checkDiscount").css("color","red");
				$("#checkDiscount").html("商品折扣不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				if (discount>0 && discount<=1) {
					$("#checkDiscount").css("color","green");
					$("#checkDiscount").html("商品折扣格式正确");
					$("#subtn").attr("disabled",false);
				}else {
					$("#checkDiscount").css("color","red");
					$("#checkDiscount").html("折扣不能大于1");
					$("#subtn").attr("disabled",true);
				}
				
			}
		});
		
		$("#cost_price").blur(function() {
			var cost_price=$(this).val();
			if(cost_price==""){
				$("#checkCP").css("color","red");
				$("#checkCP").html("成本价不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				if (cost_price>0 && cost_price<1000000) {
					$("#checkCP").css("color","green");
					$("#checkCP").html("成本价格式正确");
					$("#subtn").attr("disabled",false);
				}else {
					$("#checkCP").css("color","red");
					$("#checkCP").html("成本价数额过大");
					$("#subtn").attr("disabled",true);
				}
				
			}
		});
		
		$("#publisher").blur(function() {
			var publisher=$(this).val();
			if(publisher==""){
				$("#checkPublisher").css("color","red");
				$("#checkPublisher").html("厂商信息不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$("#checkPublisher").css("color","green");
				$("#checkPublisher").html("厂商信息格式正确");
				$("#subtn").attr("disabled",false);
			}
		});
		
	})
	
	</script>
</head>
<body>
<div class="row" style="width: 900px ">
         
            
       <div style="background-color: #BFEFFF;border: 1px solid cornflowerblue;border-radius: 8px;height: 1000px;margin-left: 30px;margin-top: 20px;width: 800px">
            <form action="${pageContext.request.contextPath}/editProductServlet?action=update" class="form-horizontal" role="form" method="post">
                <input type="hidden" name="product_id" value="${product.product_id}">
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品名称</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="product_name" name="product_name" style="height:40px" value="${product.product_name}">
                    	<span id="checkPro" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品一级分类</label>
                    <div class="col-md-4">
                        <select id="fc_name" name="fc_name" class="form-control" style="height:40px;">
                               <option selected="selected">${product.getFc().fc_name}</option> 
                                <c:forEach items="${fcList}" var="fc">
                                <c:if test="${fc.fc_name ne product.getFc().fc_name}"></c:if>
                                	<option>${fc.fc_name}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品二级分类</label>
                    <div class="col-md-4">
                        <select id="sc_name" name="sc_name" class="form-control" style="height:40px;">
                            <option selected="selected">${product.getSc().sc_name}</option>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">计量单位</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="2" class="form-control" id="measure" name="measure" style="height:40px" value="${product.measure}">
                   		<span id="checkMeasure" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">原价</label>
                    <div class="col-md-4">
                        <input type="number" max="1000000" step="any" class="form-control" id="original_price" name="original_price"  style="height:40px" value="${product.original_price}">
                   		<span id="checkOP" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品折扣</label>
                    <div class="col-md-4">
                        <input type="number" max="1" step="any" class="form-control" id="discount" name="discount" style="height:40px" value="${product.discount}">
                   		<span id="checkDiscount" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">成本价</label>
                    <div class="col-md-4">
                        <input type="number" max="1000000" step="any" class="form-control" id="cost_price" name="cost_price" style="height:40px" value="${product.cost_price}">
                 		<span id="checkCP" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">型号</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="8" class="form-control" id="version" name="version" style="height:40px" value="${product.version}">
                    	
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">供应商</label>
                    <div class="col-md-4">
                        <select id="supplier_name" name="supplier_name" class="form-control" style="height:40px;">
                                <option selected="selected">${product.getSupplier().supplier_name}</option>   
                                <c:forEach items="${supList}" var="sup">
               						<c:if test="${sup.supplier_name ne product.getSupplier().supplier_name}">
                                	    	<option>${sup.supplier_name}</option>
                                	    </c:if>                 
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">厂商</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="15" class="form-control" id="publisher" name="publisher" style="height:40px" value="${product.publisher}">
                    	<span id="checkPublisher" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">保质期限</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="5" class="form-control" id="shelf_life" name="shelf_life" style="height:40px" value="${product.shelf_life}">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">备注</label>
                    <div class="col-md-6">
                        <textarea name="remarks" maxlength="30" rows="8" style="width: 175px" >${product.remarks}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10" style="margin-left: 310px">
                        <button id="subtn" type="submit" class="btn btn-default" style="margin-right: 20px">修改</button>
                        <button  class="btn btn-default">返回</button>
                    </div>
                </div>
            </form>
        </div>   
          

      
           
        </div>
</body>
</html>