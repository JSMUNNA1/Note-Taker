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


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int noteId=Integer.parseInt(request.getParameter("note_id").trim());
			Session session =FectoryProvider.getFactory().openSession();
			   Transaction tx=session.beginTransaction();
			Note n=(Note)session.get(Note.class, noteId);
			
			session.delete(n);
			tx.commit();
			session.close();
			response.sendRedirect("all_notes.jsp");
			
		} catch (Exception e) {

       e.printStackTrace();
		}
	
	}

	
	

}
