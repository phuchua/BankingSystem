package banking;

import framework.DAO;
import framework.EntityRepository;
import framework.Observer.Observer;
import framework.RepositoryEvents;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerRepository extends EntityRepository<Customer,String> {


    @Override
    public DAO<Customer, String> getDao() {
        return new CustomerDAO();
    }

    public Map<RepositoryEvents, Set<Observer>> actionListeners(){
        Map observers =  new HashMap<RepositoryEvents, Set<Observer>>();
        observers.put(RepositoryEvents.POST_SAVE,new CustomerCreateObserver());
        return observers;
    }
}
