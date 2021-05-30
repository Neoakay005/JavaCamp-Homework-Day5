package javaCampHomeworkDay5;

import javaCampHomeworkDay5.business.abstracts.CustomerService;
import javaCampHomeworkDay5.business.concretes.CustomerManager;
import javaCampHomeworkDay5.business.concretes.EmailVerificationManager;
import javaCampHomeworkDay5.business.concretes.RegisterVerificationManager;
import javaCampHomeworkDay5.core.GoogleLoggerManagerAdapter;
import javaCampHomeworkDay5.dataAccess.concretes.HibernateCustomerDao;
import javaCampHomeworkDay5.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {
		
		Customer halil = new Customer();
		halil.setId(1);
		halil.setFirstName("Halil �brahim");
		halil.setLastName("Akay");
		halil.setEmail("akayhalil0505@gmail.com");
		halil.setPassword("asd213123123");
		
		Customer adem = new Customer();
		adem.setId(2);
		adem.setFirstName("Adem");
		adem.setLastName("Ademo�lu");
		adem.setEmail("asdasd@gmail.com");
		adem.setPassword("bbaad12345");
		
		CustomerService customerManager = new CustomerManager(new HibernateCustomerDao(), new RegisterVerificationManager(), 
				new EmailVerificationManager(), new GoogleLoggerManagerAdapter());
		System.out.println("\n------- Do�rulama Servisi ile �ye olma ve log geri bildirimi---------");
		customerManager.add(halil);
		
		System.out.println("\n------- Kullan�c� G�ncelleme ---------");
		customerManager.update(halil);
		System.out.println("\n------- Kullan�c� Silme ---------");
		customerManager.delete(halil);
		
		System.out.println("\n------- Giri� yapma---------");
		System.out.println("Kayd� Olan---------");
		customerManager.signIn(halil);
		System.out.println("Kayd� Olmayan---------");
		customerManager.signIn(adem);
		
		System.out.println("\n------- Ba�ka Giri� Servisi ile Giri� Yapma ve log geri bildirimi---------");
		customerManager.addWithAnotherSignService(adem);
		
		

	}

}
