<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="utf-8">
<head>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


	<title>Home</title>
	
	<script>
		function filechk(){
			var chk=document.getElementById('chkid');
			var chkid=document.getElementById('idd').value;
			var chkid2=chkid.substring(chkid.lastIndexOf("."),chkid.length);
			
			if(chkid2!=".dbfile"){
				alert("DB파일만 가능합니다.");
			}else {
				chk.submit();
			}
		}
	</script>
	
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.userId==null }">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button type="button" onclick="location.href='/user/signin'" style=float:right>로그인</button>
						<button type="button" onclick ="location.href='/user/signup'" style=float:right>회원가입</button>					
					</div>
				</div>
			</div>		
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${sessionScope.userId!=null }">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button type="button" onclick="location.href='/user/logout'" style=float:right>logout</button>
						<h6 style=float:right>[username] : ${sessionScope.userId } 님</h6>			
					</div>
				</div>
			</div>		
		</c:when>
	</c:choose>
	
	
	
	<form action="uploadfile" method="post" enctype="multipart/form-data" id="chkid">
		<input type="file" name="uploadFile"
		 id="idd">
		<input type="button" value="파일업로드" onclick="filechk()">
	</form>
	
	
	
</body>
</html>
