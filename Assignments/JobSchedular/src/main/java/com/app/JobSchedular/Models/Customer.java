package com.app.JobSchedular.Models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "db_customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String clientType;
    private boolean active;
    private LocalDateTime nextRunTs;

    //Constructors
    public Customer(Long id, String name, String clientType, boolean active, LocalDateTime nextRunTs) {
		super();
		this.id = id;
		this.name = name;
		this.clientType = clientType;
		this.active = active;
		this.nextRunTs = nextRunTs;
	}
	public Customer() {
		super();
	}
    
    // Getters and setters
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getNextRunTs() {
		return nextRunTs;
	}
	public void setNextRunTs(LocalDateTime nextRunTs) {
		this.nextRunTs = nextRunTs;
	}

    
}
