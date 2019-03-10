package com.disney.studios.controller;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.disney.studios.exception.DogServiceException;
import com.disney.studios.model.VoteRequest;

@Controller
public interface DogPictureController {
	
	
	/**
	 * Retrieve all the dog pics
	 * @return
	 * @throws DogServiceException 
	 * @throws IOException 
	 */
	public Response allDogs() throws DogServiceException;
	
	
	/**
	 * Retrieve pics of a specific breed
	 * @param breedName
	 * @return
	 * @throws DogServiceException
	 */
	public Response specificBreed(String breedName) throws DogServiceException;

    /**
     * Vote up or down a pic
     * @param vote
     * @return 
     * @throws DogServiceException
     */
	Response vote(VoteRequest vote) throws DogServiceException;
}
