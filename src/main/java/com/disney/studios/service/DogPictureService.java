package com.disney.studios.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.disney.studios.dao.Dog;
import com.disney.studios.dao.DogDAO;
import com.disney.studios.exception.DogServiceException;
import com.disney.studios.model.VoteRequest;

@Component
public class DogPictureService {
	
	DogDAO dogDAO;

	
	@Autowired
	public DogPictureService(DogDAO dogDAO) {
		super();
		this.dogDAO = dogDAO;
	}

	/**
	 * Get All the dogs
	 * 
	 * @return
	 * @throws DogServiceException
	 */
	public List<Dog> getAll() throws DogServiceException {
		List<Dog> dgList;
		try {
			 dgList = dogDAO.getAll();
		} catch (SQLException ex2) {
			throw new DogServiceException("Error while communicating with DB", "DB error", 600, ex2);
		}
		return dgList;
	}

	/**
	 * Retrieve a specific breed
	 * 
	 * @param breedName
	 * @return
	 * @throws DogServiceException
	 */
	public List<Dog> getSpecificBreed(String breedName) throws DogServiceException {
		try {
			return dogDAO.getSpecificBreed(breedName);
		} catch (SQLException e) {
			throw new DogServiceException("Database error", "DB error", 600, e);
		}
	}

	/**
	 * Vote a pic up or down
	 * 
	 * @param req
	 * @throws DogServiceException
	 */
	public void vote(VoteRequest req) throws DogServiceException {
		try {
			dogDAO.vote(req);
		} catch (SQLException ex2) {
			throw new DogServiceException("Database error", "DB error", 600, ex2);
		}
	}

}
