package eTradeLoginSystem.business.abstracts;

import java.util.List;

import eTradeLoginSystem.entities.concretes.User;

public interface UserService {
	
	void add(User user);
	List<User> getAll();
	User getByMail(String email);
}
