<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<style type="text/css">
	.navbar-header a>img {
		height: 100%;
	}

</style>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.bit">
        <img alt="Brand" src="http://bitcamp.co.kr/img/link2.png">
      </a>
    </div>
  <ul class="nav navbar-nav">
  	<li><a href="index.bit">Home</a></li>
  	<li><a href="list.bit">List</a></li>
  	<li class="active"><a href="add.bit">Add</a></li>
  </ul>
  </div>
</nav>
<div class="page-header">
  <h1>수정 페이지<small>사번 ${bean.sabun }님의 정보</small> </h1>
</div>
<form action="update.bit" method="post">
	<div class="form-group">
		<label for="sabun">sabun</label>
		<div class="well well-sm">${bean.sabun }</div>
		<input type="hidden" value="${bean.sabun }" class="form-control" name="sabun" id="sabun" placeholder="sabun" />
	</div>
	<div class="form-group">
		<label for="name">name</label>
		<input type="text" value="${bean.name }" class="form-control" name="name" id="name" placeholder="name" />
	</div>
	<div class="form-group">
		<label for="nalja">nalja</label>
		<div class="well well-sm">${bean.nalja }</div>
	</div>
	<div class="form-group">
		<label for="pay">pay</label>
		<input type="text" value="${bean.pay }" class="form-control" name="pay" id="pay" placeholder="pay" />
	</div>
	<button type="submit" class="btn btn-danger">수정</button>
	<button type="reset">취소</button>
</form>
</body>
</html>











