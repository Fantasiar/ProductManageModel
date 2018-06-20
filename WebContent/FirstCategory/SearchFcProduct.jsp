<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询一级分类下属商品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
	</script>
</head>
<body>
<jsp:include page="/index.jsp" />
<form action="" role="form" class="form-inline">
    <div class="container" style="margin-top: 30px">
        <div class="row">
            <div class="col-md-7" >
                    <div class="form-group" style="float: right">
                        <select class="form-control" style="height:40px;width: 200px">
                            <option>数码</option>
                            <option>食品</option>
                            <option>服装</option>
                        </select>
                    </div>
            </div>
            <div class="col-md-5">
                <button class="btn btn-default" style="margin-right: 70px;height: 40px">查询</button>
            </div>
        </div>
        <div class="row" style="margin-left: -100px;width: 900px">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th style="font-size: 25px;">商品代码</th>
                    <th style="font-size: 25px;">商品名</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <label style="font-size: 18px">
                            Tanmay
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            Tanmay
                        </label>
                    </td>
                    <td>
                        <button class="btn btn-default" style="float: right;margin-right: 50px">查看</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label style="font-size: 18px">
                            Tanmay
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            Tanmay
                        </label>
                    </td>
                    <td>
                        <button class="btn btn-default" style="float: right;margin-right: 50px">查看</button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label style="font-size: 18px">
                            Tanmay
                        </label>
                    </td>
                    <td>
                        <label style="font-size: 18px">
                            Tanmay
                        </label>
                    </td>
                    <td>
                        <button class="btn btn-default" style="float: right;margin-right: 50px">查看</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-md-1 col-md-offset-2">
                <label for="">PREVIOUS</label>
            </div>
            <div class="col-md-1">
                <label for="">1  2  3  4  5  6</label>
            </div>
            <div class="col-md-1">
                <label for="">NEXT</label>
            </div>
        </div>
    </div>
</form>
</body>
</html>