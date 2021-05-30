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
		// Üyelik isim ve soyisim uzunluk kontrolü
		if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2 ) {
			System.out.println("Üyeliðiniz Gerçekleþtirilemedi! Ýsim ve Soyisminiz en az iki karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	@Override
	public boolean registerPasswordLengthCheck(Customer customer) {
		// Üyelik þifre uzunluk kontrolü
		if (customer.getPassword().length() < 6) {
			System.out.println("Üyeliðiniz Gerçekleþtirilemedi! Þifreniz en az 6 karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	@Override
	public boolean registerEmailReusageCheck(Customer customer) {
		// Daha önce ayný email adresi ile üyelik olup olmadýðýný kontrol eder
		// listOfEmail.add(customer.getEmail());
		if (listOfEmail.contains(customer.getEmail())) {
			System.out.println("Üyeliðiniz Gerçekleþtirilemedi! Email adresi mevcut kullanýmda");
			return false;
		}
		return true;
	}

	@Override
	public boolean registerEmailFormatCheck(Customer customer) {
		// KODLAR CORE'DEN ÇEKÝLECEK--------------------------
		// email formatý kontrolü (regex)
		if (!EmailFormatCheck.validate(customer.getEmail())) {
			System.out.println("Üyeliðiniz Gerçekleþtirilemedi! Email adres formatý yanlýþ");
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
