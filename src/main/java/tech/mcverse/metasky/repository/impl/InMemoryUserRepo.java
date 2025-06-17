// 4. In-Memory User Repository Implementation
package tech.mcverse.metasky.repository.impl;
import org.springframework.stereotype.Repository;
import tech.mcverse.metasky.model.User;
import tech.mcverse.metasky.repository.UserRepo;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepo implements UserRepo {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public InMemoryUserRepo() {
        initializeTestData();
    }

    private void initializeTestData() {
        // Create some test users for MVP
        createUser("john.doe@email.com", "John", "Doe", "+1-555-0101");
        createUser("jane.smith@email.com", "Jane", "Smith", "+1-555-0102");
        createUser("bob.wilson@email.com", "Bob", "Wilson", "+1-555-0103");
        createUser("alice.brown@email.com", "Alice", "Brown", "+1-555-0104");
        createUser("charlie.davis@email.com", "Charlie", "Davis", "+1-555-0105");
    }

    private void createUser(String email, String firstName, String lastName, String phone) {
        User user = new User(firstName, lastName, email, phone);
        user.setUserId("USER" + idGenerator.getAndIncrement());
        users.put(user.getUserId(), user);
    }

    @Override
    public User save(User user) {
        if (user.getUserId() == null) {
            user.setUserId("USER" + idGenerator.getAndIncrement());
        }
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void deleteById(String id) {
        users.remove(id);
    }

    @Override
    public boolean existsById(String id) {
        return users.containsKey(id);
    }

    @Override
    public long count() {
        return users.size();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.values().stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst();
    }

    @Override
    public List<User> findByFirstNameContaining(String firstName) {
        return users.values().stream()
                .filter(user -> user.getFirstName().toLowerCase().contains(firstName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> findByLastNameContaining(String lastName) {
        return users.values().stream()
                .filter(user -> user.getLastName().toLowerCase().contains(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }
}