package javaCampHomeworkDay5.dataAccess.abstracts;

import java.util.List;

import javaCampHomeworkDay5.entities.concretes.Customer;

public interface CustomerDao {
	// data access interface
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);

	List<String> getAll();
}
