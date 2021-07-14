package framework.oldfiles.factory;

import framework.oldfiles.core.AccountDAO;
import framework.oldfiles.core.MockAccountDAO;

public class TestingDAO implements DataFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new MockAccountDAO();
    }
}
