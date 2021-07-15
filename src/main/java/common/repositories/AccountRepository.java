package common.repositories;

import common.dao.AccountDAO;
import common.dao.CustomerDAO;
import common.models.Account;
import common.models.Customer;
import common.observers.CustomerCreateObserver;
import framework.DAO;
import framework.EntityRepository;
import framework.Observer.Observer;
import framework.RepositoryEvents;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccountRepository extends EntityRepository<Account,String> {

    @Override
    public DAO<Account, String> getDao() {
        return new AccountDAO();
    }

}
