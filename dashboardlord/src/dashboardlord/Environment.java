package dashboardlord;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Environment {

	private static Set<Environment> listenv= new HashSet<Environment>();



	static{

		List<User> listuser=User.getListUser();
		ObjectMapper objectMapper = new ObjectMapper();

		for(User user:listuser)
		{
			Set<Environment> envsetperuser;
			JavaType collectionType = objectMapper.getTypeFactory().constructCollectionType(Set.class, Environment.class);
			try {
				
				//create file for user if it doesn't exist
				File listuserenv=new File(Config.datapath+user.getId()+"_env.json");
				listuserenv.createNewFile();
				
				if(listuserenv.length()!=0)
				{
					envsetperuser = objectMapper.readValue(new File(Config.datapath+user.getId()+"_env.json"), collectionType);
					listenv.addAll(envsetperuser);
				}
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


	}

	String name;
	String url;
	String howtostart;
	String internalnote;
	String externalnote;
	String owner;
	Boolean ispublicenv;


	public String getName()
	{
		return name;
	}
	public String getUrl()
	{
		return url;
	}
	public String getHowtostart()
	{
		return howtostart;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}
	public void setHowtostart(String howtostart)
	{
		this.howtostart= howtostart;
	}


	public void setInternalnote(String internalnote)
	{
		this.internalnote=internalnote;
	}
	public String getInternalnote()
	{
		return internalnote;
	}

	public void setExternalnote(String externalnote)
	{
		this.externalnote=externalnote;
	}
	public String getExternalnote()
	{
		return externalnote;
	}

	public void setOwner(String owner)
	{
		this.owner=owner;
	}
	public String getOwner()
	{
		return owner;
	}

	public boolean getPublicEnv()
	{
		//temp fix for json data missing this boolean value
		//if(this.ispublicenv==null)
		//{
		//	return false;
		//}

		return ispublicenv;
	}

	public void setPublicEnv(boolean ispublicenv)
	{
		this.ispublicenv=ispublicenv;
	}

	public Environment()
	{

	}


	public Environment(String name, String url, String howtostart, String externalnote, String internalnote, String owner, Boolean ispublicenv)
	{
		this(name,url,howtostart, externalnote, internalnote, owner);
		this.ispublicenv=ispublicenv;

	}

	public Environment(String name, String url, String howtostart, String externalnote, String internalnote, String owner)
	{
		this.name=name;
		this.url=url;
		this.howtostart=howtostart;
		this.externalnote=externalnote;
		this.internalnote=internalnote;
		this.owner=owner;
	}

	@Override
    public boolean equals(Object obj) {
        if (obj instanceof Environment)
        {

        	Environment test= (Environment) obj;
        	if(this.name.equals(test.name)&&this.url.equals(test.url))
        	{
            return true;
        	}
        	else return false;
        }
        else
            return false;
    }

	 @Override
	    public int hashCode() {
	        return 10;
	    }

	public static void setListEnv(Set<Environment> listenv, String owner){




		System.out.println("size listenv:"+Environment.listenv.size());

		//assumption all new env saved belong to same owner
		//if(listenv.size()!=0)
		//{
		//Iterator<Environment> it=listenv.iterator();
		//Environment sample=it.next();
		//it.
		//String owner=sample.getOwner();
		//}

		// env not submitted considered as removed
		List<Environment> toremove=new ArrayList<Environment>();
		for(Environment testremove:Environment.listenv)
		{
			if(testremove.getOwner().equals(owner))
			{
				toremove.add(testremove);
			}
		}
		Environment.listenv.removeAll(toremove);
		Environment.listenv.addAll(listenv);






		ObjectMapper objectMapper = new ObjectMapper();
		//Car car = new Car("yellow", "renault");
		try {

		
			objectMapper.writeValue(new File(Config.datapath+owner+"_env.json"), listenv);

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

	public static Set<Environment> getListEng()
	{
		return listenv;
	}


}