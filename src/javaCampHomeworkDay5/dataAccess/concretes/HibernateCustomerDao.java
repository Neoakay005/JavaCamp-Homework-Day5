package javaCampHomeworkDay5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import javaCampHomeworkDay5.dataAccess.abstracts.CustomerDao;
import javaCampHomeworkDay5.entities.concretes.Customer;

public class HibernateCustomerDao implements CustomerDao {
	List<String> emailList = new ArrayList<String>();

	@Override
	public void add(Customer customer) {
		System.out.println(customer.getFirstName() + ": isimli kullanıcı başarılı bir şekilde veritabanına eklendi.");
		emailList.add(customer.getEmail());
	}

	@Override
	public void update(Customer customer) {
		System.out.println(customer.getFirstName() + ": isimli kullanıcı bilgileri veritabanında güncellendi.");
		
	}

	@Override
	public void delete(Customer customer) {
		System.out.println(customer.getFirstName() + ": isimli kullanıcı bilgileri veritabanından silindi.");
		
	}

	@Override
	public List<String> getAll() {
		return emailList;
	}

}
