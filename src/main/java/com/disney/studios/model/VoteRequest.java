package com.disney.studios.model;

public class VoteRequest {
	
	Boolean vote;
	
	String picid;

	public VoteRequest() {
		super();
	}

	public Boolean getVote() {
		return vote;
	}

	public void setVote(Boolean vote) {
		this.vote = vote;
	}

	public String getPicid() {
		return picid;
	}

	public void setPicid(String picid) {
		this.picid = picid;
	}
	
}
