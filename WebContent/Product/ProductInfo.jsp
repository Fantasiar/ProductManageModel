<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
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
        <script>
        $(function(){
            $(".panel-heading").click(function(e){
                /*切换折叠指示图标*/
                $(this).find("span").toggleClass("glyphicon-chevron-down");
                $(this).find("span").toggleClass("glyphicon-chevron-up");
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
          
       <div class="col-md-6 " style="background-color: #BFEFFF;border: 1px solid cornflowerblue;border-radius: 8px;height: 800px;margin-left: 30px;margin-top: 20px">
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">商品名称：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.product_name}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">商品一级分类：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.getFc().fc_name}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">商品二级分类：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.getSc().sc_name}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">计量单位：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.measure}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">原价：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.original_price}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">商品折扣：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.discount}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">成本价：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.cost_price}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">型号：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.version}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">供应商：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.getSupplier().supplier_name}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">厂商：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.publisher}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">保质期限：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.shelf_life}</label>
            </div>
            <div class="row" style="margin-left: 150px;margin-top: 25px">
                <label for="" class="col-md-4 control-label" style="font-size:20px">备注：</label>
                <label for="" class="col-md-5 col-md-offset-1 control-label" style="font-size:20px">${product.remarks}</label>
            </div>
            <div>
                <div class="col-md-offset-2 col-md-10" style="margin-left: 300px;margin-top: 30px">
                        <button onclick="history.go(-1)" class="btn btn-default">返回</button>
                </div>
            </div>
    </div>
          

      
           
        </div>
</body>
</html>