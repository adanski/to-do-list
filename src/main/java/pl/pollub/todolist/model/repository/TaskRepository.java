package pl.pollub.todolist.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(Long id);
}
