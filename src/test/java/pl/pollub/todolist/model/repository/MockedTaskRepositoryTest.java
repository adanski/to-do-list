package pl.pollub.todolist.model.repository;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockedTaskRepositoryTest {
    @InjectMocks
    private TaskRepository taskRepository;
    @Mock
    private UserRepository userRepository = Mockito.mock(UserRepository.class);

    @Before
    public void setup() {

    }
}
