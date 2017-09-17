package pl.pollub.todolist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
public class Role extends BaseEntity {
    @NotNull
    @Size(min = 3, max = 255)
    private String name;
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<User> users;
    @ManyToMany
    @JoinColumn
    private Set<Privilege> privileges;

    public Set<Privilege> getPrivileges() {
        return Collections.unmodifiableSet(privileges);
    }
}
