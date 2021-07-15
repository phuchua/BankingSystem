package common.repositories;

import common.dao.AccountDAO;
import common.models.Account;
import framework.DAO;
import framework.EntityRepository;

public class AccountRepository extends EntityRepository<Account,String> {

    @Override
    public DAO<Account, String> getDao() {
        return new AccountDAO();
    }

}
