package javaCampHomeworkDay5.business.concretes;

import javaCampHomeworkDay5.business.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public void sendingVerificationLink(String emailAddress) {
			System.out.println(emailAddress + ": adresinize do�rulama maili g�nderilmi�tir.");
		}

	@Override
	public boolean verificatedEmail(String emailAddress) {
		boolean currentEmailVerification = true;
		
		if (!currentEmailVerification) {
			System.out.println("Mail adresinizi hen�z do�rulamad�n�z!");
			return false;
		} else {
			System.out.println("Mail adresi do�rulamas� ba�ar�l�.");
			return true;
		}
	}
}
