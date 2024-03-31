package customer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.beans.property.*;

public class Quote {
    // Quote properties
    private final StringProperty quoteText;
    private final BooleanProperty accepted;

    public Quote(int customerId, String quoteText) {
        this.quoteText = new SimpleStringProperty(quoteText);
        this.accepted = new SimpleBooleanProperty(false); // Default to false
    }

   

    public String getQuoteText() {
        return quoteText.get();
    }

    public void setQuoteText(String quoteText) {
        this.quoteText.set(quoteText);
    }

    public StringProperty quoteTextProperty() {
        return quoteText;
    }

    public boolean isAccepted() {
        return accepted.get();
    }

    public void setAccepted(boolean accepted) {
        this.accepted.set(accepted);
    }

    public BooleanProperty acceptedProperty() {
        return accepted;
    }
    // Other properties and methods for Quote class...

  
}


