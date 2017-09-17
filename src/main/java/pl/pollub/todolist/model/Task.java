package pl.pollub.todolist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Entity
public class Task extends BaseEntity {
    private Priority priority = Priority.DEFAULT_PRIORITY;
    @NotNull
    @Lob
    @Size(min = 3)
    private String content;
    private User assignee;
}
