package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.DBconnection;
import com.dao.StudentDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDAO dao=new StudentDAO(DBconnection.getcon());
		HttpSession session=req.getSession();
		boolean f=dao.deleteStudent(id);
		
		if(f) {
			session.setAttribute("succMsg", "Student Detail Deleted successfully...!!");
			resp.sendRedirect("index.jsp");
		//System.out.println("Student Detail Submit successfully...!!");	
		}
		else
		{
			session.setAttribute("errorMsg", "Student Detail Not Deleted successfully...!!");
			resp.sendRedirect("index.jsp");
		//	System.out.println("Student Detail Not Submit successfully...!!");	
		}
		
		
		
	}

	
	
	
}
