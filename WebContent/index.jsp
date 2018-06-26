<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
        $(function(){
            $(".panel-heading").click(function(e){
                /*切换折叠指示图标*/
                $(this).find("span").toggleClass("glyphicon-chevron-down");
                $(this).find("span").toggleClass("glyphicon-chevron-up");
            });
        });
        </script>
        
        <style>
            .panel-group{max-height:770px;overflow: auto;}
            .leftMenu{margin:10px;margin-top:5px;}
            .leftMenu .panel-heading{font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
            .leftMenu .panel-heading span{position:absolute;right:10px;top:12px;}
            .leftMenu .menu-item-left{padding: 2px; background: transparent; border:1px solid transparent;border-radius: 6px;}
            .leftMenu .menu-item-left:hover{background:#C4E3F3;border:1px solid #1E90FF;}
        </style>
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
                        <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/FirstCategory/AddFirstCategory.jsp" target="mainFrame">
                                		<span class="glyphicon glyphicon-triangle-right">添加一级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fc" target="mainFrame">
                                		<span class="glyphicon glyphicon-triangle-right">修改/删除一级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=fcPro" target="mainFrame">
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
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=sc" target="mainFrame">
                                		<span class="glyphicon glyphicon-triangle-right">添加二级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchSecondCategoryServlet?action=sc" target="mainFrame">
                                		<span class="glyphicon glyphicon-triangle-right">修改/删除二级分类</span>
                                	 </a>
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=scPro" target="mainFrame">
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
                                	 <a href="${pageContext.request.contextPath}/searchFirstCategoryServlet?action=addPro" target="mainFrame">
                                		<span class="glyphicon glyphicon-triangle-right">新商品登记</span>
                                	 </a>
                                </button>
                              </li>	
                              <li class="list-group-item">
                                <button class="menu-item-left" >
                                	 <a href="${pageContext.request.contextPath}/searchProductServlet?action=blank" target="mainFrame">
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
          
       <div class="col-md-9" style="height: 1500px">
       	<iframe name="mainFrame" width="100%" height="1500px" frameborder="0" marginheight="0" >
        	
        </iframe> 
       </div>
           
    	
          

      
           
        </div>
</body>
</html>