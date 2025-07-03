package org.dnyanyog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="login")
@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Ensure auto-generation of ID
	Long id;
	
	@Column(name="login_name")
	String loginName;
	
	@Column
	String password;

	public Long getId() {
		return id;
	}

	 public void setId(Long id) {
	        this.id = id;
	    }

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public String toString() {
        return "Login{id=" + id + ", loginName='" + loginName + "', password='" + password + "'}";
    }

	
}
