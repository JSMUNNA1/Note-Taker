<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
       
 <%@include file="alljs_cssBots.jsp" %>    
       
<meta charset="UTF-8">
<title>NoteTaker:Add Page</title>
</head>
<body class="b1">
  <div class="container">
 <%@include file="navbar.jsp" %>
    </div>
  <br>
  
  <h1 class="heding1">Add Note</h1>
  
   <div class="container text-center">
    <form action="saveNoteServlet" method="post">
   
  <div class="form-group 
 ">
    <label for="title">Note title</label>
    <input type="text"
    name="title"
     required="required" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter here">
    
  </div>
  <div class="form-group">
    <label for="content">Note content</label>
    <textarea  required="required"
    id="content" placeholder="Enter Your content"
      class="form-control" name="content"
      style="height:300px ;"></textarea>
  </div>
  
    <div class="container text-center">
    <button type="submit"  class="btn btn-primary">Add</button>
    </div>
   
</form>
 </div>
</body>
</html>