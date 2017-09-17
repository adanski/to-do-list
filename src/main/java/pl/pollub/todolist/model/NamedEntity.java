package pl.pollub.todolist.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {
    @NotNull
    @Size(min = 3, max = 255)
    private String name;
}
