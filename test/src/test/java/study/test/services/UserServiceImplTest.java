package study.test.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.test.domain.User;
import study.test.repositories.UserRepositoryImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepositoryImpl userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepositoryImpl.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void addUser() {
        User user = new User(1L, "johnDoe", "John Doe", new BigDecimal("100.00"));

        userService.addUser(user);

        verify(userRepository, times(1)).addUser(user);
    }

    @Test
    void findById() {
        User user = new User(1L, "johnDoe", "John Doe", new BigDecimal("100.00"));

        when(userRepository.findUserById(1L)).thenReturn(user);

        User foundUser = userService.findUser(1L);

        assertNotNull(foundUser);
        assertEquals(user.getId(), foundUser.getId());
        assertEquals(user.getUsername(), foundUser.getUsername());
        assertEquals(user.getName(), foundUser.getName());
        assertEquals(user.getAmount(), foundUser.getAmount());
    }

    @Test
    void getAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "johnDoe", "John Doe", new BigDecimal("100.00")));
        users.add(new User(2L, "janeDoe", "Jane Doe", new BigDecimal("150.00")));

        when(userRepository.findAllUsers()).thenReturn(users);

        List<User> allUsers = userService.getAllUsers();

        assertNotNull(allUsers);
        assertEquals(2, allUsers.size());
        assertEquals("johnDoe", allUsers.get(0).getUsername());
        assertEquals("janeDoe", allUsers.get(1).getUsername());
    }
}
