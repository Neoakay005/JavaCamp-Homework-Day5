package javaCampHomeworkDay5.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javaCampHomeworkDay5.business.abstracts.RegisterVerificationService;
import javaCampHomeworkDay5.core.EmailFormatCheck;
import javaCampHomeworkDay5.entities.concretes.Customer;

public class RegisterVerificationManager implements RegisterVerificationService {
	
	private List<String> listOfEmail = new ArrayList<String>();
	

	@Override
	public boolean registerNameLengthCheck(Customer customer) {
		// �yelik isim ve soyisim uzunluk kontrol�
		if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2 ) {
			System.out.println("�yeli�iniz Ger�ekle�tirilemedi! �sim ve Soyisminiz en az iki karakter olmal�d�r!");
			return false;
		}
		return true;
	}

	@Override
	public boolean registerPasswordLengthCheck(Customer customer) {
		// �yelik �ifre uzunluk kontrol�
		if (customer.getPassword().length() < 6) {
			System.out.println("�yeli�iniz Ger�ekle�tirilemedi! �ifreniz en az 6 karakter olmal�d�r!");
			return false;
		}
		return true;
	}

	@Override
	public boolean registerEmailReusageCheck(Customer customer) {
		// Daha �nce ayn� email adresi ile �yelik olup olmad���n� kontrol eder
		// listOfEmail.add(customer.getEmail());
		if (listOfEmail.contains(customer.getEmail())) {
			System.out.println("�yeli�iniz Ger�ekle�tirilemedi! Email adresi mevcut kullan�mda");
			return false;
		}
		return true;
	}

	@Override
	public boolean registerEmailFormatCheck(Customer customer) {
		// KODLAR CORE'DEN �EK�LECEK--------------------------
		// email format� kontrol� (regex)
		if (!EmailFormatCheck.validate(customer.getEmail())) {
			System.out.println("�yeli�iniz Ger�ekle�tirilemedi! Email adres format� yanl��");
			return false;
		}
		return true;
	}
	
	public boolean verification(Customer customer) {
		if (registerNameLengthCheck(customer) && registerPasswordLengthCheck(customer) 
				&& registerEmailReusageCheck(customer) && registerEmailFormatCheck(customer)) {
			
			return true;
		}
		return false;
	}

}
