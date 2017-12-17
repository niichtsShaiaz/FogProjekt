/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jbakke
 */
public class User {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private String role;
    private List<Order> ordersList = new ArrayList<>();

    public User(int id, String email, String firstName, String lastName, String telephone, String address, String role) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
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
        return "User{" + "id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", telephone=" + telephone + ", address=" + address + '}';
    }

    public void setOrderList(List<Order> list)
    {
        ordersList = list;
    }
    
    
}
