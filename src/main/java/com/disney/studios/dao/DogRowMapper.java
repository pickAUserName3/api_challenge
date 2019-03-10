package com.disney.studios.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class DogRowMapper implements RowMapper<Dog> {
	    @Override
	    public Dog mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Dog dg = new Dog();
	        dg.setId(rs.getString("id"));
	        dg.setBreed(rs.getString("breed"));
	        dg.setUrl(rs.getString("url"));
	        dg.setVotes(rs.getLong("votes"));
	        return dg;
	    }
	}
