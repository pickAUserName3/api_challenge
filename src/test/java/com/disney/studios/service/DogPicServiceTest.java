package com.disney.studios.service;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disney.studios.dao.Dog;
import com.disney.studios.dao.DogDAO;

public class DogPicServiceTest   {
	
	DogPictureService dogPicServ;
	DogDAO dgDao;
	
	List<Dog> dgList = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        dgDao = EasyMock.createMock(DogDAO.class);
        dogPicServ = new DogPictureService(dgDao);
       }
	/**
	 * Test get all method
	 * @throws Exception
	 */
    @Test()
    public void testGetAll() throws Exception {
    	Dog dg1 = new Dog("1234-abc","url","labrador", 1l);
    	Dog dg2 = new Dog("1234-cde","url","yorki", 11l);

    	dgList.add(dg1);
    	dgList.add(dg2);
    	EasyMock.expect(dgDao.getAll()).andReturn(dgList);
    	EasyMock.replay(dgDao);
    	List<Dog> ls = dogPicServ.getAll();
    	EasyMock.verify(dgDao);
    	Assert.assertEquals(ls.get(0).getBreed(), dg1.getBreed());
    	Assert.assertEquals(ls.get(0).getUrl(), dg1.getUrl());
    	Assert.assertEquals(ls.get(1).getVotes(), dg2.getVotes());

    }
    
    /**
     * Test Get Specific Breed when no results found for breed
     * @throws Exception
     */
    
    @Test()
    public void testGetSpecificBreedEmpty() throws Exception {
    	Dog dg1 = new Dog("1234-abc","url","yorki", 1l);
    	Dog dg2 = new Dog("1234-cde","url","yorki", 11l);

    	dgList.add(dg1);
    	dgList.add(dg2);
    	EasyMock.expect(dgDao.getSpecificBreed("labrador")).andReturn(new ArrayList<Dog>());
    	EasyMock.replay(dgDao);
    	List<Dog> ls = dogPicServ.getSpecificBreed("labrador");
    	EasyMock.verify(dgDao);
    	Assert.assertEquals(ls.size(), 0);
    }


}
