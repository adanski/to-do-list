package pl.pollub.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.pollub.todolist.model.TaskList;
import pl.pollub.todolist.service.TaskListService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskListController {
    private final TaskListService taskListService;

    @Autowired
    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<TaskList> getAll() {
        return taskListService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody TaskList add(@RequestBody TaskList taskList) {
        return taskListService.saveOrUpdate(taskList);
    }

    @RequestMapping(value = "/{taskListId}", method = RequestMethod.GET)
    public @ResponseBody TaskList get(@PathVariable(value = "taskListId") Long taskListId) {
        return taskListService.findById(taskListId);
    }

    @RequestMapping(value = "/{taskListId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "taskListId") Long taskListId, @RequestBody TaskList taskList) {
        taskList.setId(taskListId);
        taskListService.saveOrUpdate(taskList);
    }

    @RequestMapping(value = "/{taskListId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "taskListId") Long taskListId) {
        taskListService.delete(taskListId);
    }
}
