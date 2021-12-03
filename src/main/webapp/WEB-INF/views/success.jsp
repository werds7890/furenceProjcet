<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="utf-8">
<head>
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

	<form action="uploadfile" method="post" enctype="multipart/form-data" id="chkid">
		<input type="file" name="uploadFile" id="idd">
		<input type="button" value="파일업로드" onclick="filechk()">
	</form>
	
	<c:set var="total" value="${Filevo.total }" />
	<c:set var="suc" value="${Filevo.success }" />
	<c:set var="fail" value="${Filevo.fail }" />
	
	<c:choose>
		<c:when test="${total==suc}">
			<h1>전체성공!</h1>
			<h2>총 데이터 : ${total }</h2>
			<h2>${suc } 건 성공</h2>
			<input type="button" value="조회하기" onclick="">
		</c:when>
	</c:choose>
	
	<c:choose>
		<c:when test="${total!=suc}">
			<h3>성공 :${suc } 건</h3>
			<h3>실패 :${fail } 건</h3>
		</c:when>
	</c:choose>
	
	
	
	
</body>
</html>
