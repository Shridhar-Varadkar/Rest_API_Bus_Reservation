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
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int D_id;
	
	@Column(nullable = false)
	private String DriverName;
	
	@Column(nullable = false)
	private int phone;
	
	@Column(nullable = false)
	private String address;
	
	@CreatedDate
	private Instant createAt;
	
	@LastModifiedDate
	private Instant updateAt;
	
	@ManyToMany(mappedBy = "driver")
	private List<Bus>bus;
	

	public Driver() {
		super();
	}

	public Driver(int d_id, String driverName, int phone, String address, Instant createAt, Instant updateAt) {
		super();
		D_id = d_id;
		DriverName = driverName;
		this.phone = phone;
		this.address = address;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getD_id() {
		return D_id;
	}

	public void setD_id(int d_id) {
		D_id = d_id;
	}

	public String getDriverName() {
		return DriverName;
	}

	public void setDriverName(String driverName) {
		DriverName = driverName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
