package framework.factory;

import framework.core.AccountDAO;
import framework.core.MockAccountDAO;

public class TestingDAO implements DataFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new MockAccountDAO();
    }
}
