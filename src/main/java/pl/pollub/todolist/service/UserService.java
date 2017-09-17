package pl.pollub.todolist.service;

import pl.pollub.todolist.model.User;

import java.util.List;

public interface UserService {
    User saveOrUpdate(User user);
    User findById(Long id);
    List<User> findAll();
    void delete(Long id);
    void delete(User user);
}
