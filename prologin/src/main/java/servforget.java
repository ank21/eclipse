

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servforget
 */
public class servforget extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String un=request.getParameter("un");
		String hq=request.getParameter("hqe");
		String an=request.getParameter("ans");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ank", "root","ankit");
		java.sql.Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from users where uname='"+un+"' and hques='"+hq+"' and ans='"+an+"'");
		int rows = 0;
				rs.last();
				rows = rs.getRow();
				rs.beforeFirst();
		
		if(rows!=0) {
			response.sendRedirect("recover.html");
		}
		else
		{
			out.println("Wrong input try again");
		}
		
		
	} catch(Exception e) {
		out.println(e);
	}
	}

	

}
