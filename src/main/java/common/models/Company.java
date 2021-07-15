package common.models;

import common.enums.CustomerType;
import common.strategy.CompanyBalanceAlertStrategy;
import common.strategy.CompanyTransactionStrategy;
import lombok.Data;
import java.util.Date;

@Data
public class Company extends Customer {
    private int numberOfEmployees = 0;

    public Company(String id,String name, String street, String city, String state, String zip, String email,int numberOfEmployees){
        super(id,name,email,street,city,state,zip, CustomerType.COMPANY,new CompanyBalanceAlertStrategy(),new CompanyTransactionStrategy());
        this.numberOfEmployees = numberOfEmployees;
    }
}
