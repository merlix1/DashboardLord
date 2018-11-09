package dashboardlord;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditEnvServlet
 */
@WebServlet("/EditEnvServlet")
public class EditEnvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEnvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String clienthostname= request.getRemoteHost();
		InetAddress addr = InetAddress.getByName(clienthostname);
		String hostname = addr.getHostName();
		//String owner= Util.authenticateowner(hostname);
		String id=Util.authenticateid(hostname);


		PrintWriter out= response.getWriter();

		out.append("<html>\n");
		out.append("<head>\n");
		out.append("  <title>\n");
		out.append("  List Environment1\n");
		out.append("  </title>\n");
		out.append("  <link rel='stylesheet' type='text/css' href='font/DashboardLord.css'>\n");
		out.append("</head>\n");
		out.append("<body>\n");
		out.append("<form action='/dashboardlord/EditEnvServlet' method='post'>\n");
		out.append("<table id='listenv'>\n");

		out.append("   <tr><th>Environment</th><th>Launch</th><th>URL</th><th>Private Note</th><th>Public Note</th><th>Owner</th><th>Is public?</th></tr>\n");


		System.out.println("id being used:"+id);
		List<List<String>> listenv=Controller.getInstance().getListEnvById(id);




		if(listenv!=null&&listenv.size()>0)
		{



				for(int i=0;i<listenv.size();i++)
				{
					List<String> record=listenv.get(i);

				out.append("   <tr  id='pega74'>\n");
				out.append("	 <td> <input type='text' name='name' value='"+record.get(0)+"'></td>\n");
				out.append("	 <td><button name='url' class='toto' id='urlbutton' type='button' disabled>Launch</button></td>\n");
				out.append("	 <td> <input type='text' name='url' value='"+record.get(1)+"'></td>\n");
				//out.append("	 <td> <input type='text' name='internalnote' value='"+record.get(2)+"'></td>\n");
				out.append("	 <td> <textarea rows='4' cols='50' name='internalnote'>"+record.get(2)+"</textarea></td>\n");
				//out.append("	 <td> <input type='text' name='externalnote' value='"+record.get(3)+"'></td>\n");
				out.append("	 <td> <textarea rows='4' cols='50' name='externalnote'>"+record.get(3)+"</textarea></td>\n");
				out.append("	 <td> <input type='text' name='owner' value='"+record.get(4)+"' readonly></td>\n");



				//out.append("	 <td> <input type='text' name='ispublic' value='"+record.get(5)+"'></td>\n");
				out.append("	<td><select name='ispublic'>\n");

				if(record.get(5).equals("true"))
				{
					out.append("		<option value='true' selected>true</option>\n");
					out.append("		<option value='false'>false</option>\n");
				}
				else
				{
					out.append("		<option value='true'>true</option>\n");
					out.append("		<option value='false' selected>false</option>\n");
				}

				out.append("	</select></td>\n");


				out.append("	 <td><button name='removeenv' type='button'>Remove</button></td>\n");
				out.append("   </tr>\n");
				}
		}
		out.append("  </table>\n");
		out.append("<br>\n");
		out.append("  <td><button name='addenv' type='button'>Add Environment</button></td>\n");
		out.append("  <br>\n");
		out.append("<br>\n");
		out.append("  <input type='submit' value='Save'>\n");
		out.append("  </form> \n");
		out.append("<br>\n");
		out.append("<br>\n");
		out.append("<button id='listenvbutton' type='button'>Return to list of environment</button>\n");
		out.append("<script>\n");
		out.append("var listenv=document.getElementById('listenvbutton');\n");
		out.append("listenv.addEventListener('click', function(){\n");
		out.append("	//window.open('edituser.html');\n");
		out.append("	location.href='listenv';\n");
		out.append("});\n");
		out.append("</script>\n");
		out.append("<script>\n");
		out.append("\n");
		out.append("var listbuttonremoveenv=document.getElementsByName('removeenv');\n");
		out.append("var numberrows=listbuttonremoveenv.length;\n");
		out.append("\n");
		out.append("console.log('start');\n");
		out.append("for (var i = 0, len = listbuttonremoveenv.length; i < len; i++) {\n");
		out.append("console.log('in remove event loop');\n");
		out.append("	listbuttonremoveenv[i].addEventListener('click', \n");
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
		out.append("var listbuttonaddenv=document.getElementsByName('addenv');\n");
		out.append("for (var i = 0, len = listbuttonaddenv.length; i < len; i++) {\n");
		out.append("console.log('add event');\n");
		out.append("	listbuttonaddenv[i].addEventListener('click', \n");
		out.append("			function(){\n");
		out.append("				\n");
		//////////////////
		out.append("				let name =document.createElement('input'); \n");
		out.append("				let att = document.createAttribute('name');\n");
		out.append("				att.value='name';\n");
		out.append("				name.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='text';\n");
		out.append("				name.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='';\n");
		out.append("				name.setAttributeNode(att);\n");


		out.append("				let td1=document.createElement('td'); \n");
		out.append("				td1.appendChild(name); \n");
		out.append("\n");

		////////////////////
		out.append("				let td2=document.createElement('td');				\n");
		out.append("				\n");

		///////////////////

		out.append("				let url =document.createElement('input'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='url';\n");
		out.append("				url.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='text';\n");
		out.append("				url.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='';\n");
		out.append("				url.setAttributeNode(att);\n");


		//out.append("				url.setAttributeNode(att);\n");
		out.append("				let td3=document.createElement('td'); \n");
		out.append("				td3.appendChild(url);\n");
		out.append("				\n");
		out.append("				\n");

		/////////////////

		//out.append("	 <td> <input type='text' name='internalnote' value='"+record.get(2)+"'></td>\n");
		//out.append("	 <td> <textarea rows='4' cols='50' name='internalnote'>"+record.get(2)+"</textarea></td>\n");


		out.append("				let internalnote =document.createElement('textarea'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='internalnote';\n");
		out.append("				internalnote.setAttributeNode(att);\n");


		out.append("				att = document.createAttribute('rows');\n");
		out.append("				att.value='4';\n");
		out.append("				internalnote.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('cols');\n");
		out.append("				att.value='50';\n");
		out.append("				internalnote.setAttributeNode(att);\n");



		out.append("				let td4=document.createElement('td'); \n");
		out.append("				td4.appendChild(internalnote);\n");
		out.append("				\n");
		out.append("				\n");
		////////////

		out.append("				let externalnote =document.createElement('textarea'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='externalnote';\n");
		out.append("				externalnote.setAttributeNode(att);\n");


		out.append("				att = document.createAttribute('rows');\n");
		out.append("				att.value='4';\n");
		out.append("				externalnote.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('cols');\n");
		out.append("				att.value='50';\n");
		out.append("				externalnote.setAttributeNode(att);\n");



		out.append("				let td5=document.createElement('td'); \n");
		out.append("				td5.appendChild(externalnote);\n");
		out.append("				\n");
		out.append("				\n");
		//////////////////
		out.append("				let owner =document.createElement('input'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='owner';\n");
		out.append("				owner.setAttributeNode(att);\n");


		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='text';\n");
		out.append("				owner.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='"+id+"';\n");
		out.append("				owner.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('readonly');\n");
		out.append("				owner.setAttributeNode(att);\n");


		out.append("				let td6=document.createElement('td'); \n");
		out.append("				td6.appendChild(owner);\n");
		out.append("				\n");
		out.append("				\n");

		//////////////////
	/*	out.append("				let ispublic =document.createElement('input'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='ispublic';\n");
		out.append("				ispublic.setAttributeNode(att);\n");


		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='text';\n");
		out.append("				ispublic.setAttributeNode(att);\n");

		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='';\n");
		out.append("				ispublic.setAttributeNode(att);\n");



		out.append("				let td7=document.createElement('td'); \n");
		out.append("				td7.appendChild(ispublic);\n");
		out.append("				\n");
		out.append("				\n");*/

		out.append("				let ispublic =document.createElement('select'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='ispublic';\n");
		out.append("				ispublic.setAttributeNode(att);\n");


		out.append("				let optiontrue=document.createElement('option'); \n");
		out.append("			 	optiontrue.innerHTML='true'; \n");
		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='true';\n");
		out.append("				optiontrue.setAttributeNode(att);\n");
		out.append("				ispublic.appendChild(optiontrue);\n");


		out.append("				let optionfalse=document.createElement('option'); \n");
		out.append("			 	optionfalse.innerHTML='false'; \n");
		out.append("				att = document.createAttribute('value');\n");
		out.append("				att.value='false';\n");
		out.append("				optionfalse.setAttributeNode(att);\n");
		out.append("				ispublic.appendChild(optionfalse);\n");




		out.append("				let td7=document.createElement('td'); \n");
		out.append("				td7.appendChild(ispublic);\n");
		out.append("				\n");
		out.append("				\n");



		//////////////////

		out.append("				let removeenv=document.createElement('button'); \n");
		out.append("				att = document.createAttribute('name');\n");
		out.append("				att.value='removeenv';\n");
		out.append("				removeenv.setAttributeNode(att);\n");
		out.append("				att = document.createAttribute('type');\n");
		out.append("				att.value='button';\n");
		out.append("				removeenv.setAttributeNode(att);\n");
		out.append("				let newContent = document.createTextNode('Remove'); \n");
		out.append("				removeenv.appendChild(newContent);\n");
		out.append("				removeenv.addEventListener('click', \n");
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
		out.append("				let td8=document.createElement('td'); \n");
		out.append("				td8.appendChild(removeenv);\n");
		out.append("							\n");
		out.append("				let tr=document.createElement('tr');\n");
		out.append("				tr.appendChild(td1);\n");
		out.append("				tr.appendChild(td2);\n");
		out.append("				tr.appendChild(td3);\n");
		out.append("				tr.appendChild(td4);\n");
		out.append("				tr.appendChild(td5);\n");
		out.append("				tr.appendChild(td6);\n");
		out.append("				tr.appendChild(td7);\n");
		out.append("				tr.appendChild(td8);\n");
		out.append("							\n");
		out.append("				let child= document.getElementById('listenv').appendChild(tr);\n");
		out.append("							\n");
		out.append("				});\n");
		out.append("}\n");
		out.append("</script>\n");
		out.append(" </body>\n");
		out.append(" </html>\n");




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//String name;
		//String url;
		//String howtostart;
		//String internalnote;
		//String externalnote;
		//String owner;

	      Enumeration<String> paramNames = request.getParameterNames();

	      List<String> names= new ArrayList<>();
	      List<String> urls= new ArrayList<>();
	      List<String> internalnotes= new ArrayList<>();
	      List<String> externalnotes= new ArrayList<>();
	      List<String> owner= new ArrayList<>();
	      List<String> ispublic= new ArrayList<>();
	      List<List<String>> listenvtable= new ArrayList<List<String>>();


	      HashMap<String,String> listuser=new HashMap<>();

	      while(paramNames.hasMoreElements()) {
	         String paramName = (String)paramNames.nextElement();
	       //  System.out.println();

	         System.out.println(paramName);
	         String[] paramValues = request.getParameterValues(paramName);

	         // Read single valued data
	      /*   if (paramValues.length == 1) {
	            String paramValue = paramValues[0];
	            if (paramValue.length() == 0)
	            	System.out.println("No Value");
	               else
	            	   System.out.println("value:"+paramValue);

	         }*/
	         //else {
	            // Read multiple valued data
	        	 System.out.println("multiple values, size:"+paramValues.length);
	        	 for(int i = 0; i < paramValues.length; i++) {
	        		// System.out.println("values" + paramValues[i]);
	        	//	 HashMap<String,String> listuser=new HashMap<>();
	        	//	 HashMap
	        		 if(paramName.equals("name"))
	    	         {
	    	        	 names.add(paramValues[i]);
	    	         }
	        		 else if(paramName.equals("url"))
	        		 {
	        			 urls.add(paramValues[i]);
	        		 }
	        		 else if(paramName.equals("internalnote"))
	        		 {
	        			 internalnotes.add(paramValues[i]);
	        		 }
	        		 else if(paramName.equals("externalnote"))
	        		 {
	        			 externalnotes.add(paramValues[i]);
	        		 }
	        		 else if(paramName.equals("owner"))
	        		 {
	        			 owner.add("merlx");
	        		 }
	        		 else if(paramName.equals("ispublic"))
	        		 {
	        			 ispublic.add(paramValues[i]);
	        		 }

	        	 }
	        // }
	      }

	      listenvtable.add(names);

	      for(int k=0;k<names.size();k++){
			    System.out.println("control of list of names: item "+k+":"+names.get(k));
			}

	      listenvtable.add(urls);
	      for(int k=0;k<urls.size();k++){
			    System.out.println("control of list of urls: item "+k+":"+urls.get(k));
			}

	      listenvtable.add(internalnotes);
	      for(int k=0;k<internalnotes.size();k++){
			    System.out.println("control of list of internalnotes: item "+k+":"+internalnotes.get(k));
			}
	      listenvtable.add(externalnotes);
	      for(int k=0;k<externalnotes.size();k++){
			    System.out.println("control of list of externalnotes: item "+k+":"+externalnotes.get(k));
			}
	      listenvtable.add(owner);

	      listenvtable.add(ispublic);


	     Controller controller=Controller.getInstance();

	    // Util.authenticate(hostname);
			String clienthostname= request.getRemoteHost();
			InetAddress addr = InetAddress.getByName(clienthostname);
			String hostname = addr.getHostName();
			//String user=Util.authenticate(host).getName();

	     controller.doCall("addenv", listenvtable,Util.authenticateid(hostname));


		doGet(request, response);
	}

}
