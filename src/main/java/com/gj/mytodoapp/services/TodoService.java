package com.gj.mytodoapp.services;

import com.gj.mytodoapp.models.TodoItem;

import java.util.List;

public interface TodoService {
    public List<TodoItem> listAllTodos();

    public void saveTodo(TodoItem todoItem);

    TodoItem getTodoById(Long id);

    public void deleteTodoById(Long id);
}
