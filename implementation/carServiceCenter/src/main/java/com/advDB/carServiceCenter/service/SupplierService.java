package com.advDB.carServiceCenter.service;

import java.time.LocalDate;

public interface SupplierService {
    public void insertSupplier(Long ssn, LocalDate birthDate, String email, String firstName, String middleName,
                               String lastName, String website, String phoneNo);

}
