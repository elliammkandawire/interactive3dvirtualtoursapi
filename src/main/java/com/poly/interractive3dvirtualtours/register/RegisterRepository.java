package com.poly.interractive3dvirtualtours.register;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Integer>
{
    @Query(nativeQuery = true, value = "SELECT * FROM register")
    List<Register> findAllRegistered();

    @Query(nativeQuery = true, value = "SELECT * FROM register  WHERE id= :id")
    Register findRegisteredById(@Param("id") int id);

}
