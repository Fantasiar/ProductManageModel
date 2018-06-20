<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加商品</title>
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
                        <input type="text" class="form-control" id="" name="" placeholder="10个字以内（必填）" style="height:40px">
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
                            <option>数码</option>
                            <option>食品</option>
                            <option>服装</option>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">计量单位</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="10个字以内" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">原价</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">商品折扣</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="0~1的浮点数（必填）" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">成本价</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">型号</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="选填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">供应商</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">厂商</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="必填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">保质期限</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="" name="" placeholder="选填" style="height:40px">
                    </div>
                </div>
                <div class="form-group" style="margin-left: 150px;margin-top: 25px">
                    <label for="" class="col-md-4 control-label" style="font-size:20px">备注</label>
                    <div class="col-md-6">
                        <textarea rows="8" style="width: 175px" placeholder="选填"></textarea>
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