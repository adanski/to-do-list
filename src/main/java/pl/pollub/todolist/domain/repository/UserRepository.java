package pl.pollub.todolist.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollub.todolist.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
    User findByUserName(String userName);
}
