package eTradeLoginSystem.core.utils.adapters;

import eTradeLoginSystem.business.abstracts.AuthService;
import eTradeLoginSystem.entities.concretes.User;
import eTradeLoginSystem.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService {

	@Override
	public void login(String email, String password) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(email, password);
		
	}

	@Override
	public void register(User user) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.register(user.getEmail(), user.getPassword());;
		
	}


}
