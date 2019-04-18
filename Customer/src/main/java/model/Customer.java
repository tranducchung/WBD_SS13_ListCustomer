package model;

public class Customer {
     private int id;
    private String name;
    private String Email;
    private String address;

    public Customer(){}

    public Customer(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        Email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
