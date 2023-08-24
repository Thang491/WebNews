<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<meta charset="UTF-8">
<title>New detail</title>
</head>
<body>
   <div class="supper-container">
       <jsp:useBean id="now" class="java.util.Date" />
      <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="formattedDate"/>
    <p>Giờ hiện tại (GMT+7): ${formattedDate}</p>
  </div>
	<div class="row">
	 
 
		<div class="col-lg-9">
			<h1>${detail.title}</h1>
			<h3>${detail.shortDescription}</h3>
			<a >${detail.content}</a>
			
			
			
			<section style="background-color: #eee;">   
          <div class="card-footer py-3 border-0" style="background-color: #f8f9fa;">
            <div class="d-flex flex-start w-100">
              <img class="rounded-circle shadow-1-strong me-3"
                src="https://mdbcdn.b-cdn.net/img/Photos/Avatars/img%20(19).webp" alt="avatar" width="40"
                height="40" />
              <div class="form-outline w-100">
                <textarea class="form-control" id="textAreaExample"  placeholder="Viết bình luận..." rows="4"
                  style="background: #fff;"></textarea>
                
              </div>
            </div>
            
            <div class="buttoncss" >           
            <div class="float-end mt-2 pt-1 " >
              <button type="button" class="btn btn-primary btn-sm" style="margin-right: auto;">Post comment</button>
              <button type="button" class="btn btn-outline-primary btn-sm" style="margin-left: auto;">Cancel</button>
            </div>
          </div>
          
           </div>
          
</section>
         


		</div>		
		<div class="col-lg-3">
			<c:forEach var="item" items="${model}">
				 <a href="?id=${item.id}&action=detail"> <img
						class="card-img-top" src="${item.thumbnail}"
						style="width: 253px; height: 144px" alt=""></a>
					<div class="card-body">
						<h5 class="card-title">
							<a href="?id=${item.id}&action=detail">${item.title}</a>
					   </h5>
				</div>
			</c:forEach>
		</div>
		
		
	</div>
	
</body>
</html>