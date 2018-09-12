package dashboardlord;

import java.util.*;

public class ListEnvData {

	private List<Environment> listenv=new ArrayList<Environment>();

	public void addEnv(Environment env)
	{
		listenv.add(env);
	}

	public List<Environment> getListEnv()
	{
		return listenv;
	}

	public void setListEnv(List<Environment> listenv)
	{
		this.listenv= listenv;
	}

	public ListEnvData()
	{
		/*Environment a=new Environment("a","b","c");
		Environment b=new Environment("aa","ba","ca");
		listenv.add(a);
		listenv.add(b);*/

	}



}



