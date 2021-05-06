package eTradeLoginSystem.business.concretes;

import java.util.regex.Pattern;

import eTradeLoginSystem.business.abstracts.AuthService;
import eTradeLoginSystem.business.abstracts.EmailService;
import eTradeLoginSystem.business.abstracts.UserService;
import eTradeLoginSystem.core.utils.business.BusinessRules;
import eTradeLoginSystem.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	private EmailService emailService;
	
	public AuthManager(UserService userService,EmailService emailService) {
		this.userService = userService;
		this.emailService = emailService;
	}
	@Override
	public void login(String email, String password) {
		
		var user = userService.getByMail(email);
		if (user==null) {
			System.out.println("B�yle bir kullan�c� yok");
			return;
		}
		System.out.println("Giri� ba�ar�l� ho�geldin : "+user.getFirstName());
	}

	@Override
	public void register(User user) {
	
		if (!userExist(user.getEmail())) {
			System.out.println("Bu eposta zaten kullan�mda");
			return;
		}
		
	  boolean result =BusinessRules.RunRules(checkPassword(user.getPassword()),
			  checkName(user.getFirstName(), user.getLastName()),
			  checkEmailPattern(user.getEmail()));
	  	
		if (result==true) {
			System.out.println("Kay�t ba�ar�l�");
			System.out.println("Do�rulama e postas� g�nderildi");
			emailService.send(user.getEmail(), "L�tfen t�klay�n");
			userService.add(user);
		}else {
			System.out.println("Kay�t ba�ar�s�z");
		}
	}
	
	private boolean userExist(String email) {
		return this.userService.getByMail(email)==null;
			
	}
	private boolean checkPassword(String password) {
		if (password.length()<6) {
			System.out.println("Password 6 karakter olmal�d�r");
			return false;
		}else {
			return true;
		}
		
	}
	private boolean checkName(String firstName,String lastName) {
		if (firstName.length()<2 || lastName.length()<2) {
			System.out.println("Ad ve soyad en az 2 karakter i�ermelidir");
			return false;
		}else {
			return true;
		}
	}
	private  boolean checkEmailPattern(String email) {
	 Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	   return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}
}
