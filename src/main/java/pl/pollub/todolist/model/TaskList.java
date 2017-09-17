package pl.pollub.todolist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
public class TaskList extends NamedEntity {
    @NotNull
    private User owner;
    @ManyToMany(mappedBy = "taskLists", fetch = FetchType.EAGER)
    private Set<User> collaborators;
    @ElementCollection
    private Set<Task> tasks;

    public boolean addTask(Task task) {
        return tasks.add(task);
    }

    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    public Set<Task> getTasks() {
        return Collections.unmodifiableSet(tasks);
    }
}
