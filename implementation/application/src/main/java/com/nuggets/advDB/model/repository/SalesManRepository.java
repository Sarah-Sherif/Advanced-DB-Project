package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.SalesMan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesManRepository extends JpaRepository<SalesMan, String> {
}