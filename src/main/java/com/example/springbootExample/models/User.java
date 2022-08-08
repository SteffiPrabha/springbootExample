package com.example.springbootExample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER")
@NamedQuery(name = "User.findAll", query = "select u from User u order by u.name")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_USER_ID")
	@SequenceGenerator(name = "S_USER_ID", sequenceName = "S_USER_ID", allocationSize = 1)
	private Long id;
	private String name;
	private Long sso;
	@Column(name = "mobile")
	private Long phoneNumber;

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

	public Long getSso() {
		return sso;
	}

	public void setSso(Long sso) {
		this.sso = sso;
	}

	public String getEmail() {
		return this.sso + "@gmail.com";
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
