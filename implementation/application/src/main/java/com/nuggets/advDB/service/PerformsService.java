package com.nuggets.advDB.service;

public interface PerformsService {

    /*
    INSERT INTO `Performs`(`SSN`, `Task_ID`)
VALUES
		('96012101300120', 1),
		('98031201500319', 2),
		('96012101300120', 3),
		('98031201500319', 4),
		('96012101300120', 5),
		('98031201500319', 6);
     */

    void insertPerforms(String ssn, Long taskID);
}
