package org.deserializationError.repositories;

import org.deserializationError.domain.Class1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeodeRepository extends CrudRepository<Class1, Integer> {
}
