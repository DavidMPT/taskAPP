package com.project.contactlist.service;

import com.project.contactlist.model.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<Task> getTasksByUser(String user);

    Optional<Task> getTaskById(long id);

    void updateTask(Task task);

    void addTask(String name, String desc, Date targetDate, boolean isDone);

    void deleteTask(long id);

    void saveTask(Task task);
}
