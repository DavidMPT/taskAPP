package com.project.contactlist.service;

import com.project.contactlist.model.Task;
import com.project.contactlist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasksByUser(String user) {
        return taskRepository.findByUserName(user);
    }

    @Override
    public Optional< Task > getTaskById(long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void addTask(String name, String desc, Date targetDate, boolean isDone) {
        taskRepository.save(new Task(name, desc, targetDate, isDone));
    }

    @Override
    public void deleteTask(long id) {
        Optional < Task > task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        }
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
