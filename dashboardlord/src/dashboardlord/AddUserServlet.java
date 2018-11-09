package dashboardlord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());


	//	request.getAttribute(arg0)

		PrintWriter out= response.getWriter();

		HashMap<String, String> listuser=Controller.getInstance().getListUser();

		out.append("<html>\n");
		out.append("<head>\n");
		out.append("  <title>\n");
		out.append("  List user\n");
		out.append("  </title>\n");
		out.append("  <link rel='stylesheet' type='text/css' href='font/DashboardLord.css'>\n");
		out.append("</head>\n");
		out.append("<body>List user6\n");
		out.append(" <form action='/dashboardlord/AddUserServlet' method='post'>\n");
		out.append("	<table id='listuser'>\n");
		out.append("	<tbody id='tuserbody'>\n");
		out.append("   <tr><th>User Id</th><th>User Name</th></tr>\n");


		for (Map.Entry<String, String> entry : listuser.entrySet()) {
		    String id = entry.getKey();
		    String name = entry.getValue();
		    // ...



		out.append("   <tr  id='pega74'>\n");
		out.append("	 <td> <input type='text' name='id' value='"+id+"'></td>\n");
		out.append("	 <td> <input type='text' name='name' value='"+name+"'></td>\n");
		out.append("	 <td><button name='removeuser' type='button'>Remove</button></td>\n");
		out.append("   </tr>\n");
		}

		out.append("   </tbody>\n");
		out.append("	</table>\n");
		out.append("  <td><button name='adduser' type='button'>Add User</button></td>\n");
		out.append("  <br>\n");
		out.append("  <input type='submit' value='Save'>\n");
		out.append("  </form> \n");
		out.append("<button id='listenv' type='button'>Return to list of environment</button>\n");
		out.append("<script>\n");
		out.append("var listuser=document.getElementById('listenv');\n");
		out.append("listuser.addEventListener('click', function(){\n");
		out.append("	//window.open('edituser.html');\n");
		out.append("	location.href='listenv';\n");
		out.append("});\n");
		out.append("\n");
		out.append("</script> \n");
		out.append("<script>\n");
		out.append("\n");
		out.append("var listbuttonremoveuser=document.getElementsByName('removeuser');\n");
		out.append("var numberrows=listbuttonremoveuser.length;\n");
		out.append("\n");
		out.append("for (var i = 0, len = listbuttonremoveuser.length; i < len; i++) {\n");
		out.append("console.log('in remove event loop');\n");
		out.append("	listbuttonremoveuser[i].addEventListener('click', \n");
		out.append("			function(){\n");
		out.append("				let posx=this.parentElement.parentElement.rowIndex;\n");
		out.append("				\n");
		out.append("				let parent=this.parentElement.parentElement.parentElement;\n");
		out.append("				console.log('parent'+parent.innerHTML);\n");
		out.append("				let child=parent.rows[posx];\n");
		out.append("				console.log('child'+child);\n");
		out.append("				parent.removeChild(child);\n");
		out.append("				}\n");
		out.append("				);\n");
		out.append("}\n");
		out.append("\n");
		out.append("var listbuttonadduser=document.getElementsByName('adduser');\n");
		out.append("for (var i = 0, len = listbuttonadduser.length; i < len; i++) {\n");
		out.append("	listbuttonadduser[i].addEventListener('click', \n");
		out.append("			function(){\n");
		out.append("				\n");
		//first element id
		out.append("				let id =document.createElement('input'); \n");
		out.append("				let att = document.createAttribute('id');\n");
		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='text';\n");
		out.append("				id.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='id';\n");
		out.append("				id.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='';\n");
		out.append("				id.setAttributeNode(att);\n");


		out.append("				let td1=document.createElement('td'); \n");
		out.append("				td1.appendChild(id); \n");
		out.append("				\n");
		out.append("				\n");
		out.append("				\n");


		//second element name of the row
		out.append("				let name=document.createElement('input'); \n");

		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='text';\n");
		out.append("				name.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='name';\n");
		out.append("				name.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='';\n");
		out.append("				name.setAttributeNode(att);\n");


		out.append("				let td2=document.createElement('td'); \n");
		out.append("				td2.appendChild(name);\n");
		out.append("				\n");
		// end row
		out.append("				\n");
		out.append("				\n");
		out.append("				let removeuser=document.createElement('button'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='removeuser';\n");
		out.append("				removeuser.setAttributeNode(att);\n");
		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='button';\n");
		out.append("				removeuser.setAttributeNode(att);\n");
		out.append("				let newContent = document.createTextNode('Remove'); \n");
		out.append("				removeuser.appendChild(newContent);\n");
		out.append("				removeuser.addEventListener('click', \n");
		out.append("			//removeenv()); duplicate code\n");
		out.append("			function(){\n");
		out.append("				let posx=this.parentElement.parentElement.rowIndex;\n");
		out.append("				\n");
		out.append("				let parent=this.parentElement.parentElement.parentElement;\n");
		out.append("				console.log('parent'+parent.innerHTML);\n");
		out.append("				let child=parent.rows[posx];\n");
		out.append("				console.log('child'+child);\n");
		out.append("				parent.removeChild(child);\n");
		out.append("				}\n");
		out.append("				);\n");
		out.append("				\n");
		out.append("				let td3=document.createElement('td'); \n");
		out.append("				td3.appendChild(removeuser);\n");
		out.append("				\n");
		out.append("				let tr=document.createElement('tr');\n");
		out.append("				tr.appendChild(td1);\n");
		out.append("				tr.appendChild(td2);\n");
		out.append("				tr.appendChild(td3);\n");
		out.append("					\n");
		out.append("				let child= document.getElementById('tuserbody').appendChild(tr);\n");
		out.append("								\n");
		out.append("				});\n");
		out.append("}\n");
		out.append("\n");
		out.append("</script>\n");
		out.append(" </body>\n");
		out.append(" </html>\n");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

	      Enumeration<String> paramNames = request.getParameterNames();

	      List<String> ids= new ArrayList<>();
	      List<String> names= new ArrayList<>();


	      HashMap<String,String> listuser=new HashMap<>();

	      while(paramNames.hasMoreElements()) {
	         String paramName = (String)paramNames.nextElement();
	       //  System.out.println();

	         System.out.println(paramName);

	         String[] paramValues = request.getParameterValues(paramName);




	         // Read single valued data
	         if (paramValues.length == 1) {
	            String paramValue = paramValues[0];
	            if (paramValue.length() == 0)
	            	System.out.println("No Value");
	               else
	            	   System.out.println("value:"+paramValue);

	         } else {
	            // Read multiple valued data
	        	 System.out.println("multiple values");
	        	 for(int i = 0; i < paramValues.length; i++) {
	        		 System.out.println("values" + paramValues[i]);
	        	//	 HashMap<String,String> listuser=new HashMap<>();
	        	//	 HashMap
	        		 if(paramName.equals("id"))
	    	         {
	    	        	 ids.add(paramValues[i]);
	    	         }
	        		 else if(paramName.equals("name"))
	        		 {
	        			 names.add(paramValues[i]);
	        		 }
	        	 }
	         }
	      }


	    // ids.forEach(action);
	     for(int i=0;i<ids.size();i++)
	     {
	    	 listuser.put(ids.get(i), names.get(i));

	     }
	     Controller controller=Controller.getInstance();
	     controller.doCall("adduser", listuser);


	     this.doGet(request, response);



	}

}
