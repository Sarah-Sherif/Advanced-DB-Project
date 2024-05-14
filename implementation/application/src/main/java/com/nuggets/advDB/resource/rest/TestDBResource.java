package com.nuggets.advDB.resource.rest;

import com.nuggets.advDB.model.TestDB;
import com.nuggets.advDB.model.repository.TestDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestDBResource {

    @Autowired
    private TestDBRepository testDBRepository;

    // This method is used to test the connection to the database
    @GetMapping("/testDB")
    public List<TestDB> getAll() {
        return testDBRepository.findAll();
    }
}
