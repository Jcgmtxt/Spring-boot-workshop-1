package io.riwi.weekly_workshop.Controller;

import io.riwi.weekly_workshop.Entities.Task;
import io.riwi.weekly_workshop.Service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController {
    @Autowired
    private ServiceTask service;


}
