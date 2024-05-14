package com.nuggets.advDB.service;

public interface OfferService {

    /*
    -- Inserting Components offered by which supplier
INSERT INTO `Offers`(`Component_Model`, `S_SSN`)
VALUES
		('A123', '70101432805243'),
		('A456', '96102103500871'),
		('A789', '91052603700351'),
		('B012', '29304152804122'),
		('B345', '70101432805243'),
		('B678', '96102103500871'),
		('C901', '91052603700351'),
		('C234', '29304152804122'),
		('C567', '70101432805243'),
		('D890', '96102103500871'),
		('D123', '91052603700351'),
		('D456', '29304152804122');
     */

    void insertOffer(String componentModel, String supplierSSN);
}
