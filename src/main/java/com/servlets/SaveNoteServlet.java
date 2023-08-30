package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.*;

import com.entity.Note;
import com.helper.FectoryProvider;

@WebServlet("/saveNoteServlet")
public class SaveNoteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//title,content fetch
		String title  =	req.getParameter("title");
		String content	=req.getParameter("content");
		
		Note note=new Note( title,content, new Date());
		
		
		
		Session session=	FectoryProvider.getFactory().openSession();
	     Transaction tx=session.beginTransaction();
		
	     session.save(note);
		
	     
	     tx.commit();
	     session.close();
	     resp.setContentType("text/html");
	   
	     
	     PrintWriter out=resp.getWriter();
	     out.print("<h1 style='text-align:center;'>Note is added is Successfully</h1>");
	     out.print("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all</a></h1>");
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	

}
