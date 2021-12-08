<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<!-- meta block -->
		<title>Form validation - DHTMLX Form</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
		
		<link rel="shortcut icon" href="/resources/common/favicon/favicon.ico" type="image/x-icon" />
		<link rel="icon" href="/resources/common/favicon/icon-16.png" sizes="16x16" />
		<link rel="icon" href="/resources/common/favicon/icon-32.png" sizes="32x32" />
		<link rel="icon" href="/resources/common/favicon/icon-48.png" sizes="48x48" />
		<link rel="icon" href="/resources/common/favicon/icon-96.png" sizes="96x96" />
		<link rel="icon" href="/resources/common/favicon/icon-144.png" sizes="144x144" />
		<!-- end meta block -->
		<script type="text/javascript" src="/resources/codebase/suite.js?v=7.2.5"></script>
		<link rel="stylesheet" href="/resources/codebase/suite.css?v=7.2.5">
		
		<link rel="stylesheet" href="/resources/common/index.css?v=7.2.5">
		<!-- custom sample head -->
		
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<body>
		<header class="dhx_sample-header">
			<div class="dhx_sample-header__main">
				<nav class="dhx_sample-header__breadcrumbs">
					<ul class="dhx_sample-header-breadcrumbs">
								<li class="dhx_sample-header-breadcrumbs__item">
									<a href="../index.html" class="dhx_sample-header-breadcrumbs__link">Back to Suite samples</a>
								</li>
							</ul>
				</nav>
				<h1 class="dhx_sample-header__title">
					<div class="dhx_sample-header__content">
						Login
					</div>
				</h1>
			</div>
		</header>
		<section class="dhx_sample-container">
			<div id="form" style="height: 100%; margin: 20px;"></div>
		</section>
		<script>
			const form = new dhx.Form("form", {
				css: "dhx_widget--bordered",
				padding: 40,
				width: 600,
				rows: [
					{
						type: "input",
						label: "ID",
						id:"ID",
						placeholder: "ID를 입력해주세요!",
						required : true,
						validation: function(value) {
							return idValid();
						},
						errorMessage: "Invalid id",
						successMessage: "Correctly",
						preMessage: "At least 6 characters",
						name: "id",
					},
					{
						type: "input",
						id:"pw",
						inputType:"password",
						label: "Password",
						placeholder: "패스워드를 입력해주세요!",
						required : true,
						errorMessage: "Invalid password",
						successMessage: "Valid password",
						validation: function(value){
							return pwValid();
						},
						name: "pwd",
					},
					{
						type: "checkbox",
						text: "I agree",
						value: "checkboxvalue",
					},
					{
						type: "button",
						name: "loginBtn",
						id:"btn",
						disabled:true,
						text: "login",
						submit: true,
						size: "medium",
						view: "flat",
						color: "primary",
						
					},
				]
			});
				
			const id1=form.getItem("id");
			const pass=form.getItem("pwd");
			const btn=form.getItem("loginBtn");
			
			function idValid(){
				var id=document.getElementById("ID").value;
				if(id.length>=1){
					return true;
				}
			}
			
			function pwValid(){
				var pw=document.getElementById("pw").value;
				if(pw.length>=1){
					return true;
				}
			}
			
			id1.events.on("input",function(value){
				id1.validate(false,value);
			});
			
			pass.events.on("input",function(value){
				pass.validate(false,value);
			});
		
			form.events.on("blur",function(){
				if(idValid() && pwValid()){
					btn.enable();
				}else {
					btn.disable();
				}
			});
			
			btn.events.on("click",function(){
				logincheck();
			});
			
			function logincheck(){
				var loginData=JSON.stringify(form.getValue());	//유저가 폼에 입력한 벨류를 제이슨문자열로 변환
				$.ajax({
					url:'/user/signin',
					type:"post",
					dataType:"json",
					contentType:'application/json; charset=utf-8',
					data:loginData,
					success:function(data){
						if(data==1){	//반환된 데이터가 1이라면(아이디와 패스워드가 매핑이 됐다면) 로그인 완료와 함께 홈화면과 DB에있는 데이터들을 전부보여준다.
							alert("로그인되었습니다.");
							location.href='/user/dataLoad';
						}else{	//반환된 데이터가 1이 아니라면(아이디와 패스워드가 매핑이 안됐을때) 경고창을 띄워준다.
							alert("아이디 혹은 비밀번호가 틀렸습니다.");
						}
					}
				});
			}
				
		</script>
		
			
	</body>
</html>