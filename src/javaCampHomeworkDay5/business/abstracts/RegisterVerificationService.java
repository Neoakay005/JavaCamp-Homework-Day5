package javaCampHomeworkDay5.business.abstracts;

import javaCampHomeworkDay5.entities.concretes.Customer;

public interface RegisterVerificationService {
	boolean registerNameLengthCheck(Customer customer);
	boolean registerPasswordLengthCheck(Customer customer);
	boolean registerEmailReusageCheck(Customer customer);
	boolean registerEmailFormatCheck(Customer customer);
	boolean verification(Customer customer);
}
