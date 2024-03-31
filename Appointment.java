package javafxapplication3;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointment {

    private final StringProperty agentId;
    private final StringProperty agentName;
    private final StringProperty appointmentDate;

    public Appointment(String agentId, String agentName, String appointmentDate) {
        this.agentId = new SimpleStringProperty(agentId);
        this.agentName = new SimpleStringProperty(agentName);
        this.appointmentDate = new SimpleStringProperty(appointmentDate);
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

    public String getAppointmentDate() {
        return appointmentDate.get();
    }

    public StringProperty appointmentDateProperty() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate.set(appointmentDate);
    }
}
