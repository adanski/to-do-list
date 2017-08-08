package pl.pollub.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
public class TaskList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private User owner;
    @ManyToMany(mappedBy = "taskLists", fetch = FetchType.EAGER)
    private List<User> collaborators = new ArrayList<>();
    @ElementCollection
    private Map<Long, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        Long taskId = task.getId();

        if (!tasks.containsKey(taskId)) {
            tasks.put(taskId, task);
        }
        else {
            throw new RuntimeException("addTask(): task already exists in list.");
        }
    }

    public void removeTask(Task task) {
        Long taskId = task.getId();
        tasks.remove(taskId);
    }
}
