package study.test.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.test.DTO.UserDTO;
import study.test.domain.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

//    @BeforeEach
//    void setUp() {
//        userRepository = mock(UserRepositoryImpl.class);
//        userService = new UserServiceImpl(userRepository);
//    }
//
//    @Test
//    void addUser() {
//        User user = new User(1L, "johnDoe", "John Doe", new BigDecimal("100.00"));
//
//        userService.addUser(user);
//
//        verify(userRepository, times(1)).addUser(user);
//    }
//
//    @Test
//    void findById() {
//        User user = new User(1L, "johnDoe", "John Doe", new BigDecimal("100.00"));
//
//        when(userRepository.findUserById(1L)).thenReturn(user);
//
//        User foundUser = userService.findUser(1L);
//
//        assertNotNull(foundUser);
//        assertEquals(user.getId(), foundUser.getId());
//        assertEquals(user.getUsername(), foundUser.getUsername());
//        assertEquals(user.getName(), foundUser.getName());
//        assertEquals(user.getAmount(), foundUser.getAmount());
//    }
//
//    @Test
//    void getAllUsers() {
//        List<User> users = new ArrayList<>();
//        users.add(new User(1L, "johnDoe", "John Doe", new BigDecimal("100.00")));
//        users.add(new User(2L, "janeDoe", "Jane Doe", new BigDecimal("150.00")));
//
//        when(userRepository.findAllUsers()).thenReturn(users);
//
//        List<User> allUsers = userService.getAllUsers();
//
//        assertNotNull(allUsers);
//        assertEquals(2, allUsers.size());
//        assertEquals("johnDoe", allUsers.get(0).getUsername());
//        assertEquals("janeDoe", allUsers.get(1).getUsername());
//    }

    @Test
    @DisplayName("멤버 생성 테스트")
    void createMember(){
        // when
        User user = User.builder()
                .username("testUsername")
                .name("testName")
                .amount(BigDecimal.valueOf(100))
                .build();

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setName(user.getName());
        userDTO.setAmount(user.getAmount());

        userService.addUser(userDTO);

        Assertions.assertThat(user.getName()).isEqualTo("testName");
    }
}
