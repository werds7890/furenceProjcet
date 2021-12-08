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

<!-- meta block -->
<title>Form validation - DHTMLX Form</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="utf-8">

<link rel="shortcut icon" href="/resources/common/favicon/favicon.ico"
	type="image/x-icon" />
<link rel="icon" href="/resources/common/favicon/icon-16.png"
	sizes="16x16" />
<link rel="icon" href="/resources/common/favicon/icon-32.png"
	sizes="32x32" />
<link rel="icon" href="/resources/common/favicon/icon-48.png"
	sizes="48x48" />
<link rel="icon" href="/resources/common/favicon/icon-96.png"
	sizes="96x96" />
<link rel="icon" href="/resources/common/favicon/icon-144.png"
	sizes="144x144" />
<!-- end meta block -->
<script type="text/javascript"
	src="/resources/codebase/suite.js?v=7.2.5"></script>
<link rel="stylesheet" href="/resources/codebase/suite.css?v=7.2.5">

<link rel="stylesheet" href="/resources/common/index.css?v=7.2.5">
<!-- custom sample head -->

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
body {
	margin: 0;
}
</style>

</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.userId==null }">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button type="button" onclick="location.href='/user/signin'" style="float: right">로그인</button>
						<button type="button" onclick="location.href='/user/signup'" style="float: right">회원가입</button>
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
						<button type="button" onclick="location.href='/user/logout'" style="float: right">logout</button>
						<h6 style="float: right">[username] : ${sessionScope.userId }님</h6>
					</div>
				</div>
			</div>
		</c:when>
	</c:choose>



	<form action="uploadfile" method="post" enctype="multipart/form-data" id="chkid">
		<input type="file" name="uploadFile" id="idd"> <input type="button" value="파일업로드" onclick="filechk()">
	</form>


	<c:choose>
		<c:when test="${sessionScope.userId!=null }">
			<script>
				const dataset = [];
					<c:forEach items="${loadData }" var="load">
			        	dataset.push({
			            id:"${load.id}",
			            pwd:"${load.pwd}",
			            name:"${load.name}",
			            level:"${load.level}",
			            desc:"${load.desc}",
			            time:"${load.reg_date}",
			        });
			    	</c:forEach>
			</script>

			<!-- component container -->
			<div id="widget" style="height: 500px; padding: 20px 20px 0;"></div>
			<div id="pagination" style="padding: 0 20px;"></div>

			<script>
				const grid = new dhx.Grid("widget", {
				    columns: [
				        { id: "id", autoWidth: true, header: [{ text: "ID" }] },
				        { id: "pwd", autoWidth: true, header: [{ text: "PASSWORD" }] },
				        { id: "name", autoWidth: true, header: [{ text: "NAME" }] },
				        { id: "level", autoWidth: true, header: [{ text: "LEVEL" }] },
				        { id: "desc", autoWidth: true, header: [{ text: "DESC" }] },
				        { id: "time", autoWidth: true, header: [{ text: "TIME" }] }
				    ]
				});
	
				grid.data.parse(dataset);
				
				const pagination = new dhx.Pagination("pagination", {
				    css: "dhx_widget--bordered dhx_widget--no-border_top",
				    data: grid.data,
				    pageSize: 10
				});
			</script>
			
			<form action="/user/dataLoad" method="get">
			
				<select name="keyWord">
					<option value="all" selected>전체</option>
		    		<option value="level">레벨</option>
		    		<option value="name">이름</option>
		    		<option value="id">아이디</option>
		    		<option value="password">비밀번호</option>
				</select>
				
				<input type="text" name="content">
				
				<input type="submit" value="조회">			
			</form>		
		
		</c:when>
	</c:choose>

</body>
</html>
