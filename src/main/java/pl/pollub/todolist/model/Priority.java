package pl.pollub.todolist.model;

public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    URGENT,
    IMMEDIATE;

    public static final Priority DEFAULT_PRIORITY = Priority.NORMAL;
}
