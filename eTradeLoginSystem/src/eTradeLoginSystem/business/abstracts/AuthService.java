package eTradeLoginSystem.business.abstracts;

import eTradeLoginSystem.entities.concretes.User;

public interface AuthService {

	void login(String email,String password);
	void register(User user);
}
