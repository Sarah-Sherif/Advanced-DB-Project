-- Inserting person 
INSERT INTO `Person` (`SSN`, `Birthdate`, `Email`, `First_Name`, `Middle_Name`, `Last_Name`)
VALUES 
    ('96012101300120', '1996-01-21', 'ahmed.mohamed@gmail.com', 'Ahmed', 'Mohamed', 'Ali'),
    ('93071701200417', '1993-07-17', 'yasmine.ahmed@gmail.com', 'Yasmine', 'Ahmed', 'Khalil'),
    ('91020901100485', '1991-02-09', 'mohamed.karim@gmail.com', 'Mohamed', 'Karim', 'Said'),
    ('88112501100176', '1988-11-25', 'nour.eldeen.mostafa@gmail.com', 'Nour Eldeen', 'Mostafa', 'Abdallah'),
    ('98031201500319', '1998-03-12', 'nada.mahmoud@gmail.com', 'Nada', 'Mahmoud', 'Mahmoud'),
    ('94060901200185', '1994-06-09', 'mohamed.mohsen@gmail.com', 'Mohamed', 'Mohsen', 'Gaber'),
    ('90052301300185', '1990-05-23', 'reem.ahmed@gmail.com', 'Reem', 'Ahmed', 'Hassan'),
    ('29304152804122', '1992-06-15', 'ahmed.mohamed@gmail.com', 'Ahmed', 'Ali', 'Mohamed'),
    ('70101432805243', '1985-02-25', 'fatma.hassan@gmail.com', 'Fatma', 'Mahmoud', 'Hassan'),
    ('24703082706851', '1997-08-27', 'nour.eldeen.mahmoud@gmail.com', 'Nour Eldeen', NULL, 'Mahmoud'),
    ('28801032905237', '1994-03-29', 'marwa.abdullah@gmail.com', 'Marwa', 'Mohamed', 'Abdullah'),
    ('78701252907252', '1989-12-05', 'youssef.samir@gmail.com', 'Youssef', 'Samir', 'Mohamed'),
    ('12345678901234', '1980-05-12', 'ahmed123@gmail.com', 'Ahmed', 'Ali', 'Khalil'),
    ('23456789012345', '1995-02-28', 'mohamed456@gmail.com', 'Mohamed', NULL, 'Hassan'),
    ('95022501200146', '1995-02-25', 'kareem.ahmed@gmail.com', 'Kareem', 'Ahmed', 'Hassan'),
    ('97010701700418', '1997-01-07', 'ahmed.farouk@gmail.com', 'Ahmed', 'Farouk', 'Saeed'),
	('88061701300306', '1988-06-17', 'mona.hamdy@gmail.com', 'Mona', 'Hamdy', 'Ali'),
	('91052101500785', '1991-05-21', 'nour.salah@gmail.com', 'Nour', 'Salah', 'Hassan'),
    ('96102103500871', '1996-10-21', 'ahmedmohamed@gmail.com', 'Mostafa', 'Mohamed', 'Ali'),
	('91052603700351', '1991-05-26', 'fatmahassan@gmail.com', 'Fatma', 'Hassan', 'Saleh');
-- -----------------------------------------------------------------------------------------------------------------
-- Inserting Phone numbers
INSERT INTO `Person_Phone_NO` (`SSN`, `Phone_NO`)
VALUES ('96012101300120', '01234567890'),
       ('93071701200417', '01234567891'),
       ('91020901100485', '01234567892'),
       ('88112501100176', '01234567893'),
       ('98031201500319', '01234567894'),
       ('29304152804122', '01234567895'),
       ('90052301300185', '01234567896'),
       ('94060901200185', '01234567897'),
       ('29304152804122', '01028571935'),
       ('70101432805243', '01190736521'),
       ('24703082706851', '01062980431'),
       ('28801032905237', '01135716849'),
       ('78701252907252', '01268357469'),
       ('12345678901234', '01234567890'),
       ('23456789012345', '01123456789'),
       ('97010701700418', '01012345678'),
	   ('88061701300306', '01123456789'),
	   ('91052101500785', '01234567890'),
       ('96102103500871', '01099887766'),
	   ('91052603700351', '01233445566');
-- -----------------------------------------------------------------------------------------------------------------
-- Inserting customers
INSERT INTO `Customer`(`C_SSN`, `City`, `Street_NO`, `Building_NO`, `District`)
VALUES
		('97010701700418', 'Cairo', 23, 5, 'Maadi'),
		('88061701300306', 'Alexandria', 16, 8, 'Gleem'),
		('91052101500785', 'Giza', 7, 12, 'Mohandeseen'),
        ('24703082706851', 'Giza', 15, 45, 'El Mohandessin'),
		('28801032905237', 'Alexandria', 10, 23, 'Sidi Gaber'),
		('78701252907252', 'Cairo', 5, 12, 'Nasr City');
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting suppliers
INSERT INTO `Supplier` (`S_SSN`, `Website`) 
VALUES  ('70101432805243', 'https://egyptiancarservice.com'),
		('96102103500871', 'https://www.egyptianautoparts.com'),
        ('91052603700351', 'https://www.egyptiancarparts.com'),
        ('29304152804122', 'https://www.servemycar.com');
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Service Centers
INSERT INTO `Service_Center` (`City`, `Street_NO`, `Building_NO`, `District`, `M_SSN`) 
VALUES 
		('Cairo', 10, 25, 'Giza', '12345678901234'),
		('Alexandria', 5, 12, 'Raml Station', '23456789012345');
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Employees
INSERT INTO `Employee` (`E_SSN`, `Salary`, `Center_ID`, `Role`)
VALUES 
    ('96012101300120', 15000.00, 1, 'Engineer'),
    ('93071701200417', 18000.00, 2, 'Sales Man'),
    ('91020901100485', 12000.00, 2, 'Engineer'),
    ('88112501100176', 20000.00, 1, 'Sales Man'),
    ('98031201500319', 9000.00, 2, 'Engineer'),
    ('94060901200185', 17000.00, 2, 'Sales Man'),
    ('90052301300185', 14000.00, 1, 'Engineer'),
    ('95022501200146', 11000.00, 2, 'Sales Man');
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Engineers
INSERT INTO `Engineer` (`E_SSN`)
SELECT `E_SSN`
FROM `Employee`
WHERE `Role` = 'Engineer';
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Sales Man
INSERT INTO `Sales_Man` (`SM_SSN`)
SELECT `E_SSN`
FROM `Employee`
WHERE `Role` = 'Sales Man';
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Car Models
INSERT INTO `Model`(`Model_Name`, `Model_Year`, `Brand`)
VALUES
    ('Corolla', 2020, 'Toyota'),
    ('Civic', 2021, 'Honda'),
    ('Accord', 2020, 'Honda'),
    ('Camry', 2022, 'Toyota'),
    ('Sunny', 2021, 'Nissan'),
    ('Sentra', 2022, 'Nissan');
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Cars
INSERT INTO `Car`(`Plate_NO`, `Model_Name`, `Model_Year`, `SSN`)
VALUES
    ('CBV100', 'Corolla', 2020, '97010701700418'),
    ('HAD200', 'Civic', 2021, '88061701300306'),
    ('HFG300', 'Accord', 2020, '91052101500785'),
    ('TLO400', 'Camry', 2022, '24703082706851'),
    ('NMB500', 'Sunny', 2021, '28801032905237'),
    ('NKI600', 'Sentra', 2022, '78701252907252');
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Components
INSERT INTO `Component`(`Model`, `Price`)
VALUES
    ('A123', 5000),
    ('A456', 10000),
    ('A789', 8000),
    ('B012', 12000),
    ('B345', 15000),
    ('B678', 9000),
    ('C901', 11000),
    ('C234', 13000),
    ('C567', 7000),
    ('D890', 14000),
    ('D123', 6000),
    ('D456', 8500);

INSERT INTO `Body`(`Model`)
SELECT `Model` 
FROM `Component`
WHERE `Component`.`Model` LIKE 'A%';

INSERT INTO `Battery`(`Model`, `Expiry_Date`)
VALUES  ('B012', '2024-06-30'),
		('B345', '2023-12-31'), 
        ('B678', '2025-03-31');

INSERT INTO `Transmission`(`Model`, `Transmission_Type`)
VALUES  ('C901', 'Automatic'), 
		('C234', 'Manual'), 
        ('C567', 'Automatic');

INSERT INTO `Engine`(`Model`, `Lubricant_Type`, `Horse_Power`)
VALUES  ('D890', 'Synthetic', 300),
		('D123', 'Mineral', 200), 
        ('D456', 'Synthetic', 250);
-- ---------------------------------------------------------------------------------------------------------------
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
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Orders
INSERT INTO `Order`(`Status`, `Payment_Method`, `Date`)
VALUES
		('Delivered', 'Credit', '2023-05-01'),
		('In Progress', 'Cash', '2023-05-02'),
		('In Progress', 'Credit', '2023-05-03'),
		('Completed', 'Cash', '2023-05-04'),
		('Delivered', 'Credit', '2023-05-05'),
		('In Progress', 'Cash', '2023-05-06'),
		('In Progress', 'Cash', '2023-05-08'),
        ('In Progress', 'Credit', '2023-05-08'),
        ('Completed', 'Credit', '2023-05-08'),
        ('Delivered', 'Cash', '2023-05-08'),
        ('In Progress', 'Cash', '2023-05-08'),
		('Delivered', 'Credit', '2023-05-07'),
		('Completed', 'Cash', '2023-05-06'),
		('In Progress', 'Credit', '2023-05-05'),
		('In Progress', 'Cash', '2023-05-04'),
		('Delivered', 'Credit', '2023-05-03'),
		('Completed', 'Cash', '2023-05-02'),
		('In Progress', 'Credit', '2023-05-01')
ON DUPLICATE KEY UPDATE `Status` = VALUES(`Status`);			

INSERT INTO `Repair_Order`(`Order_ID`, `C_SSN`, `City`, `Street_NO`, `Building_NO`, `District`)
VALUES
		(1, '97010701700418', 'Cairo', 23, 5, 'Maadi'),
		(2, '88061701300306', 'Alexandria', 16, 8, 'Gleem'),
		(3, '91052101500785', 'Giza', 7, 12, 'Mohandeseen'),
		(4, '24703082706851', 'Giza', 15, 45, 'El Mohandessin'),
		(5, '28801032905237','Alexandria', 10, 23, 'Sidi Gaber'),
        (6, '78701252907252', 'Cairo', 5, 12, 'Nasr City');
        
INSERT INTO `Purchase_Order`(`Order_ID`, `Delivery_Date`, `S_SSN`)
VALUES  (7, '2023-05-10', '70101432805243'),
        (8, '2023-05-11', '96102103500871'),
        (9, '2023-05-12', '91052603700351'),
        (10, '2023-05-13', '29304152804122'),
        (11, '2023-05-12', '70101432805243'),
		(12, '2023-05-11', '96102103500871'),
		(13, '2023-05-10', '91052603700351'),
		(14, '2023-05-09', '29304152804122'),
		(15, '2023-05-16', '70101432805243'),
		(16, '2023-05-15', '96102103500871'),
		(17, '2023-05-14', '91052603700351'),
		(18, '2023-05-13', '29304152804122');
        
INSERT INTO `Consist_OF` (`Order_ID`, `Component_Model`, `Quantity`)
VALUES
		(7, 'A123', 2),
		(8, 'A456', 1),
		(9, 'A789', 3),
		(10, 'B012', 2),
		(11, 'B345', 4),
		(12, 'B678', 1),
		(13, 'C901', 2),
		(14, 'C234', 2),
		(15, 'C567', 1),
		(16, 'D890', 3),
		(17, 'D123', 2),
		(18, 'D456', 2);
-- ---------------------------------------------------------------------------------------------------------------
-- Inserting Maintenance Tasks
INSERT INTO `Maintenance_Task`(`Task_Date`, `Price`, `Center_ID`, `Plate_NO`, `Order_ID`, `Component_Model`)
VALUES
		('2023-05-01', 8000, 1, 'CBV100', 1, 'A123'),
		('2023-05-02', 10000, 2, 'HAD200', 2, 'B345'),
		('2023-05-03', 9000, 1, 'HFG300', 3, 'C567'),
		('2023-05-04', 12000, 1, 'TLO400', 4, 'D890'),
		('2023-05-05', 15000, 2, 'NMB500', 5, 'A456'),
		('2023-05-06', 7000, 1, 'NKI600', 6, 'B678');
        

INSERT INTO `Performs`(`SSN`, `Task_ID`)
VALUES
		('96012101300120', 1),
		('98031201500319', 2),
		('96012101300120', 3),
		('98031201500319', 4),
		('96012101300120', 5),
		('98031201500319', 6);