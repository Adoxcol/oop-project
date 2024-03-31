package javafxapplication3;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AgentCommission {
    private final StringProperty agentId;
    private final StringProperty agentName;
    private final StringProperty commissionAmount;

    public AgentCommission(String agentId, String agentName, String commissionAmount) {
        this.agentId = new SimpleStringProperty(agentId);
        this.agentName = new SimpleStringProperty(agentName);
        this.commissionAmount = new SimpleStringProperty(commissionAmount);
    }

    public String getAgentId() {
        return agentId.get();
    }

    public StringProperty agentIdProperty() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId.set(agentId);
    }

    public String getAgentName() {
        return agentName.get();
    }

    public StringProperty agentNameProperty() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName.set(agentName);
    }

    public String getCommissionAmount() {
        return commissionAmount.get();
    }

    public StringProperty commissionAmountProperty() {
        return commissionAmount;
    }

    public void setCommissionAmount(String commissionAmount) {
        this.commissionAmount.set(commissionAmount);
    }
}
