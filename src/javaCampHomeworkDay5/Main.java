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
		halil.setFirstName("Halil Ýbrahim");
		halil.setLastName("Akay");
		halil.setEmail("akayhalil0505@gmail.com");
		halil.setPassword("asd213123123");
		
		Customer adem = new Customer();
		adem.setId(2);
		adem.setFirstName("Adem");
		adem.setLastName("Ademoðlu");
		adem.setEmail("asdasd@gmail.com");
		adem.setPassword("bbaad12345");
		
		CustomerService customerManager = new CustomerManager(new HibernateCustomerDao(), new RegisterVerificationManager(), 
				new EmailVerificationManager(), new GoogleLoggerManagerAdapter());
		System.out.println("\n------- Doðrulama Servisi ile Üye olma ve log geri bildirimi---------");
		customerManager.add(halil);
		
		System.out.println("\n------- Kullanýcý Güncelleme ---------");
		customerManager.update(halil);
		System.out.println("\n------- Kullanýcý Silme ---------");
		customerManager.delete(halil);
		
		System.out.println("\n------- Giriþ yapma---------");
		System.out.println("Kaydý Olan---------");
		customerManager.signIn(halil);
		System.out.println("Kaydý Olmayan---------");
		customerManager.signIn(adem);
		
		System.out.println("\n------- Baþka Giriþ Servisi ile Giriþ Yapma ve log geri bildirimi---------");
		customerManager.addWithAnotherSignService(adem);
		
		

	}

}
