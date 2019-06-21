package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Database.DatabaseLayer;
import model.User;

@Service
public class UserService 
{	
	DatabaseLayer databaseLayer = new DatabaseLayer();
	
	/**
	 * @brief Used to get All the User.
	 * @return Used to return the List.
	 */
	public List<User> getAllUserList()
	{
		List<User> userList =  new ArrayList<User>();
		userList = databaseLayer.getUserList();
		return userList;
	}
	
	/**
	 * @brief Used to pass the User to Database Layer.
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user)
	{
		databaseLayer.insertUserRecordIntoTable(user);
		return true;
	}
	
	public boolean updateUserRecord(int id, User user)
	{
		databaseLayer.updateUserRecord(id, user);
		return true;
	}
	
}
