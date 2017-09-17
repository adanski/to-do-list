package pl.pollub.todolist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends NamedEntity {
    @NotNull
    @Size(min = 6, max = 255)
    private String password;
    @NotNull
    @Size(min = 6, max = 255)
    private String email;
    @ManyToMany
    @JoinColumn
    private Set<TaskList> taskLists;
    @ManyToMany
    @JoinColumn
    private Set<Role> roles;

    public Set<TaskList> getTaskLists() {
        return Collections.unmodifiableSet(taskLists);
    }
}
