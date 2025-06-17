// 7. User Service for User Management
package tech.mcverse.metasky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.mcverse.metasky.model.User;
import tech.mcverse.metasky.repository.UserRepo;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepository;

    @Autowired
    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> searchUsersByName(String name) {
        List<User> byFirstName = userRepository.findByFirstNameContaining(name);
        List<User> byLastName = userRepository.findByLastNameContaining(name);

        // Combine and deduplicate
        byFirstName.addAll(byLastName);
        return byFirstName.stream().distinct().toList();
    }

    public boolean userExists(String userId) {
        return userRepository.existsById(userId);
    }

    public long getTotalUsers() {
        return userRepository.count();
    }
}