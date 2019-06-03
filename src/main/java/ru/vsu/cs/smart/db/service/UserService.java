package ru.vsu.cs.smart.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User find(Long id) {
        return userRepository.getOne(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
