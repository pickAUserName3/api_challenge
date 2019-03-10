package com.disney.studios.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.disney.studios.exception.DogServiceException;
import com.disney.studios.model.VoteRequest;

@Component
public class DogDAO {

	private final static Logger log = Logger.getLogger(DogDAO.class.getName());
	
	DataSource datasource;

	JdbcTemplate jdbcTemplate;

	DogRowMapper dorowMapper;
	
	
	@Autowired
	public DogDAO(DataSource datasource, JdbcTemplate jdbcTemplate, DogRowMapper dorowMapper) {
		super();
		this.datasource = datasource;
		this.jdbcTemplate = jdbcTemplate;
		this.dorowMapper = dorowMapper;
	}

	public List<Dog> getAll() throws SQLException {
		String query = "select id, url, breed, votes, weightlb, color, age, personality from dog order by votes desc";
		return (List<Dog>) jdbcTemplate.query(query, dorowMapper);
	}

	public List<Dog> getSpecificBreed(String bName) throws SQLException {
		String query = "select id, url, breed, votes, weightlb, color, age, personality "
				+ "from dog where breed = ? order by votes desc";

		List<Dog> dgList = null;
		try {
			dgList = jdbcTemplate.query(query, new Object[] { bName }, dorowMapper);
		} catch (EmptyResultDataAccessException ex) {
			log.info("This breed is invalid" + "602");
		}
		return dgList;
	}

	public void vote(VoteRequest req) throws SQLException {
		String selectQ = "select id, url, breed, votes, weightlb, color, age, personality " + "from dog where id = ?";
		Dog fromDb = null;
		try {
			fromDb = jdbcTemplate.queryForObject(selectQ, new Object[] { req.getPicid() }, dorowMapper);

			long vote = fromDb.getVotes();
			if (req.getVote()) {
				fromDb.setVotes(++vote);
			} else {
				fromDb.setVotes(--vote);
			}
			String query = "update dog set votes = ? where id = ? ";
			jdbcTemplate.update(query, new Object[] { fromDb.getVotes(), fromDb.getId() });
		} catch (EmptyResultDataAccessException ex) {
			throw new DogServiceException("This id is invalid", "Bad ID", 601, ex);
		} 
	}

}
