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
	 
</head>
<body>
<div class="row">
            
       <div class="col-md-8 " style="background-color: #BFEFFF;border: 1px solid cornflowerblue;border-radius: 8px;height: 800px;margin-left: 30px;margin-top: 20px">
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