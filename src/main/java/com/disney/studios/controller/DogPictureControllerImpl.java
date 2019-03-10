package com.disney.studios.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.disney.studios.dao.Dog;
import com.disney.studios.exception.DogServiceException;
import com.disney.studios.model.DogPicResponse;
import com.disney.studios.model.VoteRequest;
import com.disney.studios.service.DogPictureService;

@Controller
@Path("/dogpics")
public class DogPictureControllerImpl implements DogPictureController {

	@Autowired
	DogPictureService dogPictureService;

	public DogPictureControllerImpl(DogPictureService dogPictureService) {
		super();
		this.dogPictureService = dogPictureService;
	}

	@Override
	@GET
	@Path("/all")
	@Produces("application/json")
	public Response allDogs() throws DogServiceException {
		DogPicResponse dPR = new DogPicResponse();
		try {
			List<Dog> dogList = dogPictureService.getAll();
			dPR.setDogs(dogList);
			return Response.status(Response.Status.OK).entity(dPR).build();
		} catch (DogServiceException ex) {
			dPR.setErrorcode(ex.getErrorCode());
			dPR.setErrordescription(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dPR).build();
		}
	}

	@Override
	@GET
	@Path("/specificbreed/{breedName}")
	@Produces("application/json")
	public Response specificBreed(@PathParam("breedName") String breedName) throws DogServiceException {
		DogPicResponse dPR = new DogPicResponse();
		try {
			List<Dog> dogList = dogPictureService.getSpecificBreed(breedName.toLowerCase());
			dPR.setDogs(dogList);
			return Response.status(Response.Status.OK).entity(dPR).build();
		} catch (DogServiceException ex) {
			dPR.setErrorcode(ex.getErrorCode());
			dPR.setErrordescription(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dPR).build();
		}
	}

	@Override
	@POST
	@Path("/vote")
	@Produces("application/json")
	@Consumes("application/json")
	public Response vote(VoteRequest req) throws DogServiceException {

		DogPicResponse dPR = new DogPicResponse();
		try {
			dogPictureService.vote(req);
			return Response.status(Response.Status.ACCEPTED).entity(dPR).build();
		} catch (DogServiceException ex) {
			dPR.setErrorcode(ex.getErrorCode());
			dPR.setErrordescription(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(dPR).build();
		}

	}
}
