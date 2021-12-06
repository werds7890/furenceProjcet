<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- meta block -->
<title>All Form controls - DHTMLX Form</title>
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
<script type="text/javascript" src="/resources/codebase/suite.js?v=7.2.5"></script>
<link rel="stylesheet" href="/resources/codebase/suite.css?v=7.2.5">

<link rel="stylesheet" href="/resources/common/index.css?v=7.2.5">
<!-- custom sample head -->

<!-- custom styles -->
<style>
.social-networks {
	font-size: 0;
	line-height: 0;
	text-align: center;
	width: 100%;
	display: inline-block;
	box-sizing: border-box;
}

.social-network {
	display: inline-block;
	vertical-align: middle;
	line-height: 0;
	margin-left: 13px;
}

.social-network__icon {
	height: 28px;
	width: 28px;
}

.social-network__icon.line {
	fill: #0288d1;
}

.social-network__icon.white-line {
	fill: #fff;
}
</style>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	

</head>
<body>
	<header class="dhx_sample-header">
		<div class="dhx_sample-header__main">
			<nav class="dhx_sample-header__breadcrumbs">
				<ul class="dhx_sample-header-breadcrumbs">
					<li class="dhx_sample-header-breadcrumbs__item"><a
						href="../index.html" class="dhx_sample-header-breadcrumbs__link">Back
							to Suite samples</a></li>
				</ul>
			</nav>
			<h1 class="dhx_sample-header__title">
				<div class="dhx_sample-header__content">All Form controls</div>
			</h1>
		</div>
	</header>
	<section class="dhx_sample-container">
		<div id="form"></div>
	</section>
	<script>
		const form = new dhx.Form("form", {
			css : "dhx_widget--bordered",
			padding : 40,
			width : 600,
			rows : [ {
					name : "id",
					id : "rid",
					type : "input",
					label : "ID",
					value : "",
					validation : function(value) {
						return idValid();
					},
					errorMessage : "invalid Id",
					successMessage : "Correctly",
					icon : "dxi dxi-magnify",
					labelWidth : 140,
					required : true,
					placeholder : "ID를 입력해주세요",
				}, {
					name : "pwd",
					id : "rpw",
					inputType : "password",
					type : "input",
					value : "",
					validation : function(value) {
						return pwValid();
					},
					errorMessage : "invalid Password",
					successMessage : "Correctly",
					label : "password",
					icon : "dxi dxi-magnify",
					labelWidth : 140,
					required : true,
					placeholder : "password를 입력해주세요",
				}, {
					name : "name",
					id : "searchname",
					type : "input",
					label : "name",
					value : "",
					validation : function(value) {
						return nameValid();
					},
					errorMessage : "invalid Name",
					successMessage : "Correctly",
					icon : "dxi dxi-magnify",
					labelWidth : 140,
					required : true,
					placeholder : "name을 입력해주세요",
				}, {
					name : "level",
					type : "select",
					label : "Level",
					labelWidth : 140,
					id : "lev",
					errorMessage : "invalid level",
					successMessage : "Correctly",
					validation : function(value) {
						return levelValid();
					},
					value : "",
					required : true,
					options : [ {
						value : "",
						content : ""
					}, {
						value : "A",
						content : "A"
					}, {
						value : "B",
						content : "B"
					}, {
						value : "C",
						content : "C"
					}, {
						value : "D",
						content : "D"
					} ]
				}, {
					name : "desc",
					id : "descchk",
					type : "textarea",
					label : "desc",
					helpMessage : "Help information",
					required : true,
					errorMessage : "invalid desc",
					successMessage : "Correctly",
					labelWidth : 140,
					validation : function(value) {
						return descValid();
					},
					value : "",
				}, {
					id : "datechk",
					name : "reg_date",
					type : "datepicker",
					label : "date",
					dateFormat : "20%y-%m-%d",
					required : true,
					labelWidth : 140,
					disabledDates : function(datel) {
						var max = new Date();
						return max <= datel;
					},
				}, {
					align : "end",
					cols : [ {
						id : "btnchk",
						name : "button",
						disabled : true,
						type : "button",
						submit : true,
						text : "register",
						size : "medium",
						view : "flat",
						color : "primary",
					} ]
				} ]
			});

		function idValid() {
			var id = document.getElementById("rid").value;
			const chk = /^(?=.*[a-zA-Z])(?=.*[0-9]).{4,16}$/;
			if (chk.test(id)) {
				return true;
			}
		}

		function pwValid() {
			var pw = document.getElementById("rpw").value;
			const chk = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
			if (chk.test(pw)) {
				return true;
			}
		}

		function nameValid() {
			var namev = document.getElementById("searchname").value;
			if (namev && namev.length <= 128) {
				return true;
			}
		}

		function levelValid() {
			var level = document.getElementById("lev").value;
			if (level != "") {
				return true;
			}
		}

		function descValid() {
			var desc = document.getElementById("descchk").value;
			if (desc && desc.length <= 256) {
				return true;
			}
		}

		const idchk = form.getItem("id");
		const pass = form.getItem("pwd");
		const name = form.getItem("name");
		const level = form.getItem("level");
		const desc = form.getItem("desc");
		const date = form.getItem("reg_date");
		const btn = form.getItem("button");

		pass.events.on("input", function(value) {
			pass.validate(false, value);
		});

		idchk.events.on("input", function(value) {
			idchk.validate(false, value);
		});

		name.events.on("input", function(value) {
			name.validate(false, value);
		});

		level.events.on("input", function(value) {
			level.validate(false, value);
		});

		desc.events.on("input", function(value) {
			desc.validate(false, value);
		});

		form.events.on("blur", function() {
			if (idValid()&&pwValid()&&nameValid()&&levelValid()&&descValid()) {
				btn.enable();
			}
		});

		btn.events.on("click", function() {
			datasend();
		});

		function datasend() {
			var datachk = JSON.stringify(form.getValue());
			console.log(datachk);
			$.ajax({
				url : '/user/siginup',
				type : "post",
				dataType : "json",
				contentType: 'application/json; charset=utf-8',
				data : datachk,
				success : function(data) {
					if(data==1){
						alert("회원가입성공!");
						location.href='signin';
					}else if(data==0){
						alert("회원가입 실패!");
					}
				}
			});
		}
	</script>

</body>
</html>