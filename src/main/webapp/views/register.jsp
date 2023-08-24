
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Ký</title>
</head>
<body>
  
    
	<div class="container">
		<div class="register-form">
			<div class="d-flex justify-content-center h-100">						          
				<div class="card">
				 
					<div class="card-header">
					</div>
					 <c:if test="${not empty message}">
					<c:choose>
                     <c:when test="${message.equals('Create Account Success')}">
                         <p class="cssblue">
								<strong></strong> ${message}
							</p>
                     </c:when>
                     <c:otherwise>
                     <p class="cssalert">
								<strong>Note!</strong> ${message}
					</p>
                      </c:otherwise>                    
                      </c:choose>
							
						</c:if>	
						
						
										
					<div class="card-body">
						<form action="<c:url value='/dang-ky'/>" id="formRegister" method="post">						
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" placeholder="userName"
									id="userName" name="userName">
									
							</div>
							
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" placeholder="fullName"
									id="fullname" name="fullName" >
							</div>
							
							<div class="input-group form-group" id="show_hide_password">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								     
								<input type="password" class="form-control" placeholder="password" id="password"  name="password" style=" border-bottom-right-radius: 5px ; border-top-right-radius: 5px" >
                                <div class="show_eyes" >
                                <a href="#"><i class="fa fa-eye-slash " aria-hidden="true" style="color: black"></i></a>
                                </div>
                                     
                   			</div>
                   			
                   			<div class="input-group form-group" id="show_hide_password1">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								     
								<input type="password" class="form-control" placeholder="Confirm password" id="confirm_password" name="confirm_password" style=" border-bottom-right-radius: 5px ; border-top-right-radius: 5px" >
                                <div class="show_eyes" >
                                <a href="#"><i class="fa fa-eye-slash " aria-hidden="true" style="color: black"></i></a>
                                </div>       
                   			</div>
                   			<p id="message"></p>
                   			
                   			
						
							<input type="hidden" value="register" name="action" />
							<div class="form-group">
								<button type="submit"  class="btn float-right login_btn">Sign-Up</button>
							</div>
						</form>
						
						<div class="back-login">
							<a href="/dang-nhap?action=login">Cancel</a>
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
	
	$(document).ready(function() {
	    $("#show_hide_password1 a").on('click', function(event) {
	        event.preventDefault();
	        if($('#show_hide_password1 input').attr("type") == "text"){
	            $('#show_hide_password1 input').attr('type', 'password');
	            $('#show_hide_password1 i').addClass( "fa-eye-slash" );
	            $('#show_hide_password1 i').removeClass( "fa-eye" );
	        }else if($('#show_hide_password1 input').attr("type") == "password"){
	            $('#show_hide_password1 input').attr('type', 'text');
	            $('#show_hide_password1 i').removeClass( "fa-eye-slash" );
	            $('#show_hide_password1 i').addClass( "fa-eye" );
	        }
	    });
	});
	
</script>
</body>
</html>