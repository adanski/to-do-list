package pl.pollub.todolist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.todolist.domain.TaskList;
import pl.pollub.todolist.domain.User;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    TaskList findById(Long id);
    List<TaskList> findByOwner(User owner);
}
