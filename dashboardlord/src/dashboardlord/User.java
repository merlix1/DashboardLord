package dashboardlord;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class User {

	//private static List<User> listuser=new ArrayList<User>();
	private static List<User> listuser;
	public static User anonymous=new User("none","anonymous");

	static{

		ObjectMapper objectMapper = new ObjectMapper();
		//ListEnvData listenvdata;
		try {

			JavaType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, User.class);
			
			
			File datafolder = new File(Config.datapath);
			if(!datafolder.exists()) { 
				new File(Config.datapath).mkdirs();
			}
			File listuserfile=new File(Config.datapath+"listuser.json");
			listuserfile.createNewFile();
			if(listuserfile.length()==0)
			{
				//User dummy=new User("dummy","dummy");
				HashMap <String,String> listuserhash=new HashMap();
				listuserhash.put("dummy", "dummy");
				
			    Controller controller=Controller.getInstance();
			     controller.doCall("adduser", listuserhash);
				
			}
			
			
			
			
			
			listuser = objectMapper.readValue(new File(Config.datapath+"listuser.json"), collectionType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String id;
	private String name;

	public User()
	{

	}

	public User(String id, String name)
	{
		this.id=id;
		this.name=name;

	}

	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}

	public static void setListUser(List<User> listuser){
		User.listuser=listuser;

		ObjectMapper objectMapper = new ObjectMapper();
		//Car car = new Car("yellow", "renault");
		try {
			objectMapper.writeValue(new File(System.getProperty("catalina.home")+"/data/listuser.json"), listuser);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<User> getListUser()
	{

		return listuser;
	}


}
