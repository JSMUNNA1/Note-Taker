<%@page import="org.hibernate.*" %>
<%@page import="com.entity.*" %>
<%@page import="com.helper.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="alljs_cssBots.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="navbar.jsp"%>

  <h1>Edit Notes!</h1>
  <%
     int noteId=Integer.parseInt(request.getParameter("note_id").trim());
  Session s =FectoryProvider.getFactory().openSession();
  //Transaction tx=s.beginTransaction();
  Note n=(Note)s.get(Note.class, noteId);
  
  
  
  

  
  
  
  %>
  
      <div class="container text-center">
    <form action="UpdateServlet" method="post">
   
  <div class="form-group 
 ">
    <label for="title">Note title</label>
    <input type="text"
    name="title"
     required="required" class="form-control" id="title" 
     aria-describedby="emailHelp" 
     placeholder="Enter here" value="<%=n.getTitle()%>">
    
  </div>
  <div class="form-group">
  
  <input type="hidden" name="id" value="<%=n.getId()%>">
  
    <label for="content">Note content</label>
    <textarea  required="required"
    id="content" placeholder="Enter Your content"
      class="form-control" name="content"
      
      style="height:300px ;"
      
      <%=n.getContent() %>
      ></textarea>
  </div>
  
    <div class="container text-center">
    <button type="submit"  class="btn btn-success">Update</button>
    </div>
   
</form>
 </div>
  
  
  
  

</body>
</html>