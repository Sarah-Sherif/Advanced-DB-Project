package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.PersonPhoneNo;
import com.nuggets.advDB.model.PersonPhoneNoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPhoneNoRepository extends JpaRepository<PersonPhoneNo, PersonPhoneNoId> {

}