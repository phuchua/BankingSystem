package framework.factory;

import framework.core.AccountDAO;
import framework.core.AccountDAOImpl;

public class ProductionDAO implements DataFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }
}
