package io.riwi.weekly_workshop.Service;

import io.riwi.weekly_workshop.Entities.Task;
import io.riwi.weekly_workshop.Persistance.RepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceTask {

    @Autowired
    private RepositoryTask repositoryTask;

    public List<Task> findAll(){
        return repositoryTask.findAll();
    }

    public void save(Task task){
        repositoryTask.save(task);
    }

    public Task getById(Long id){
        return repositoryTask.findById(id).orElse(null);
    }

    public void delete(Long id){
        repositoryTask.deleteById(id);
    }


}
