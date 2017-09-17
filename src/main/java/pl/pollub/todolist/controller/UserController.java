package pl.pollub.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.pollub.todolist.model.User;
import pl.pollub.todolist.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<User> getAll() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody User add(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public @ResponseBody User get(@PathVariable(value = "userId") Long userId) {
        return userService.findById(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "userId") Long userId, @RequestBody User user) {
        user.setId(userId);
        userService.saveOrUpdate(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "userId") Long userId) {
        userService.delete(userId);
    }
}
