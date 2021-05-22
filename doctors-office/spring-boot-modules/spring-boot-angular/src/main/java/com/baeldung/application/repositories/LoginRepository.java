package com.baeldung.application.repositories;

import com.baeldung.application.entities.LoginData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<LoginData, Long> {
}
