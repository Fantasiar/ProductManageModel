<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>增加二级分类</title>
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
		
		$("#sc_name").blur(function() {
			var sc_name=$(this).val();
			if (sc_name=="") {
				$("#checkSc").css("color","red");
				$("#checkSc").html("类名不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$.ajax({
					url:"${pageContext.request.contextPath}/checkFdsServlet?action=addSc",
					async:false,
					type:"POST",
					data:{"sc_name":sc_name},
					success:function(data){
						var isExist=data.isExist;
						var checkInfo="";
						if(isExist){
							//该用户存在
							checkInfo = "该类名已经存在";
							$("#checkSc").css("color","red");
							$("#subtn").attr("disabled",true);
						}else{
							checkInfo = "该类名可以使用"
							$("#checkSc").css("color","green");
							$("#subtn").attr("disabled",false);
						}
						$("#checkSc").html(checkInfo);
					},
					error:function(){
						alert("查询二级类名失败");
					},
					dataType:"json"
				});
			}
			
		});
		
		$("#sc_info").blur(function() {
			var sc_info=$(this).val();
			if(sc_info==""){
				$("#checkScInfo").css("color","red");
				$("#checkScInfo").html("类名描述不能为空！");
				$("#subtn").attr("disabled",true);
			}else {
				$("#checkScInfo").css("color","green");
				$("#checkScInfo").html("类名描述格式正确");
				$("#subtn").attr("disabled",false);
			}
		});
	});
	
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
                        <div id="collapseListGroup2" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
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
                        <div id="collapseListGroup3" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading3">
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
          
         <div class="col-md-6 " style="background-color: #BFEFFF;border: 1px solid cornflowerblue;border-radius: 8px;height: 500px;margin-left: 30px;margin-top: 40px">
            <form action="${pageContext.request.contextPath}/addSecondCategoryServlet" class="form-horizon" role="form" method="post">
                <div class="form-group" style="margin-top: 30px">
                    <label style="margin-left: 40px"><h3>请选择对应的一级分类，并输入要添加的二级分类名和描述信息</h3></label>
                </div>
                <div class="row">
                    <div class="col-md-4" style="margin-left: 120px">
                        <div class="form-group" style="width: 200px;">
                            <select name="fc_name" class="form-control" style="height:40px;">
                                <c:forEach items="${fcList}" var="fc">
                                	<option>${fc.fc_name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4" style="margin-left: 30px">
                        <div class="form-group">
                            <input id="sc_name" maxlength="6" name="sc_name" type="text" class="form-control" placeholder="请输入二级类名（6个字以内）" style="width:200px;height: 40px;border-radius: 6px;">
                        	<span id="checkSc" style="float: right;margin-top: -30px;margin-right: -90px"></span>
                        </div>
                    </div>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <textarea id="sc_info" name="sc_info" maxlength="25" class="form-control" rows="8" placeholder="请输入该分类的描述信息(25个字以内)" style="width:500px;border-radius: 6px;margin-left: 115px"></textarea>
              		<span id="checkScInfo" style="float: right;margin-top: -150px;"></span>
                </div>
                <div class="form-group" style="margin-top: 30px">
                    <button id="subtn" type="submit" class="btn btn-default" style="margin-left: 320px">添加</button>
                </div>
            </form>
        </div>
          
            
            
           
        </div>
</body>
</html>