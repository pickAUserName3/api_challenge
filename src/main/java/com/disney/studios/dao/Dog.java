package com.disney.studios.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dog {
	
	
	@Id
	private String id;
	private String url;
	private String breed;
	private Long votes;
	private Integer weightlb;
	private String color;
	private Integer age;
	private String personality;

	public Dog(String id, String url, String breed, Long votes) {
		super();
		this.url = url;
		this.votes = votes;
		this.breed = breed;
		this.id = id;
	}
	
     public Dog() {
		super();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public Long getVotes() {
		return votes;
	}
	public void setVotes(Long votes) {
		this.votes = votes;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
     
	public Integer getWeightlb() {
		return weightlb;
	}



	public void setWeightlb(Integer weightlb) {
		this.weightlb = weightlb;
	}



	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
}
