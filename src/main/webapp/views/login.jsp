<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
        
<meta charset="UTF-8">
<title>Đăng Nhập</title>
</head>

<body>
	<div class="container">
		<div class="login-form">
			<div class="d-flex justify-content-center h-100">
				<div class="card">
					<div class="card-header">

						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">
								<strong>Note!</strong> ${message}
							</div>
						</c:if>
						<div class="d-flex justify-content-end social_icon">
							<span><i class="fab fa-facebook-square"></i></span> <span><i
								class="fab fa-google-plus-square"></i></span> <span><i
								class="fab fa-twitter-square"></i></span>
						</div>
					</div>
					<div class="card-body">
						<form action="<c:url value='/dang-nhap'/>" id="formLogin"
							method="post">

							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" placeholder="username"
									id="userName" name="userName">
							</div>
							
							
							<div class="input-group form-group" id="show_hide_password">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								     
								<input type="password" class="form-control" placeholder="password" id="myInput" name="password" style=" border-bottom-right-radius: 5px ; border-top-right-radius: 5px" >
                                <div class="show_eyes" >
                                <a href="#"><i class="fa fa-eye-slash " aria-hidden="true" style="color: black"></i></a>
                                </div>
                                     
                   			</div>
                   			
                   			
							<div class="row align-items-center remember">
								<input type="checkbox">Remember Me
							</div>
							<input type="hidden" value="login" name="action" />
							<div class="form-group">
								<button type="submit" class="btn float-right login_btn">Login</button>
							</div>
						</form>
					</div>
					<div class="card-footer">
						<div class="d-flex justify-content-center links">
							Don't have an account?<a href='<c:url value="/dang-ky?action=register"/>'>Sign Up</a>
						</div>
						<div class="d-flex justify-content-center">
							<a href="#">Forgot your password?</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$(document).ready(function() {
	    $("#show_hide_password a").on('click', function(event) {
	        event.preventDefault();
	        if($('#show_hide_password input').attr("type") == "text"){
	            $('#show_hide_password input').attr('type', 'password');
	            $('#show_hide_password i').addClass( "fa-eye-slash" );
	            $('#show_hide_password i').removeClass( "fa-eye" );
	        }else if($('#show_hide_password input').attr("type") == "password"){
	            $('#show_hide_password input').attr('type', 'text');
	            $('#show_hide_password i').removeClass( "fa-eye-slash" );
	            $('#show_hide_password i').addClass( "fa-eye" );
	        }
	    });
	});
</script>
</body>
</html>