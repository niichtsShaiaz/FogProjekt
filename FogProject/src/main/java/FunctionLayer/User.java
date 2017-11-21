/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Jbakke
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;

    public User(int id, String email, String password, String firstName, String lastName, String telephone, String address) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone + ", address=" + address + '}';
    }
    
    
}
