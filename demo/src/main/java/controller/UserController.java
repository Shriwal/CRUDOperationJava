package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import model.User;
import service.UserService;

@RestController
@RequestMapping("/endpoint")
public class UserController {

	@Autowired
	UserService userService;	//Service which will do all data retrieval/manipulation work

	/**
	 * @brief Used to Retrieve All Users.
	 * @return userList and HttpStatus.
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> listAllUsers() 
	{
		List<User> userList = userService.getAllUserList();
		return userList;
	}

	/**
	 * @brief Create a User.
	 * @param user to set User Model.
	 * @return HttpStatus
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public boolean createUser(@RequestBody User user) 
	{
		userService.saveUser(user);
		return true;
	}
	

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public boolean updateUser(@PathVariable("id") int id, @RequestBody User user) 
	{
		userService.updateUserRecord(id, user);
        return true;
    }

}
