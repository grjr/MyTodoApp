package com.gj.mytodoapp.services;

import com.gj.mytodoapp.models.TodoItem;
import com.gj.mytodoapp.repos.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepo todoRepo;
    @Override
    public List<TodoItem> listAllTodos() {
        return todoRepo.findAll();
    }

    @Override
    public void saveTodo(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now());
        }
        todoItem.setUpdatedAt(Instant.now());
        todoRepo.save(todoItem);
    }

    @Override
    public TodoItem getTodoById(Long id) {
        TodoItem todoItem = null;
        if(Objects.nonNull(id)) {
            Optional<TodoItem> optionalTodoItem = todoRepo.findById(id);

            if(optionalTodoItem.isPresent())
                todoItem=optionalTodoItem.get();
            else
                throw new RuntimeException("Todo not found!!");
        }
        return todoItem;
    }

    @Override
    public void deleteTodoById(Long id) {
        if(Objects.nonNull(id)) {
            todoRepo.deleteById(id);
        }
    }
}
