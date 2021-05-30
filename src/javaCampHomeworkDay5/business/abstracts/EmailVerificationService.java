package javaCampHomeworkDay5.business.abstracts;

public interface EmailVerificationService {
	void sendingVerificationLink(String emailAddress);
	boolean verificatedEmail(String emailAddress);
}
