package customer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Claim {
    private Customers customerID;
    private final StringProperty claimText;

    public Claim(Customers customer, String claimText) {
        this.customerID = customer;
        this.claimText = new SimpleStringProperty(claimText);
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public StringProperty claimTextProperty() {
        return claimText;
    }
}
