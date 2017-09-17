package pl.pollub.todolist.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.todolist.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByUserName(String userName);
}
