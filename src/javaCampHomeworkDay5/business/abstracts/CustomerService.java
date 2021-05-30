package javaCampHomeworkDay5.business.abstracts;

import java.util.List;

import javaCampHomeworkDay5.entities.concretes.Customer;

public interface CustomerService {
	void add(Customer customer);
	void addWithAnotherSignService(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
	void signIn(Customer customer);
	List<Customer> getAll();
}
