package com.cjduan.www.spring.jpa.sample.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user")
public class User {

	@Id
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
