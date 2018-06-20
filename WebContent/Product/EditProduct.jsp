<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改商品信息</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top: 80px">
    <div class="row" >
        <div class="col-md-8 " style="background-color: #D1EEEE;border: 1px solid cornflowerblue;border-radius: 8px;height: 1100px">
            <form class="form-horizontal" role="form">
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品名称</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="小米8">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品一级分类</label>
                    <div class="col-md-4">
                        <select class="form-control" style="height:40px;">
                            <option>数码</option>
                            <option>食品</option>
                            <option>服装</option>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品二级分类</label>
                    <div class="col-md-4">
                        <select class="form-control" style="height:40px;">
                            <option>手机</option>
                            <option>食品</option>
                            <option>服装</option>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">计量单位</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="台">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">原价</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name=""  style="height:40px" value="2699.0">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品折扣</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="0.85">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">成本价</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="2299.0">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">型号</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="4+64G">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">供应商</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="富士康">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">厂商</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="小米科技有限公司">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">保质期限</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" style="height:40px" value="2年">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">备注</label>
                    <div class="col-md-6">
                        <textarea rows="8" style="width: 175px" >最便宜的骁龙845手机</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10" style="margin-left: 310px">
                        <button type="submit" class="btn btn-default" style="margin-right: 20px">修改</button>
                        <button  class="btn btn-default">返回</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>