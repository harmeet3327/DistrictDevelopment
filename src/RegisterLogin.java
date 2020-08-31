import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.MinistryDetails;
import dbpack.MyDBClass;

public class RegisterLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterLogin() {
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
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		MyDBClass dbOBJ=new MyDBClass();
		String query=request.getParameter("q");
		

		String strUsername=request.getParameter("username");
		String strMinistry=request.getParameter("ministry");
		String strPassword=request.getParameter("password");
		MinistryDetails ud=dbOBJ.checkUserLogin(strUsername, strPassword);
		HttpSession session=request.getSession(true);
		
		
		if(query.equals("lgn"))
		{
			if(ud!=null)
			{
				
				if(request.getParameter("remember")!=null)
				{
					Cookie cook=new Cookie("mySiteLogin", strUsername);
					cook.setMaxAge(60*60*24);
					response.addCookie(cook);
				}
				
				session=request.getSession();
				session.setAttribute("userSess", ud);
				RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			}
			
			else
			{
				response.sendRedirect("Login.jsp?msg=invalid");
			}
		}
	
	if (query.equals("reg"))
		{
			MinistryDetails user=new MinistryDetails();
			user.setUsername(strUsername);
			user.setMinistry(strMinistry);
			user.setPassword(strPassword);
			
			session=request.getSession();
			session.setAttribute("userSess", user);
			
			int i=dbOBJ.registerUser(user);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("register.jsp?msg=unsuccess");
			}
			
		}
	
		
				else if(query.equals("lgout"))
		{
			session=request.getSession(true);
			session.removeAttribute("userSess");
			session.invalidate();
			response.sendRedirect("logout.jsp");
		}
		
		

		
		
		
		out.flush();
		out.close();
		
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}


	
