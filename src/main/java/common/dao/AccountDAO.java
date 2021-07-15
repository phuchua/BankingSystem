package common.dao;

import common.models.Account;
import common.models.Customer;
import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;

public class AccountDAO extends DAO<Account,String> {
    @Override
    public Storage<Account, String> createStorageFactory() {
        return new MemoryStorage<Account,String>();
    }
}
