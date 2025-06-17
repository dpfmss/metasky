// 2. User Repository Interface
package tech.mcverse.metasky.repository;

import tech.mcverse.metasky.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends BaseRepo<User, String> {
    Optional<User> findByEmail(String email);
    List<User> findByFirstNameContaining(String firstName);
    List<User> findByLastNameContaining(String lastName);
}
