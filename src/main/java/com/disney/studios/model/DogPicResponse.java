package com.disney.studios.model;

import java.util.List;

import com.disney.studios.dao.Dog;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class DogPicResponse {

	Integer errorcode;
	String errordescription;
	List<Dog> dogs;

	public DogPicResponse() {
		super();
	}

	public Integer getErrorcode() {
		return errorcode;
	}


	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrordescription() {
		return errordescription;
	}

	public void setErrordescription(String errordescription) {
		this.errordescription = errordescription;
	}

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

}
