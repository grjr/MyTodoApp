package com.gj.mytodoapp.controllers;

import com.gj.mytodoapp.models.TodoItem;
import com.gj.mytodoapp.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;


@Controller
public class HomePageController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("message", "My Todo List!");
        model.addAttribute("todolistall", todoService.listAllTodos());
        return "homepage";

    }

    @GetMapping("/add")
    public String addNewTodo(Model model){
        TodoItem todoItem = new TodoItem();
        model.addAttribute("todoItem", todoItem);
        return "addtodo";
    }

    @PostMapping("/save")
    public String saveTodo(@ModelAttribute("todoItem") TodoItem todoItem){
        todoService.saveTodo(todoItem);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodo(@PathVariable(value="id") Long id, Model model){
        TodoItem todoItem = todoService.getTodoById(id);
        model.addAttribute("todoItem", todoItem);
        return "edittodo";
    }

    @PostMapping("/update")
    public String updateTodo(@ModelAttribute("todoItem") TodoItem todoItem){
        TodoItem updatedTodoItem = todoService.getTodoById(todoItem.getId());
        updatedTodoItem.setName(todoItem.getName());
        updatedTodoItem.setDescription(todoItem.getDescription());
        todoService.saveTodo(updatedTodoItem);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id){
        try{
            todoService.deleteTodoById(id);
        }
        catch (NoSuchElementException e){
            return "Item not found!";
        }
        catch (Exception e){
            return "An error occured..";
        }
        return "redirect:/";
    }
}

