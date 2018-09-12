package dashboardlord;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
			//List<MyObject> readValue = mapper.readValue(jsonString, collectionType);
			//listuser = objectMapper.readValue(new File("C:/software/Tomcat/tomcat9/apache-tomcat-9.0.10/data/listuser.json"), collectionType);
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
			objectMapper.writeValue(new File("C:/software/Tomcat/tomcat9/apache-tomcat-9.0.10/data/listuser.json"), listuser);
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
