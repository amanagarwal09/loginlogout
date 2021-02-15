package com.cts.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table
public class User {
	
	@Id
	@Column(name = "userid", length = 20)
	private String userid;
	@Column(name = "password", length = 20)
	private String password;
	@Column(name = "admin", length = 1)
	private boolean admin;
}
