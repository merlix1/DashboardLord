package dashboardlord;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class listenv
 */
@WebServlet("/listenv")
public class listenv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public listenv() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String clienthostname= request.getRemoteHost();

		InetAddress addr = InetAddress.getByName(clienthostname);
		String host = addr.getHostName();
		String user=Util.authenticate(host).getName();
		String id=Util.authenticateid(host);

		//load listenv data from JSON
		//ObjectMapper objectMapper = new ObjectMapper();
		//ListEnvData listenvdata = objectMapper.readValue(new File("C:/software/Tomcat/tomcat9/apache-tomcat-9.0.10/data/listenvironment.json"), ListEnvData.class);
		//List<Environment> listenv=listenvdata.getListEnv();

		PrintWriter out= response.getWriter();
				//.append("Served at: ").append(request.getContextPath());
		out.append("<html>\n");
		out.append("<head>\n");
		out.append("  <title>\n");
		out.append("  List Environment\n");
		out.append("  </title>\n");

		out.append("  <link rel='stylesheet' type='text/css' href='font/DashboardLord.css'>\n");
		out.append("\n");
		out.append("</head>\n");
		out.append("<body>");
		//out.append("Your IP is "+clienthostname);
		//out.append("Your hostname is "+host);
		out.append("<br>\n");
		out.append("Welcome "+user+", how can I serve you?");
		out.append("<br>\n");
		//out.append("This is a test4");
		out.append("");
		out.append("");

		//only merlx can manage allowed users
		if(id.equals("merlx"))
		{
			out.append("<br>\n");
			out.append("\n");
			out.append("\n");
			out.append("<button id='listuser' type='button'>List of Allowed User</button>\n");
			out.append("<script>\n");
			out.append("var listuser=document.getElementById('listuser');\n");
			out.append("listuser.addEventListener('click', function(){\n");
			out.append("	//window.open('edituser.html');\n");
			out.append("	location.href='AddUserServlet';\n");
			out.append("});\n");
			out.append("\n");
			out.append("</script>\n");
			out.append("<br>\n");





		}

		out.append("<br>\n");
		out.append("\n");
		out.append("<button id='editenv' type='button'>Edit environments</button>\n");
		out.append("<br>\n");
		out.append("<br>\n");
		out.append("<script>\n");
		out.append("var editenv=document.getElementById('editenv');\n");
		out.append("editenv.addEventListener('click', function(){\n");
		out.append("	//window.open('editenv.html');\n");
		out.append("	location.href='EditEnvServlet';\n");
		out.append("});\n");
		out.append("\n");
		out.append("</script>\n");
		out.append("<br>\n");
		out.append("\n");
		out.append("");
		out.append(" <table id=\"listenv\">\n");
		out.append("   <tr><th>Environment</th><th>Launch</th><th>URL</th><th>Private Note</th><th>Public Note</th><th>Owner</th><th>Public?</th></tr>\n");

		List<List<String>> listenvx=Controller.getInstance().getListEnvPublic(id);
	//	List<List<String>> listenvx=Controller.getInstance().getListEnv();
		if(listenvx!=null&&listenvx.size()>0)
		{



				for(int i=0;i<listenvx.size();i++)
				{
					List<String> record=listenvx.get(i);

					out.append("   <tr  id=\"pega74\">\n");
					//name
					out.append("     <td>"+record.get(0)+"</td>\n");
					out.append("	 <td><button name=\"url\" id=\"urlbutton\" type=\"button\">Launch</button></td>\n");
					//url
					out.append("	 <td>"+record.get(1)+"\n");

					//internal note
					if(id.equals(record.get(4)))
					{
					//out.append("	 <td>"+record.get(2)+"</td>\n");
					out.append("	 <td><textarea rows='4' cols='50' readonly> "+record.get(2)+"</textarea></td>\n");
					}
					else
					{
						out.append("	 <td>private</td>\n");
					}

					//external note
					//out.append("	 <td>"+record.get(3)+"</td>\n");
					out.append("	 <td><textarea rows='4' cols='50' readonly> "+record.get(3)+"</textarea></td>\n");

					//owner
					out.append("	 <td>"+record.get(4)+"</td>\n");
					out.append("	 <td>"+record.get(5)+"</td>\n");

					out.append("   </tr>\n");
				}
		}
		out.append(" ");
		out.append(" </table>\n");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("<script>");
		out.append("");




		//out.append("//var cell = document.getElementById(\"pega74\");");
		out.append("var listbuttonurl=document.getElementsByName(\"url\");\n");


		out.append("for (var i = 0, len = listbuttonurl.length; i < len; i++) {	\n");
		out.append("listbuttonurl[i].addEventListener(\"click\", function(){\n");
		out.append("	\n");
		//out.append("	//feching position of row then url in the table on same row.");
		out.append("	let posx=this.parentElement.parentElement.rowIndex;\n");
		out.append("	let url=document.getElementById(\"listenv\").rows[posx].cells[2].innerHTML;\n");
		out.append("");
		out.append("	window.open(url);\n");
		out.append("});\n");
		out.append("}	\n");


		out.append("</script>\n");
		out.append("");
		out.append(" </body>\n");
		out.append(" ");
		out.append("</html>\n");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
