package io.riwi.weekly_workshop.Model;

import io.riwi.weekly_workshop.Entities.Task;
import io.riwi.weekly_workshop.Persistance.RepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTask {

    @Autowired
    private RepositoryTask repositoryTask;

    public List<Task> findAll(){
        return repositoryTask.findAll();
    }

    public Task save(Task task){
        repositoryTask.save(task);
        return task;
    }

    public Task getById(Long id){
        return repositoryTask.findById(id).orElse(null);
    }

    public void delete(Long id){
        repositoryTask.deleteById(id);
    }

}

