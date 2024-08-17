package io.riwi.weekly_workshop.Controller;

import io.riwi.weekly_workshop.Entities.Task;
import io.riwi.weekly_workshop.Entities.TaskState;
import io.riwi.weekly_workshop.Model.ServiceTask;
import io.riwi.weekly_workshop.Persistance.RepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class TaskController {
    @Autowired
    private ServiceTask service;

    @GetMapping("/")
    public String viewIndex(Model model){
        model.addAttribute("Task",service.findAll());
        return "index";
    }

    @GetMapping("/New")
    public String ShowNewProductForm (Model model){
        model.addAttribute("Task", new Task());
        return "new_task";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveTask(Task task) {
        task.setCreationDate(LocalDate.now());
        task.setTimeCreation(LocalTime.now());
        task.setState(TaskState.PENDING);
        System.out.println(task);
        if (task.getDescription() == null || task.getDescription().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Description cannot be null or empty");
        }
        service.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Task saved successfully");
    }


    @GetMapping("/edit")
    public String showEditTaskForm(@RequestParam Long id, Model model){
        model.addAttribute("Task", service.getById(id));
        return "task_edit";
    }

    @GetMapping("/delete")
    public String TaskDelete(@RequestParam Long id){
        service.delete(id);
        return "redirect:/";
    }
}
