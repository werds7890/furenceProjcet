<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="utf-8">
<head>
	<title>Home</title>
	
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
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
	
	<script>
		function successLoad(){
				
			$.ajax({
				url:'fileLoad',
				type:'get',
				dataType:"json",
				success:function(data){
					
				}
			});
		}
		
	</script>
	
</head>


				<!-- let str = "<table align='center' border='1'>";
					str += "<tr>" +
					"<th>ID</th><th>PW</th>"+
					"<th>NAME</th><th>LEVEL</th>"+
					"<th>DESC</th><th>REG_DATE</th></tr>";
					$.each(data, function(i,item){
						str += "<tr>";
						str += "<td>" + item.id + "</td>";
						str += "<td>" + item.pwd+ "</td>";
						str += "<td>" + item.name + "</td>";
						str += "<td>" + item.level + "</td>";
						str += "<td>" + item.desc + "</td>";
						str += "<td>" + item.reg_date + "</td></tr>";
					});
					str += "</table>";
					 $("#userList").html(str);	 -->		
							
							






<body>

	<form action="uploadfile" method="post" enctype="multipart/form-data" id="chkid">
		<input type="file" name="uploadFile" id="idd">
		<input type="button" value="파일업로드" onclick="filechk()">
	</form>
	
	<c:set var="suc" value="${filevo.success }" />
	<c:set var="fail" value="${filevo.fail }" />
	<c:set var="total" value="${filevo.total }" />
	
	<c:choose>
		<c:when test="${total==suc}">
			<h1>전체성공!</h1>
			<h2>총 데이터 : ${total }</h2>
			<h2>${suc } 건 성공</h2>
			<input type="button" value="조회하기" onclick="successLoad()">
		</c:when>
	</c:choose>
	
<table border="1">
	<c:choose>
		<c:when test="${total!=suc}">
			<h3>성공 :${suc } 건</h3>
			<h3>실패 :${fail } 건</h3>
			<th>key</th>
			<th>value</th>
				<c:forEach var="entry" items="${filevo.map}">
					<tr>
						<td>${entry.key }</td>
						<td>${entry.value }</td>
					</tr>			
				</c:forEach>
		</c:when>
	</c:choose>
	<div id="userList">
	
	</div>
</table>

	
</body>
</html>
