package pl.pollub.todolist.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.todolist.model.TaskList;
import pl.pollub.todolist.model.User;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    TaskList findById(Long id);
    List<TaskList> findByOwner(User owner);
}
