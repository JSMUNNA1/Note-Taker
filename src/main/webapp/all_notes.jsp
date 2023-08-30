<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.entity.*" %>
<%@page import="java.util.*" %>

<%@page import="com.helper.FectoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@include file="alljs_cssBots.jsp" %> 
<meta charset="UTF-8">
<title>All notes:Note Taker</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<br>
    <h1>All Notes:</h1>
    
    <div class="row">
    
     <div class="col-12">
     
      <%
      
      SessionFactory factory=new Configuration().configure().buildSessionFactory();
      
    Session s=  factory.openSession();

    Query q=s.createQuery("from Note");
     List<Note> li = q.list();
      for(Note note:li){
    	
    	 
    	//loop yaha start  
    %>
    <div class="card mt-3" >
    	  <img class="card-img-top pic" src="img/scrapbook.png" alt="Card image cap">
    	  <div class="card-body">
    	    <h5 class="card-title"><%=note.getTitle() %></h5>
    	    <p class="card-text">
    	    <%=note.getContent() %>
    	    </p>
    	    <p><b><%=note.getAddeDate() %></b></p>
    	    
    	    <a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
    	    <a href="Edit.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Edit</a>
    	  </div>
    	</div>
    
     
    
    <%
      }
      
      s.close();
     
    
    %>
     
   
    
    
    </div>
    </div>
   



</body>
</html>