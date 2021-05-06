package eTradeLoginSystem.dataAccess.concretes.hibernate;

import java.util.ArrayList;
import java.util.List;

import eTradeLoginSystem.dataAccess.abstracts.UserDao;
import eTradeLoginSystem.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		System.out.println(user.getFirstName() + " added");
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " updated");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() + " deleted");
		
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User gtByMail(String email) {
		for (User user : users) {
			if (user.getEmail()==email) {
				return user;
			}
		}
		return null;
	}
	
	
}
