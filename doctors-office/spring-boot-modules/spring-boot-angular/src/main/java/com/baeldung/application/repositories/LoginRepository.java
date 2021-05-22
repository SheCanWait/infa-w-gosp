package com.baeldung.application.repositories;

import com.baeldung.application.entities.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginData, Long> {

    @Query(value = "SELECT CASE " +
            "WHEN EXISTS " +
            "(SELECT * " +
            "FROM LOGIN_DATA " +
            "WHERE USERNAME=:username) " +
            "THEN CAST (1 AS BIT) " +
            "ELSE CAST (0 AS BIT) " +
            "END",
           nativeQuery = true)
    boolean doesUserAlreadyExist(@Param("username") String username);

    @Query(value = "INSERT INTO " +
            "LOGIN_DATA (LOGIN, PASSWORD) " +
            "VALUES (:username, :password)",
            nativeQuery = true)
    void register(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT COUNT(LOGIN) FROM LOGIN_DATA WHERE LOGIN:=username AND PASSWORD=:password",
            nativeQuery = true)
    Integer login(@Param("username") String username, @Param("password") String password);
}