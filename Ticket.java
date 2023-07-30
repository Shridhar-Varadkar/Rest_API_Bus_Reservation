package com.crud.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int T_id;
	
	@Column(nullable = false)
	private String passengerName;
	
	@Column(nullable = false)
	private String Boarding;
	
	@Column(nullable = false)
	private String Arrival;
	
	@CreatedDate
	private Instant createAt;
	
	@LastModifiedDate
	private Instant updateAt;
	
	@OneToOne(mappedBy = "ticket")
	private Bus bus;

	public Ticket() {
		super();
	}

	public Ticket(int t_id, String passengerName, String boarding, String arrival, Instant createAt, Instant updateAt) {
		super();
		T_id = t_id;
		this.passengerName = passengerName;
		Boarding = boarding;
		Arrival = arrival;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getT_id() {
		return T_id;
	}

	public void setT_id(int t_id) {
		T_id = t_id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getBoarding() {
		return Boarding;
	}

	public void setBoarding(String boarding) {
		Boarding = boarding;
	}

	public String getArrival() {
		return Arrival;
	}

	public void setArrival(String arrival) {
		Arrival = arrival;
	}

	public Instant getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Instant createAt) {
		this.createAt = createAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Instant updateAt) {
		this.updateAt = updateAt;
	}

}
