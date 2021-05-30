package javaCampHomeworkDay5.business.concretes;

import java.util.List;

import javaCampHomeworkDay5.business.abstracts.CustomerService;
import javaCampHomeworkDay5.business.abstracts.RegisterVerificationService;
import javaCampHomeworkDay5.core.LoggerService;
import javaCampHomeworkDay5.dataAccess.abstracts.CustomerDao;
import javaCampHomeworkDay5.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

	private CustomerDao customerDao;
	private RegisterVerificationService verificationService;
	private EmailVerificationManager emailVerification;
	private LoggerService loggerService;
	
	public CustomerManager(CustomerDao customerDao, RegisterVerificationService verificationService, 
			EmailVerificationManager emailVerification, LoggerService loggerService) {
		super();
		this.customerDao = customerDao;
		this.verificationService = verificationService;
		this.emailVerification = emailVerification;
		this.loggerService = loggerService;
	}
	
	@Override
	public void add(Customer customer) {
		verificationService.verification(customer);
		emailVerification.sendingVerificationLink(customer.getEmail());
		//emailVerification.verificatedEmail(customer.getEmail());
		if (emailVerification.verificatedEmail(customer.getEmail())) {
			customerDao.add(customer);
			
			}
	}
	
	public void addWithAnotherSignService(Customer customer) {
		loggerService.signToSystem("loglama yapýldý.", "Baþarýlý");
		customerDao.add(customer);
	}
	
	public void signIn(Customer customer) {
		for (String email : customerDao.getAll()) {
			if (email == customer.getEmail()) {
				System.out.println(customer.getEmail() + " ile giriþ yapýlmýþtýr.");
			} else {
				System.out.println("Kaydýnýz bulunmamaktadýr! Lütfen üye olun.");
			}
		}
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
