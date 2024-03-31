package javafxapplication3;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Commission {
    private final SimpleStringProperty agentId;
    private final SimpleStringProperty agentName;
    private final SimpleDoubleProperty commissionAmount;

    public Commission(String agentName, double commissionAmount) {
        this.agentId = new SimpleStringProperty("ID-" + System.currentTimeMillis());
        this.agentName = new SimpleStringProperty(agentName);
        this.commissionAmount = new SimpleDoubleProperty(commissionAmount);
    }

    public String getAgentId() {
        return agentId.get();
    }

    public String getAgentName() {
        return agentName.get();
    }

    public double getCommissionAmount() {
        return commissionAmount.get();
    }

    public SimpleStringProperty agentIdProperty() {
        return agentId;
    }

    public SimpleStringProperty agentNameProperty() {
        return agentName;
    }

    public SimpleDoubleProperty commissionAmountProperty() {
        return commissionAmount;
    }
}
