package com.gj.mytodoapp.repos;

import com.gj.mytodoapp.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<TodoItem, Long> {
}
