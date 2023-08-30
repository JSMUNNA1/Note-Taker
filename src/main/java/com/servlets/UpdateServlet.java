package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Note;
import com.helper.FectoryProvider;


public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			String idString=req.getParameter("id");
			int id=Integer.parseInt(idString.trim());
			
			Session session=FectoryProvider.getFactory().openSession();
			Transaction tx=session.beginTransaction();
			  
			Note note=  (Note)session.get(Note.class, id);
			
			note.setContent(content);
			note.setTitle(title);
			
			
			tx.commit();
			session.close();
			
			resp.sendRedirect("all_notes.jsp");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
