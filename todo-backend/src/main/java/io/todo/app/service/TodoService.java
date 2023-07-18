package io.todo.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import io.todo.app.dao.TodoDao;
import io.todo.app.dao.model.Todo;

@Service
public class TodoService {

	@Autowired
	TodoDao todoDao;
	
	public void createTodo(Todo todo) {
		todoDao.createTodo(todo);		
	}

	public void updateTodo(Todo todo) {
		todoDao.updateTodo(todo);		
	}

	public Map<String, List<Todo>> getAllTodoGroupByStatus() {
		List<Todo> list =  todoDao.getAllTodo();
		Map<String,List<Todo>> groupByStatusTodo = new HashMap<>();
		List<Todo> newTodos = new ArrayList<>(); 
		List<Todo> processTodos = new ArrayList<>(); 
		List<Todo> completeTodos = new ArrayList<>(); 
		
		for(Todo todo: list) {
			if("new".equals(todo.getStatus())) {
				newTodos.add(todo);
			}else if("process".equals(todo.getStatus())) {
				processTodos.add(todo);
			}else if("complete".equals(todo.getStatus())) {
				completeTodos.add(todo);
			}
		}
		
		groupByStatusTodo.put("new", newTodos);
		groupByStatusTodo.put("process", processTodos);
		groupByStatusTodo.put("complete", completeTodos);
		return groupByStatusTodo;
		
	}

}
