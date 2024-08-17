package io.riwi.weekly_workshop.Persistance;


import io.riwi.weekly_workshop.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface RepositoryTask extends JpaRepository<Task, Long>{

    public ArrayList<Task> listAllTasks();
}
