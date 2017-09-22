<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
   <!-- 헤더부분 -->
   <jsp:include page="../inc/header.jsp"/> <!-- 개쩐다 이게바로 집중화구나 -->
   
   <!-- visual 부분 -->
   <jsp:include page="inc/visual.jsp" />
   
   <div id = "body" class="clearfix">
      <div class="content-container clearfix">
   
   <!-- 어사이드 -->
   <jsp:include page="inc/aside.jsp"/>
   
         <main id="main">
         	<h2>회원가입</h2>

         <div>
            <h3>경로</h3>
            <ol>
               <li>home</li>
               <li>회원정보</li>
               <li>회원가입</li>
            </ol>
         </div>
         
         <form action="join" method="post">
         <fieldset>
            <legend>회원정보</legend>
            <table>
               <tbody>
                  <tr>
                     <th><label>아이디</label></th>
                     <td>
                        <input name="id" value=""/>
                        <a target="_blank" href="check-id">중복확인</a>                      
                        <span></span>
                     </td>
                  </tr>
                  <tr>
                     <th><label>비밀번호</label></th>
                     <td><input name="pwd" /></td>
                  </tr>
                  <tr>
                     <th><label>비밀번호 확인</label></th>
                     <td><input name="ppwd" /></td>
                  </tr>
                  <tr>
                     <th><label>이름</label></th>
                     <td><input name="name"  value=""/></td>
                  </tr>
                  <tr>
                     <th><label>필명</label></th>
                     <td><input name="nicname" /></td>
                  </tr>
                  <tr>
                     <th><label>성별</label></th>
                     <td>
                        <select name="gender">
                           <option>선택</option>
                           <option>남성</option>
                           <option>여성</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <th><label>생년월일</label></th>
                     <td>
                        <input name="birthday" />년<input name="birthday" />월<input name="birthday" />일
                        <input type="radio" name="is-lunar" value="no"/>양력
                        <input type="radio" name="is-lunar" value="yes"/>음력
                     </td>
                  </tr>
                  <tr>
                     <th><label>핸드폰번호</label></th>
                     <td><input name="phone" /></td>
                  </tr>
                  <tr>
                     <th><label>이메일</label></th>
                     <td><input name="email" /></td>
                  </tr>
                  <tr>                     
                     <td><input type="submit" name="btn" value="확인" /></td>
                  </tr>
               </tbody>
            </table>
         </fieldset>
      </form>        
      </div>
     </div>
      
      <!-- 푸터부분 -->
      <jsp:include page="../inc/footer.jsp"/>

</body>
</html>