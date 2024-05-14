package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.TestDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDBRepository extends JpaRepository<TestDB, Long> {
}
