<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<div class="row">

		<div class="col-lg-3">

			<h1 class="my-4">Thể Loại</h1>
			<div class="list-group">
				<c:forEach var="item" items="${categories}">
					<tr>
						<td><a href="?id=${item.id}" class="list-group-item">${item.name}</a></td>
					</tr>
				</c:forEach>
			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid"
							src="https://www.denofgeek.com/wp-content/uploads/2020/07/One-Piece-Full-Cast-Header-Image.jpg?fit=2560%2C1440"
							style="width: 900px; height: 350px" alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid"
							src="https://img-cdn.2game.vn/pictures/images/2016/6/13/rautrang_13_6_2016_3.JPG"
							style="width: 900px; height: 350px" alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid"
							src="https://tse1.mm.bing.net/th?id=OIP.CpipLXaHEc5SIE5-D3aTegHaEK&pid=Api&P=0&h=180"
							style="width: 900px; height: 350px" alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<div class="row">				
					<c:forEach var="item" items="${model}">
						<div class="col-lg-4 col-md-6 mb-4">												
							<div class="card h-100">
								<a href="?id=${item.id}&action=detail" > <img class="card-img-top" src="${item.thumbnail}" style="width: 253px; height: 144px" alt=""></a>
									<div class="card-body" >
									
									 <h3 class="card-title"><a href="?action=detail&id=${item.id}">${item.title}</a></h3> 
                                      <p class="card-text"></p> 
                                    </div>                          
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
								</div>
						         		</div>							         						        
						</div>						
					</c:forEach>
				

			</div>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->
</body>
</html>