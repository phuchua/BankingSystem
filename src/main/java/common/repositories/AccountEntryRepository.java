package common.repositories;

import common.dao.AccountEntryDAO;
import common.models.AccountEntry;
import framework.DAO;
import framework.EntityRepository;

public class AccountEntryRepository extends EntityRepository<AccountEntry,String> {

    @Override
    public DAO<AccountEntry, String> getDao() {
        return new AccountEntryDAO();
    }

}
