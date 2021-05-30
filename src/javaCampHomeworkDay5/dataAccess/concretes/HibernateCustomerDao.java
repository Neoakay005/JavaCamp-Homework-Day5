package javaCampHomeworkDay5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import javaCampHomeworkDay5.dataAccess.abstracts.CustomerDao;
import javaCampHomeworkDay5.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {
	List<String> emailList = new ArrayList<String>();

	@Override
	public void add(Customer customer) {
		System.out.println(customer.getFirstName() + ": isimli kullan�c� ba�ar�l� bir �ekilde veritaban�na eklendi.");
		emailList.add(customer.getEmail());
	}

	@Override
	public void update(Customer customer) {
		System.out.println(customer.getFirstName() + ": isimli kullan�c� bilgileri veritaban�nda g�ncellendi.");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println(customer.getFirstName() + ": isimli kullan�c� bilgileri veritaban�ndan silindi.");
		
	}

	@Override
	public List<String> getAll() {
		return emailList;
	}

}
