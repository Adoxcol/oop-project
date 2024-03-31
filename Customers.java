package customer;

import java.util.Date;
import java.util.UUID;



public class Customers {
    // Attributes
    private int customerID;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Date dateOfBirth;
    private boolean loggedIn;
    

    public Customers(String password, String firstName, String lastName, String email, String address, Date dateOfBirth) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.customerID = generateUniqueCustomerId();
        
    }

    

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

   

    // Getters and setters for other attributes

    private int generateUniqueCustomerId() {
        // Use UUID to generate a random unique ID
        return UUID.randomUUID().hashCode();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
}
