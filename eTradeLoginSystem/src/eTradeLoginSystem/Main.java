package eTradeLoginSystem;

import eTradeLoginSystem.business.abstracts.AuthService;
import eTradeLoginSystem.business.abstracts.EmailService;
import eTradeLoginSystem.business.abstracts.UserService;
import eTradeLoginSystem.business.concretes.AuthManager;
import eTradeLoginSystem.business.concretes.EmailManager;
import eTradeLoginSystem.business.concretes.UserManager;
import eTradeLoginSystem.core.utils.adapters.GoogleAuthManagerAdapter;
import eTradeLoginSystem.dataAccess.concretes.hibernate.HibernateUserDao;
import eTradeLoginSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Mert", "Akkaya", "mert2@mert.com", "1235554");
		User user2 = new User(2, "Engin", "Demirog", "engin@engin.com", "1235554");
		UserService userService = new UserManager(new HibernateUserDao());
		EmailService emailService = new EmailManager();
		AuthService authService = new AuthManager(userService,emailService);
		authService.register(user2);
		authService.login(user2.getEmail(), user2.getPassword());
		AuthService googleAuthService = new GoogleAuthManagerAdapter();
		googleAuthService.login(user2.getEmail(), user2.getPassword());
		
		
	}

}
