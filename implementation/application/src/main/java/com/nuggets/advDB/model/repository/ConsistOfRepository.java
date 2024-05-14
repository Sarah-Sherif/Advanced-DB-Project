package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.ConsistOf;
import com.nuggets.advDB.model.ConsistOfId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsistOfRepository extends JpaRepository<ConsistOf, ConsistOfId> {
}