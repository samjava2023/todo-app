package io.todo.app.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.todo.app.dao.model.Todo;

public class TodoRowMapper implements RowMapper<Todo> {

	@Override
	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Todo todo = new Todo();
		todo.setId(rs.getInt(1));
		todo.setTask(rs.getString(2));
		todo.setStatus(rs.getString(3));
		return todo;
	}
	
}
