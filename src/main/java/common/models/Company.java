package common.models;

import common.enums.CustomerType;
import banking.strategy.CompanyBalanceAlertStrategy;
import banking.strategy.CompanyTransactionStrategy;
import lombok.Data;

@Data
public class Company extends Customer {
    private int numberOfEmployees = 0;

    public Company(String id,String name, String street, String city, String state, String zip, String email,int numberOfEmployees){
        super(id,name,email,street,city,state,zip, CustomerType.COMPANY,new CompanyBalanceAlertStrategy(),new CompanyTransactionStrategy());
        this.numberOfEmployees = numberOfEmployees;
    }
}
