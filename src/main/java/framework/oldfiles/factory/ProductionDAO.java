package framework.oldfiles.factory;

import framework.oldfiles.core.AccountDAO;
import framework.oldfiles.core.AccountDAOImpl;

public class ProductionDAO implements DataFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }
}
