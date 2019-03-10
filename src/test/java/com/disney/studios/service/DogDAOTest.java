package com.disney.studios.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.easymock.EasyMock;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.disney.studios.dao.Dog;
import com.disney.studios.dao.DogDAO;
import com.disney.studios.dao.DogRowMapper;
import com.disney.studios.exception.DogServiceException;
import com.disney.studios.model.VoteRequest;

public class DogDAOTest {
	DataSource datasource;

	JdbcTemplate jdbcTemplate;

	DogRowMapper dorowMapper;

	List<Dog> dgList = new ArrayList<>();

	DogDAO dogDao;

	@BeforeMethod
	public void setUp() throws Exception {
		datasource = EasyMock.createMock(DataSource.class);
		jdbcTemplate = EasyMock.createMock(JdbcTemplate.class);
		dorowMapper = EasyMock.createMock(DogRowMapper.class);
		dogDao = new DogDAO(datasource, jdbcTemplate, dorowMapper);

	}

	
	/**
	 * Test exception thrown from vote method in DAO
	 * @throws Exception
	 */
	@Test(expectedExceptions = DogServiceException.class)
	public void testVoteException() throws Exception {
		VoteRequest req = new VoteRequest();
		req.setPicid("invalid");
		EmptyResultDataAccessException ex = new EmptyResultDataAccessException(2);
		EasyMock.expect(jdbcTemplate.queryForObject(EasyMock.anyString(), EasyMock.anyObject(),
				EasyMock.anyObject(DogRowMapper.class))).andThrow(ex);

		EasyMock.replay(jdbcTemplate, datasource, dorowMapper);
		dogDao.vote(req);
		EasyMock.verify(jdbcTemplate, datasource, dorowMapper);
	}

}
