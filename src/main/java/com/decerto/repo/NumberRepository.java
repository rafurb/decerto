package com.decerto.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.decerto.repo.model.SomeNumbers;

public interface NumberRepository extends CrudRepository<SomeNumbers, Long> {

    @Query(value = "SELECT * FROM somenumbers n WHERE n.id = 1", nativeQuery = true)
    SomeNumbers getNumber();
}
