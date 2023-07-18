package io.todo.app.dao.model;

import lombok.Data;

@Data
public class Todo {
	private int id;
	private String task;
	private String status;
}
