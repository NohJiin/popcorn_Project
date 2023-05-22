<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
 $(function() {
		$('.num').click(function() {
			//alert($(this).text())
			$.ajax({
				url : "bbs_all_List", //views/bbs_all_List.jsp가 결과!
				data : {
					page : $(this).text()
				},
				success : function(result) { //결과가 담겨진 table부분코드
					$('.board_list').html(result)
				},
				error : function() {
					alert('실패.@@@')
				}
			}) //ajax
		})
	}) 
		
	/* $(function() {
		   $('.title a').click(function(event) {
			    event.preventDefault(); // a 태그 기본 동작 취소   
		    	$.ajax({
		        url: "detail_post",
		        data: { 
		            bbs_no: $(this).text()
		        },
		        success: function(result) {
		            $('.board_wrap').html(result);
		        },
		        error: function() {
		            alert('실패.@@@');
		        }
		    })
		  })
		}) */
		
		/* $('.title').siblings('a').click(function(event) { // event인 것을 받아와야 합니다.
  event.preventDefault(); // a 태그 기본 동작 취소
  var bbs_no = parseInt($(this).parent().parent().siblings('.num').text()); // bbs_no 값을 가져옴
  $.ajax({
    url: 'detail_post',
    data: { 
      bbs_no: bbs_no 
    },
    success: function(result) { //반응가 반전진 테이블부분코드
      $('.board_list').html(result);
    },
    error: function() {
      alert('실패.@@@');
    }
  }); //ajax 
}); */
	
</script>
<style>
td {
	background: white;
	height: 30px;
}

#paging_result {
	padding-bottom: 10px;
	background: #f7f7f7;
	border-radius: 45px 45px 45px 45px;
}
</style>
<link rel="stylesheet" href="resources/css/css.css">

</head>
<body>
 <div id="paging_result">
	<div class="board_wrap">
		<div class="board_title">
			<strong>전체 게시판</strong>
			<p>게시물 전체를 볼 수 있습니다.</p>
		</div>
		<div class="board_list_cnt">
			<p>
				전체 : <span class="board_list_cnt_highlight">${count}</span>개
			</p>
			<div>
				<div class="board_list_wrap">
					<div class="board_list">
						<div class="top">
							<div class="num">번호</div>
							<div class="title">제목</div>
							<div class="writer">글쓴이</div>
							<div class="date">작성일</div>
							<div class="count">조회</div>
						</div>
						<c:forEach items="${list}" var="one">
							<div>
								<div class="num">${one.bbs_no}</div>
								<div class="title">
									<a href="detail_post?bbs_no=${one.bbs_no}">${one.bbs_title}</a>
								</div>
								<div class="writer">${one.user_id}</div>
								<div class="date">${one.bbs_date}</div>
								<div class="count">${one.bbs_hit}</div>
							</div>
						</c:forEach>
					</div>

					<div class="board_page">
						<a href="#" class="bt first"><<</a> <a href="#" class="bt prev"><</a>
						<%
							int pages = (int) request.getAttribute("pages");
						for (int p = 1; p <= pages; p++) {
						%>
						<a href="#" class="num"><%=p%></a>
						<%
							}
						%>
						<a href="#" class="bt next">></a> <a href="#" class="bt last">>></a>
					</div>
					<div class="bt_wrap">
						<a href="write.html" class="on">등록</a>
						<!--<a href="#">수정</a>-->
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>