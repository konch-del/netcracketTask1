package netcracker;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "human")
public class Human {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dateOfBirth")
    private Calendar dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "address_id", unique = true, nullable = false)
    private Address address;

    Human(String name, String lastName, Calendar dateOfBirth){
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName(){
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    //Возвращает всю информацию о человеке в string
    public String info(){
        String result = "Имя: " + getName() +
                        "\nФамилия: " + getLastName() +
                        "\nДень рождения: " + getDateOfBirth().getTime() +
                        "\nАдрес: " + getAddress().getFullAddress();
        return result;
    }
}
