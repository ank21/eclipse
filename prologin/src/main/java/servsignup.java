

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servsignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fn=request.getParameter("fn");
		String ln=request.getParameter("ln");
		String unm=request.getParameter("unm");
		String pwd=request.getParameter("pwd");
		String hqe=request.getParameter("hqe");
		String ans=request.getParameter("ans");
		try {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ank", "root","ankit");
		java.sql.Statement st=con.createStatement();
	
		st.execute("insert into users values ('"+fn+"','"+ln+"','"+unm+"','"+pwd+"','"+hqe+"','"+ans+"')");	
		out.println("<h1>Account created succesfully");
		
		
	}catch(Exception e)
	{out.println(e);}
			
	}	
	}

