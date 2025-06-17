// 1. Base Repository Interface
package tech.mcverse.metasky.repository;

import tech.mcverse.metasky.service.UserService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface BaseRepo<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    boolean existsById(ID id);
    long count();
}









