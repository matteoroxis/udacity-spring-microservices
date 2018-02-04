package com.matteoroxis.rest.webservices.restfulwebservices.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@ApiModel(description="All details about the user. ")
@Entity
public class User {
	
        @Id
        @GeneratedValue
	private Long id;
	@Size(min=2,message="Name should have at least 2 characters")
        @ApiModelProperty(notes="Name should have at least 2 characters")
        private String name;
        
        @Past
        @ApiModelProperty(notes="Birth date should be in the past")
	private LocalDate birthday;
	
	public User(){
		
	}
	public User(Long id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
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
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	
	
	
	

}
