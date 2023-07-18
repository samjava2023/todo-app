package io.todo.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import io.todo.app.dao.mapper.TodoRowMapper;
import io.todo.app.dao.model.Todo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TodoDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void createTodo(Todo todo) {
		String query = "INSERT INTO TODO(task, status) VALUES (?, ?)";		
		int rows = jdbcTemplate.update(query, todo.getTask(), todo.getStatus());		
	}

	public void updateTodo(Todo todo) {
		SqlParameterSource namedParameters=new MapSqlParameterSource()
				.addValue("id", todo.getId())
		.addValue("task", todo.getTask())
		.addValue("status", todo.getStatus());		
		
		String query="UPDATE TODO SET task = :task, status = :status  WHERE id = :id";
		namedParameterJdbcTemplate.update(query, namedParameters);
	}

	public List<Todo> getAllTodo() {
		String query = "SELECT * FROM TODO";
		List<Todo> list = jdbcTemplate.query(query, new TodoRowMapper());
		log.info("todo data {}", list);
		return list;
	}
	

}
