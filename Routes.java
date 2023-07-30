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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Routes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int R_id;
	
	@Column(nullable = false)
	private int Distance;
	
	@Column(nullable = false)
	private String routesName;
	
	@CreatedDate
	private Instant createAt;
	
	@LastModifiedDate
	private Instant updateAt;
	
	@ManyToOne
	@JoinColumn(name = "Bus_id")
	private Bus bus;

	public Routes() {
		super();
	}

	public Routes(int r_id, int distance, String routesName, Instant createAt, Instant updateAt) {
		super();
		R_id = r_id;
		Distance = distance;
		this.routesName = routesName;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public int getR_id() {
		return R_id;
	}

	public void setR_id(int r_id) {
		R_id = r_id;
	}

	public int getDistance() {
		return Distance;
	}

	public void setDistance(int distance) {
		Distance = distance;
	}

	public String getRoutesName() {
		return routesName;
	}

	public void setRoutesName(String routesName) {
		this.routesName = routesName;
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
