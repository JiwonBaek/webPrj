<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style.css" type="text/css" rel="stylesheet" />
</head>
<body>
   
   <!-- 헤더부분 -->
   <!-- jsp action tag -->
   <jsp:include page="../../inc/header.jsp" />


   <!--   비주얼부분 -->
   <jsp:include page="../inc/visual.jsp" />
 
   

   <div id="body" class="clearfix">
      <div class="content-container">      
      
         <!-- aside부분 -->
         <jsp:include page="../inc/aside.jsp" />
         
         <!-- <h1>고객센터</h1>
         
         <nav>
            <h1>고객센터 메뉴</h1>
            <ul>
               <li><a href="">공지사항</a></li>
               <li><a href="">1:1고객문의</li>
               <li><a href="">학습안내</li>
            </ul>
         </nav>
      
         <nav>
            <h1>추천사이트</h1>
            <ul>
               <li>앤서이즈</li>
               <li>W3C</li>
               <li>마이크로소프트</li>
            </ul>
         </nav>
         
         <nav>
            <h1>구글광고</h1>
         </nav> -->
        </aside>
        
        <main id="main">
         <h2>공지사항</h2>
         
         <div>
            <h3>경로</h3>
            <ol>
               <li>home</li>
               <li>고객센터</li>
               <li>공지사항</li>
            </ol>
         </div>
   	 <!-- 자세한 페이지 -->
       <form method="post"> <!-- form에 현재 url이랑 같아서 없어도 됨 -->              
	       <table border="1" class="table">
	            <tr>
		            <th>제목</th>
		            <td colspan="3"><input name="title" /></td>
	            </tr>
	             <tr>
		            <th>첨부파일</th>
		            <td colspan="3"></td>
	            </tr>
	            <tr>
	            	<td colspan="4">
	            	<textarea name="content"></textarea>
	            	</td>
	            </tr>
	            
	         </table>
	         
	         <div>
	         	<input type="submit" class="btn btn-default" value="등록" />
	         	<a href="list" class="btn btn-default">취소</a>
	         </div>
         </form>
      </main>   
      </div>
   </div>
   
   <!-- footer 부분 -->
	<jsp:include page="../../inc/footer.jsp"></jsp:include>
   
</body>
</html>