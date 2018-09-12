package dashboardlord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Configservlet
 */
@WebServlet("/Configservlet")
public class Configservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Configservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out= response.getWriter();
		out.append("<html>\n");
		out.append("<head>\n");
		out.append("  <title>\n");
		out.append("  Application Settings\n");
		out.append("  </title>\n");

		out.append("  <link rel='stylesheet' type='text/css' href='font/DashboardLord.css'>\n");
		out.append("\n");
		out.append("</head>\n");
		out.append("<body>");

		out.append(" <form action='/dashboardlord/Configservlet' method='post'>\n");
		out.append("Set the path to the data folder:\n");

		out.append("	 <td> <input type='text' name='datapath' value='"+Config.datapath+"'></td>\n");

		out.append("  <input type='submit' value='Save'>\n");
		out.append("  </form> \n");

		out.append("</body>");
		out.append("</html>\n");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	      Enumeration<String> paramNames = request.getParameterNames();
	      while(paramNames.hasMoreElements()) {
		         String paramName = (String)paramNames.nextElement();
		       //  System.out.println();

		        // System.out.println(paramName);
		         if(paramName.equals("datapath"))
		         {

		        	 String[] paramValues = request.getParameterValues(paramName);
		        	 String newdatapath=paramValues[0];
		        	 Config.datapath=newdatapath;
		        	 System.out.println("Data path set to:"+newdatapath);
		         }


	      }

		doGet(request, response);
	}

}
