package com.crud.models;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int B_id;
	
	@Column(nullable = false)
	private String BusName;
	
	@Column(nullable = false)
	private int BusNumber;
	
	@Column(nullable = false)
	private String TimeDate;
	
	@CreatedDate
	private Instant createAt;
	
	@LastModifiedDate
	private Instant updateAt;
	
	@OneToOne
	@JoinColumn(name="Ticket_id")
	private Ticket ticket;
	
	@OneToMany(mappedBy = "bus")
	private List<Routes>routes;
	
	@ManyToMany
	@JoinTable(
			name="Bus_Driver",
			joinColumns = @JoinColumn(name="Bus_id",referencedColumnName = "B_id"),
			inverseJoinColumns = @JoinColumn(name="Driver_id", referencedColumnName = "D_id")
			)
	private List<Driver>driver;
	

	public Bus() {
		super();
	}

	public Bus(int id, String busName, int busNumber, String timeDate, Instant createAt, Instant updateAt) {
		super();
		this.B_id = id;
		BusName = busName;
		BusNumber = busNumber;
		TimeDate = timeDate;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getId() {
		return B_id;
	}

	public void setId(int id) {
		this.B_id = id;
	}

	public String getBusName() {
		return BusName;
	}

	public void setBusName(String busName) {
		BusName = busName;
	}

	public int getBusNumber() {
		return BusNumber;
	}

	public void setBusNumber(int busNumber) {
		BusNumber = busNumber;
	}

	public String getTimeDate() {
		return TimeDate;
	}

	public void setTimeDate(String timeDate) {
		TimeDate = timeDate;
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
