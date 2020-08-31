import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Admin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Admin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	doPost(request,response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
{

response.setContentType("text/html");
PrintWriter out = response.getWriter();
String query=request.getParameter("q");

String strEmail=request.getParameter("emailText");
String strPassword=request.getParameter("passwordText");

if(query.equals("lgn"))
{

	if(strEmail.equals("meet@gmail") && strPassword.equals("meetsingh"))
	{
	if(request.getParameter("remember")!=null)
	{
		Cookie cook=new Cookie("mySiteLogin", strEmail);
		cook.setMaxAge(60*60*5);
		response.addCookie(cook);
	}
	HttpSession session=request.getSession(true);
	session.setAttribute("userSess", strEmail);
	RequestDispatcher rd=request.getRequestDispatcher("myadmin.html");
	rd.forward(request, response);
	}
}	
else if(query.equals("lgout"))
{
	HttpSession session=request.getSession(true);
	session=request.getSession(true);
	session.removeAttribute("userSess");
	session.invalidate();
	response.sendRedirect("logout.jsp");
}
	
out.flush();
out.close();
}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
