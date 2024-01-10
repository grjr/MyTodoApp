package com.gj.mytodoapp.Config;

import com.gj.mytodoapp.models.TodoItem;
import com.gj.mytodoapp.repos.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class SeedInitialData implements CommandLineRunner {

    @Autowired
    private TodoRepo todoRepo;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() {
        if(todoRepo.count()==0){
            TodoItem todoItem1 = new TodoItem();
            todoItem1.setName("Get Milk");
            todoItem1.setDescription("Groceries");
            todoItem1.setCreatedAt(Instant.now());
            todoItem1.setUpdatedAt(Instant.now());
            todoItem1.setCompleted(false);

            TodoItem todoItem2 = new TodoItem();
            todoItem2.setName("Refill meds");
            todoItem2.setDescription("Pharmacy");
            todoItem2.setCreatedAt(Instant.now());
            todoItem2.setUpdatedAt(Instant.now());
            todoItem2.setCompleted(false);

            //Save these to repo
            todoRepo.save(todoItem1);
            todoRepo.save(todoItem2);

        }
    }
}
