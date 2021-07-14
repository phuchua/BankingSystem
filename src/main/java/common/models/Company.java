package common.models;

import common.enums.CustomerType;
import lombok.Data;
import java.util.Date;

@Data
public class Company extends Customer {
    private int numberOfEmployees = 0;

    public Company(String name, String street, String city, String state, String zip, String email,int numberOfEmployees){
        super(name,email,street,city,state,zip, CustomerType.COMPANY);
        this.numberOfEmployees = numberOfEmployees;
    }
}
