<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/header.jsp"%>
<link rel="stylesheet" href="${path}/resources/css/fileupload.css">
<head>
<title>EzenTour</title>
	
	<script>
	$(function() {
	    $("#cancel").click(function() {
	        if(confirm("취소하시겠습니까?")) {
	            document.writeForm.action="${path}/board/main";
	            document.writeForm.submit();
	        }
	    });
	})
	
	$(document).ready(function(){
		var fileTarget = $('.filebox .upload-hidden'); 

		fileTarget.on('change', function(){ // 값이 변경되면
			if(window.FileReader){ // modern browser 
				var filename = $(this)[0].files[0].name; 
			} else { // old IE 
			var filename = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출 
			} 
		
			// 추출한 파일명 삽입 
			$(this).siblings('.upload-name').val(filename);
		}); 
	}); 
	
	$(document).ready(function() {
		$("#btncancel").click(function() {
			$("form").each(function() {
				if(this.id == "fileForm") this.reset();
			});
		});
	});
	</script>
</head>
<body>
	
	<%@ include file="../include/menu.jsp"%>
	
	<!-- Breadcrumb Area Start -->
	<div class="breadcrumb-area bg-img bg-overlay jarallax"
	    style="background-image: url(${path}/resources/img/bg-img/16.jpg);">
	    <div class="container h-100">
	        <div class="row h-100 align-items-center">
	            <div class="col-12">
	                <div class="breadcrumb-content text-center">
	                    <h1 class="h1-title">자유게시판</h1>
	                    <nav aria-label="breadcrumb">
	                        <ol class="breadcrumb justify-content-center">
	                            <li class="breadcrumb-item"><a href="${path}">Home</a></li>
	                            <li class="breadcrumb-item">자유게시판</li>
	                        </ol>
	                    </nav>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- Breadcrumb Area End -->
	
	
	<!-- BoardForm Start -->
	<div class="row d-flex justify-content-center">
	<div class="roberto-rooms-area section-padding-100-0">
	    <div class="container">
	        <div class="row">
	            <div class="col-12">
	
					<!-- Background Start -->
					<br><br>
					<div class="row d-flex justify-content-center">
					<div style="width:1200px;">
					<div class="newsletter-form">    
	
			            <form action="" name="writeForm" method="post">
			                <div class="form-group">
			                    <label for="exampleFormControlInput1">제목</label>
			                    <input type="text" class="form-control" id="exampleFormControlInput1" name="title" placeholder="제목을 작성해주세요.">
			                </div>
			                <div class="form-group">
			                    <label for="exampleFormControlTextarea1">내용</label>
			                    <textarea class="form-control" id="exampleFormControlTextarea1" name="contents" rows="10"></textarea>
			                </div>
			            </form>
			            
			            <!-- fileUpload부분, 지우려면 css/fileupload.css도 같이 지우기-->
			            <form name="fileForm" id="fileForm">
			                <div class="filebox">
			                	<input class="upload-name" disabled="disabled">
			                	<label for="ex_filename">파일첨부</label>
			                	<label class="upload-cancel" id="btncancel">취소</label>
			                	<input type="file">
			                	<input type="file" class="upload-hidden" id="ex_filename" value="파일첨부">
			                </div>
			            </form>
			            
					</div>
				</div>
			</div><br><br>
			<!-- BackGround End -->
	
	        <div class="col-12" >
	         	<div class="welcome-text text-center">
	            	<input type="submit" class="btn roberto-btn w-10" value="등록" />&nbsp;
	                <input type="button" class="btn roberto-btn w-10" value="취소" id="cancel"/>
	            </div>
	        </div>
		</div>
		</div>
		</div>
	</div>
	</div><br><br>
	
	<!-- BoardForm End -->
	
	<%@ include file="../include/footer.jsp"%>  

</body>
</html>