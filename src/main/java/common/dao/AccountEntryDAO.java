package common.dao;

import common.models.AccountEntry;
import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storable;
import framework.Storage.Storage;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class AccountEntryDAO extends DAO<AccountEntry,String> {
    @Override
    public Storage<AccountEntry, String> createStorageFactory() {
        return new MemoryStorage<AccountEntry,String>();
    }
}
