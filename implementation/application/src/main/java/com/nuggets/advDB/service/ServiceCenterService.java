package com.nuggets.advDB.service;

public interface ServiceCenterService {
    public void insertServiceCenter(String city, Integer streetNo, Long buildingNo, String district, String managerSSN);

    public void incrementServiceCenterNoOfEmployees(Long centerID);
}
