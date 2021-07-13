package framework.factory;

import framework.core.AccountDAO;

public interface DataFactory {
    AccountDAO createAccountDAO();
}
