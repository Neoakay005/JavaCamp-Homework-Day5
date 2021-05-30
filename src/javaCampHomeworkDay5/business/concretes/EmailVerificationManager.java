package javaCampHomeworkDay5.business.concretes;

import javaCampHomeworkDay5.business.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public void sendingVerificationLink(String emailAddress) {
			System.out.println(emailAddress + ": adresinize doðrulama maili gönderilmiþtir.");
		}

	@Override
	public boolean verificatedEmail(String emailAddress) {
		boolean currentEmailVerification = true;
		
		if (!currentEmailVerification) {
			System.out.println("Mail adresinizi henüz doðrulamadýnýz!");
			return false;
		} else {
			System.out.println("Mail adresi doðrulamasý baþarýlý.");
			return true;
		}
	}
}
