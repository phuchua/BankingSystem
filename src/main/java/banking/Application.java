package banking;

import framework.EntityRepository;
import framework.RepositoryEvents;

public class Application {

	public static void main(String[] args) {
		EntityRepository customerRepo = new CustomerRepository();

		Customer c = new Customer("123","Salah","salah@gmail.com");

		customerRepo.addObserver(new CustomerCreateObserver(),RepositoryEvents.POST_SAVE);


		customerRepo.save(c);



		System.out.println(customerRepo.getAll().size());

	}

}
