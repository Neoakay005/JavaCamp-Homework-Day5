package javaCampHomeworkDay5.business.concretes;

import javaCampHomeworkDay5.business.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public void sendingVerificationLink(String emailAddress) {
			System.out.println(emailAddress + ": adresinize doğrulama maili gönderilmiştir.");
		}

	@Override
	public boolean verificatedEmail(String emailAddress) {
		boolean currentEmailVerification = true;
		
		if (!currentEmailVerification) {
			System.out.println("Mail adresinizi henüz doğrulamadınız!");
			return false;
		} else {
			System.out.println("Mail adresi doğrulaması başarılı.");
			return true;
		}
	}
}
