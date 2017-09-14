

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlogin
 */
public class servlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ank", "root","ankit");
		java.sql.Statement st=con.createStatement();
		ResultSet resultSet;
		
		
	} catch(Exception e) {
		out.println(e);
	}
	}
}

