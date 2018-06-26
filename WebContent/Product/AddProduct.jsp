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
	<style>
            .panel-group{max-height:770px;overflow: auto;}
            .leftMenu{margin:10px;margin-top:5px;}
            .leftMenu .panel-heading{font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
            .leftMenu .panel-heading span{position:absolute;right:10px;top:12px;}
            .leftMenu .menu-item-left{padding: 2px; background: transparent; border:1px solid transparent;border-radius: 6px;}
            .leftMenu .menu-item-left:hover{background:#C4E3F3;border:1px solid #1E90FF;}
        </style>
	<script type="text/javascript">
	$(function() {
		$(".panel-heading").click(function(e){
            /*切换折叠指示图标*/
            $(this).find("span").toggleClass("glyphicon-chevron-down");
            $(this).find("span").toggleClass("glyphicon-chevron-up");
        });
		
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
					$("#checkDiscount").html("商品折扣格式不正确");
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
	<div class="row">
            <div class="col-md-2">
                <div class="panel-group table-responsive" role="tablist">
                    <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                            <h4 class="panel-title">
                                一级分类管理
                                <span class="glyphicon glyphicon-chevron-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/FirstCategory/AddFirstCategory.jsp">
                                		<span class="glyphicon glyphicon-triangle-right">添加一级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fc">
                                		<span class="glyphicon glyphicon-triangle-right">修改/删除一级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fcPro">
                                		<span class="glyphicon glyphicon-triangle-right">查询下属商品</span>
                                	 </a>
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div><!--panel end-->
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                            <h4 class="panel-title">
                                二级分类管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup2" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=sc">
                                		<span class="glyphicon glyphicon-triangle-right">添加二级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchSecondCategoryServlet?action=sc">
                                		<span class="glyphicon glyphicon-triangle-right">修改/删除二级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=scPro">
                                		<span class="glyphicon glyphicon-triangle-right">查询下属商品</span>
                                	 </a>
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div> 
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                            <h4 class="panel-title">
                                商品管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup3" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=addPro">
                                		<span class="glyphicon glyphicon-triangle-right">新商品登记</span>
                                	 </a>
                                </button>
                              </li>	
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchProductServlet?action=blank">
                                		<span class="glyphicon glyphicon-triangle-right">查询商品</span>
                                	 </a>
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div> 
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading4" data-toggle="collapse" data-target="#collapseListGroup4" role="tab" >
                            <h4 class="panel-title">
                                库房管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup4" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading4">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>增加库房
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>库房信息管理
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>库房储备设置
                                </button>
                              </li>
                              
                            </ul>
                        </div>
                    </div>
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading5" data-toggle="collapse" data-target="#collapseListGroup5" role="tab" >
                            <h4 class="panel-title">
                                库房查询
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup5" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading5">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>库存量查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>出入库查询
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading6" data-toggle="collapse" data-target="#collapseListGroup6" role="tab" >
                            <h4 class="panel-title">
                                供应商管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup6" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading6">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>增加供应商
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>查询供应商
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading7" data-toggle="collapse" data-target="#collapseListGroup7" role="tab" >
                            <h4 class="panel-title">
                                进货管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup7" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading7">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>单个商品进货
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>所有缺货商品查询
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading8" data-toggle="collapse" data-target="#collapseListGroup8" role="tab" >
                            <h4 class="panel-title">
                                退货管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup8" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading8">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>退货管理
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading9" data-toggle="collapse" data-target="#collapseListGroup9" role="tab" >
                            <h4 class="panel-title">
                                业务管理
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup9" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading9">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>订购排行查询
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>客户满意度分析
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分站配送情况分析
                                </button>
                              </li>
                              
                            </ul>
                        </div>
                    </div> 
                </div>
            </div>
          
         <div class="col-md-6 " style="background-color: #BFEFFF;border: 1px solid cornflowerblue;border-radius: 8px;height: 1000px;margin-left: 30px;margin-top: 20px">
            <form action="${pageContext.request.contextPath}/addProductServlet?action=addPro" class="form-horizontal" role="form" method="post">
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品名称</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="10" class="form-control" id="product_name" name="product_name" placeholder="10个字以内（必填）" style="height:40px">
                    	<span id="checkPro" style="float: right;margin-top: -30px;margin-right: -130px"></span>
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
                        <input type="text" maxlength="2" class="form-control" id="measure" name="measure" placeholder="10个字以内" style="height:40px">
                   		<span id="checkMeasure" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">原价</label>
                    <div class="col-md-4">
                        <input type="number" max="1000000" step="any" class="form-control" id="original_price" name="original_price" placeholder="数字类型（必填）" style="height:40px">
                   		<span id="checkOP" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品折扣</label>
                    <div class="col-md-4">
                        <input type="number" max="1" step="any" class="form-control" id="discount" name="discount" placeholder="0~1的浮点数（必填）" style="height:40px">
                   		<span id="checkDiscount" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">成本价</label>
                    <div class="col-md-4">
                        <input type="number" max="1000000" step="any" class="form-control" id="cost_price" name="cost_price" placeholder="数字类型（必填）" style="height:40px">
                    	<span id="checkCP" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">型号</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="8" class="form-control" id="version" name="version" placeholder="选填" style="height:40px">
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
                        <input type="text" maxlength="15" class="form-control" id="publisher" name="publisher" placeholder="必填" style="height:40px">
                    	<span id="checkPublisher" style="float: right;margin-top: -30px;margin-right: -130px"></span>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">保质期限</label>
                    <div class="col-md-4">
                        <input type="text" maxlength="5" class="form-control" id="shelf_life" name="shelf_life" placeholder="选填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">备注</label>
                    <div class="col-md-6">
                        <textarea rows="8" maxlength="30" id="remarks" name="remarks" style="width: 175px" placeholder="选填"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10" style="margin-left: 350px">
                        <button id="subtn" type="submit" class="btn btn-default">登记</button>
                    </div>
                </div>
            </form>
        </div>
             
            
           
        </div>
</body>
</html>