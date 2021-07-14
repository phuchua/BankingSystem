package common.models;

import common.enums.CustomerType;
import lombok.Data;
import java.util.Date;

@Data
public class Person extends Customer {
    private Date dob;

    public Person(String name, String street, String city, String state, String zip, String email,Date dob){
        super(name,email,street,city,state,zip, CustomerType.PERSON);
        this.dob=dob;
    }
}
