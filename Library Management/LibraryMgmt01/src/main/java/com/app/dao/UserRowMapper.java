package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.entity.User;


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setCity(rs.getString("city"));
        user.setGender(rs.getString("gender"));

        return user;
    }
}