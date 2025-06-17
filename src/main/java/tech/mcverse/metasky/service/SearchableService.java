
package tech.mcverse.metasky.service;

import java.util.List;

public interface SearchableService<T, R> {
    List<R> search(T request);
}
