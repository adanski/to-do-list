package pl.pollub.todolist.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskList implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
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
