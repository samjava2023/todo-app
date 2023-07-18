package io.todo.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.todo.app.dao.model.Todo;
import io.todo.app.service.TodoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/todo")
@CrossOrigin
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@PostMapping
	public void createTodo(@RequestBody Todo todo){
		log.info("Inside createTodo()");
		todoService.createTodo(todo);
	}
	
	@PutMapping("/{id}")
	public void updateTodo(@PathVariable int id, @RequestBody Todo todo) {
		log.info("Inside updateTodo()");
		todo.setId(id);
		todoService.updateTodo(todo);
	}
	
	@GetMapping
	public Map<String, List<Todo>> getAllTodoGroupByStatus() {
		log.info("Inside getAllTodoGroupByStatus()");
		return todoService.getAllTodoGroupByStatus();
	}
	
	@DeleteMapping
	public void deleteTodo() {
		log.info("Inside deleteTodo()");
	}

}
