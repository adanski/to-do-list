package pl.pollub.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollub.todolist.model.TaskList;
import pl.pollub.todolist.model.repository.TaskListRepository;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    @Autowired
    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public TaskList saveOrUpdate(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @Override
    public TaskList findById(Long id) {
        return taskListRepository.findById(id);
    }

    @Override
    public List<TaskList> findAll() {
        return taskListRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        taskListRepository.delete(id);
    }

    @Override
    public void delete(TaskList taskList) {
        taskListRepository.delete(taskList);
    }
}
