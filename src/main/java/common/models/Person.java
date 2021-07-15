package common.models;

import common.enums.CustomerType;
import common.strategy.PersonBalanceAlertStrategy;
import common.strategy.PersonTransactionStrategy;
import lombok.Data;
import java.util.Date;

@Data
public class Person extends Customer {
    private Date dob;

    public Person(String id,String name, String street, String city, String state, String zip, String email,Date dob){
        super(id,name,email,street,city,state,zip, CustomerType.PERSON,new PersonBalanceAlertStrategy(),new PersonTransactionStrategy());
        this.dob=dob;
    }
}
