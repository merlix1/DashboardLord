package dashboardlord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Controller {


	private static Controller controller = null;

	private Controller()
	{

	}


	public static Controller getInstance()
    {
        if (controller == null)
        	controller = new Controller();

        return controller;
    }


	public void doCall(String method, HashMap<String,String> param)
	{
		if(method.equals("adduser"))
				{
				List<User> listuser=new ArrayList<>();
				for (Entry<String, String> entry : param.entrySet()) {
					    String key = entry.getKey();
					    String value = entry.getValue();
					    User user=new User(key,value);
					    listuser.add(user);
						}
				User.setListUser(listuser);
				}



	}

	public void doCall(String method, List<List<String>> param, String param2)
	{
		if(method.equals("addenv"))
		{
		Set<Environment> listenv=new HashSet<>();

		List<List<String>> recordlist=new ArrayList<List<String>>();
		int nbrrow=param.get(0).size();
		System.out.println("Controller: number of row is:"+nbrrow);

		for(int i=0;i<nbrrow;i++)
		{
			recordlist.add(new ArrayList<String>());
		}

		//transform into a better list to work with
		List<String> recordx=new ArrayList<String>();
		for(int i=0;i<param.size();i++)
		{
			//tmp size: number of properties: name, url...
			List<String> tmp=param.get(i);

			for(int k=0;k<tmp.size();k++){
			    System.out.println("Bcontrol of list"+i+": item "+k+":"+tmp.get(k));
			}

			//for(String column:tmp)
		//	for(int j=0;j<tmp.size();j++)
			for(int j=0;j<nbrrow;j++)
			{
				System.out.println("i="+i+"and j="+j);
				recordx=recordlist.get(j);
				recordx.add(i, tmp.get(j));
				//System.out.println("valuesatdofCall at "+tmp.get(i));
			//	record(j)=column;
			//	System.out.println("valuesatdoCall at "+i+":"+tmp.get(j));
			//	if(j==(tmp.size()-1))
			//	{
			//		recordlist.add(recordx);
			//	}
			}
			//recordlist.add(record);
		}

		for(List<String> record: recordlist)
		{
			String name=record.get(0);
			String url=record.get(1);
			String internalnote=record.get(2);
			String externalnote=record.get(3);
			//String owner=record.get(4);

			String ispublicstring=record.get(5);
			Boolean ispublic;
			if(ispublicstring.equals("true"))
					{
				ispublic=true;
					}
			else{
				ispublic=false;
			}
			//Environment env=new  Environment(name,url,"",externalnote,internalnote,param2);
			Environment env=new  Environment(name,url,"",externalnote,internalnote,param2,ispublic);
			listenv.add(env);

		}
		Environment.setListEnv(listenv,param2);

		}


	}

	public HashMap<String,String> getListUser()
	{

		List<User> listuser=User.getListUser();
		HashMap<String,String> hash=new HashMap<>();


		System.out.println("getLIsUser");
		for(User user:listuser)
		{
			hash.put(user.getId(), user.getName());

			System.out.println("getLIsUser():"+user.getName());
		}
		return hash;
	}

	public List<List<String>> getListEnv()
	{
		Set<Environment> setenv=Environment.getListEng();

		List<List<String>> result=new ArrayList<List<String>>();
		for(Environment env:setenv)
		{
			List<String> tmp=new ArrayList<>();
			String name=env.getName();
			String url=env.getUrl();
			String internalnote=env.getInternalnote();
			String externalnote=env.getExternalnote();
			String owner=env.getOwner();
			String ispublic=Boolean.toString(env.getPublicEnv());
			tmp.add(name);
			tmp.add(url);
			tmp.add(internalnote);
			tmp.add(externalnote);
			tmp.add(owner);
			tmp.add(ispublic);
			result.add(tmp);
		}
		return result;
	}

	public List<List<String>> getListEnvById(String id)
	{
		Set<Environment> setenv=Environment.getListEng();

		List<List<String>> result=new ArrayList<List<String>>();
		for(Environment env:setenv)
		{

			if(env.getOwner().equals(id))
			{
			List<String> tmp=new ArrayList<>();
			String name=env.getName();
			String url=env.getUrl();
			String internalnote=env.getInternalnote();
			String externalnote=env.getExternalnote();
			String ispublic=Boolean.toString(env.getPublicEnv());
			//owner=env.getOwner();
			tmp.add(name);
			tmp.add(url);
			tmp.add(internalnote);
			tmp.add(externalnote);
			tmp.add(id);
			tmp.add(ispublic);
			result.add(tmp);
			}
		}
		return result;
	}

	//return public env but for owner it returns also the private
	public List<List<String>> getListEnvPublic(String id)
	{
		Set<Environment> setenv=Environment.getListEng();

		List<List<String>> result=new ArrayList<List<String>>();
		for(Environment env:setenv)
		{

			if(env.getPublicEnv()==true||env.getOwner().equals(id))
			{
			List<String> tmp=new ArrayList<>();
			String name=env.getName();
			String url=env.getUrl();
			String internalnote=env.getInternalnote();
			String externalnote=env.getExternalnote();
			String ispublic=Boolean.toString(env.getPublicEnv());
			String owner=env.getOwner();
			tmp.add(name);
			tmp.add(url);
			tmp.add(internalnote);
			tmp.add(externalnote);
			tmp.add(owner);
			tmp.add(ispublic);
			result.add(tmp);
			}
		}
		return result;
	}







}
