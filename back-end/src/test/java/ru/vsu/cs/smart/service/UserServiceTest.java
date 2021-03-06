package ru.vsu.cs.smart.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.repository.UserRepository;
import ru.vsu.cs.smart.db.service.UserService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceTest {
    @TestConfiguration
    static class UserServiceTestConfiguration {
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User alice = new User();
        alice.setUsername("alice@mail.com");

        Mockito.when(userRepository.findByUsername(alice.getUsername()))
                .thenReturn(alice);
    }

    @Test
    public void testGetByUsername() {
        String username = "alice@mail.com";
        User found = userService.findByUsername(username);

        assertThat(found.getUsername()).isEqualTo(username);
    }
}
