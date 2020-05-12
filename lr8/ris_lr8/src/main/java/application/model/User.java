package application.model;


import javax.persistence.*;

@Entity
@Table(name = "address")
public class User {
/*
Весь код это создание переменных и полей для ввода их
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String address;

    public User(String surname, String name, String phone, String email, String address) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
