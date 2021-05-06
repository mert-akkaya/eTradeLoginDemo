package eTradeLoginSystem.dataAccess.abstracts;

import java.util.List;

import eTradeLoginSystem.entities.concretes.User;

public interface UserDao {
	
	void add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
	User gtByMail(String email);
	List<User> getAll();
}
