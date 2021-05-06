package eTradeLoginSystem.business.concretes;

import eTradeLoginSystem.business.abstracts.EmailService;

public class EmailManager implements EmailService {

	@Override
	public void send(String email, String message) {
		System.out.println("Mesaj : "+email +" adresine gönderildi ;  "+message);
		
	}

}
