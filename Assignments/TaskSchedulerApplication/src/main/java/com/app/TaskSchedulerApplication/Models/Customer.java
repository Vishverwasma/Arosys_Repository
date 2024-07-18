package com.app.TaskSchedulerApplication.Models;


import jakarta.persistence.*;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String clientType;
    private boolean active;
    private Long nextRunTs;
    
    
	public Customer() {
		super();
	}
	public Customer(Long id, String name, String clientType, boolean active, Long nextRunTs) {
		super();
		this.id = id;
		this.name = name;
		this.clientType = clientType;
		this.active = active;
		this.nextRunTs = nextRunTs;
	}
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
	public Long getNextRunTs() {
		return nextRunTs;
	}
	public void setNextRunTs(Long nextRunTs) {
		this.nextRunTs = nextRunTs;
	}    
}
