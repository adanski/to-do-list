package pl.pollub.todolist.service;

import pl.pollub.todolist.model.TaskList;

import java.util.List;

public interface TaskListService {
    TaskList saveOrUpdate(TaskList taskList);
    TaskList findById(Long id);
    List<TaskList> findAll();
    void delete(Long id);
    void delete(TaskList taskList);
}
