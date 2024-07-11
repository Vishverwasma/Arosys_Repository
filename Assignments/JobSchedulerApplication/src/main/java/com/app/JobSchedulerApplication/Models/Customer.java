package com.app.JobSchedulerApplication.Models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String clientType;
    private boolean active;
    private LocalDateTime nextRunTs;

    // No-argument constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(int id, String name, String clientType, Boolean active, LocalDateTime nextRunTs) {
        this.id = id;
        this.name = name;
        this.clientType = clientType;
        this.active = active;
        this.nextRunTs = nextRunTs;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getNextRunTs() {
        return nextRunTs;
    }

    public void setNextRunTs(LocalDateTime nextRunTs) {
        this.nextRunTs = nextRunTs;
    }

}
