package common.models;

import common.enums.CustomerType;
import banking.strategy.PersonBalanceAlertStrategy;
import banking.strategy.PersonTransactionStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

public class Person extends Customer {
    private LocalDate dob;

    public Person(String id,String name, String street, String city, String state, String zip, String email,LocalDate dob){
        super(id,name,email,street,city,state,zip, CustomerType.PERSON,new PersonBalanceAlertStrategy(),new PersonTransactionStrategy());
        this.dob=dob;
    }
}
