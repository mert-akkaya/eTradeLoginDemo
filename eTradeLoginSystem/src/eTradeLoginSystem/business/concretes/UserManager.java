package eTradeLoginSystem.business.concretes;

import java.util.List;

import eTradeLoginSystem.business.abstracts.UserService;
import eTradeLoginSystem.dataAccess.abstracts.UserDao;
import eTradeLoginSystem.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public void add(User user) {
		this.userDao.add(user);
		
	}

	@Override
	public User getByMail(String email) {
		return this.userDao.gtByMail(email);
		 
		
	}
	
}
