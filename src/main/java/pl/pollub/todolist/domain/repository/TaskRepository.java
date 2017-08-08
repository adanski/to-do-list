package pl.pollub.todolist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.todolist.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(Long id);
}
