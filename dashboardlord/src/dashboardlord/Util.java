package dashboardlord;

import java.util.List;

public class Util {


	public static User authenticate(String hostname)
	{

		List<User> listuser=User.getListUser();

		for(User user: listuser)
		{
			if(hostname.contains(user.getId()))
			{
				return user;
			}
		}
		return User.anonymous;
	}

	public static String authenticateowner(String hostname)
	{

		return Util.authenticate(hostname).getName();

	}

	public static String authenticateid(String hostname)
	{

		return Util.authenticate(hostname).getId();

	}



}


