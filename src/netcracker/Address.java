package netcracker;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id

    @GeneratedValue
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "houseNumber")
    private String houseNumber;

    @OneToMany
    private Set<Human> humans;

    Address(String country, String city, String street, String houseNumber){
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
    //Возвращает полный адрес в string
    public String getFullAddress(){
        String result = getCountry() + "," + getCity() + "," + getStreet() + "," + getHouseNumber();
        return result;
    }
}
