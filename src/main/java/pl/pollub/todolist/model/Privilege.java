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
public class Privilege extends NamedEntity {
    @NotNull
    @Size(min = 3, max = 255)
    private String name;
    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }
}
