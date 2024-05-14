CREATE TABLE `Person` (
	`SSN` CHAR(14) CHECK (`SSN` REGEXP '^[0-9]{14}$'),
    `Birthdate` DATE,
    `Email` VARCHAR(50) , 
    `First_Name` VARCHAR(50) NOT NULL,
    `Middle_Name` VARCHAR(50),
    `Last_Name` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`SSN`)
);

CREATE TABLE `Person_Phone_NO` (
	`SSN` CHAR(14),
    `Phone_NO` CHAR(11),
    PRIMARY KEY (`SSN` , `Phone_NO`),
    FOREIGN KEY (`SSN`) REFERENCES `Person`(`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Customer`(
	`C_SSN` CHAR(14) ,
    `City` VARCHAR(20) NOT NULL ,
    `Street_NO` SMALLINT UNSIGNED NOT NULL,
    `Building_NO` INT UNSIGNED NOT NULL,
    `District` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`C_SSN`),
    FOREIGN KEY (`C_SSN`) REFERENCES `Person`(`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Supplier`(
	`S_SSN` CHAR(14) ,
    `Website` VARCHAR(255) ,
    PRIMARY KEY(`S_SSN`),
    FOREIGN KEY (`S_SSN`) REFERENCES `Person`(`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `Service_Center`(
	`Center_ID` INT UNSIGNED AUTO_INCREMENT,
    `NO_of_Employees` INT UNSIGNED DEFAULT 0,
    `City` VARCHAR(20) NOT NULL ,
    `Street_NO` SMALLINT UNSIGNED NOT NULL,
    `Building_NO` INT UNSIGNED NOT NULL,
    `District` VARCHAR(20) NOT NULL,
    `M_SSN`CHAR(14) NOT NULL ,
    PRIMARY KEY (`Center_ID`) ,
    FOREIGN KEY (`M_SSN`) REFERENCES `Employee`(`E_SSN`) ON DELETE RESTRICT ON UPDATE CASCADE
)AUTO_INCREMENT = 1;

CREATE TABLE `Employee` (
	`E_SSN`CHAR(14),
    `Salary` FLOAT UNSIGNED NOT NULL CHECK(`Salary` != 0) ,
    `Center_ID`INT UNSIGNED NOT NULL,
    `Role` ENUM('Engineer', 'Sales Man', 'Janitor','Cashier') NOT NULL,
    PRIMARY KEY (`E_SSN`),
    FOREIGN KEY (`Center_ID`) REFERENCES `Service_Center`(`Center_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(`E_SSN`) REFERENCES `Person`(`SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `Sales_Man`(
	`SM_SSN` CHAR(14) ,
    `Sales_Made` INT UNSIGNED, 
    PRIMARY KEY (`SM_SSN`) ,
    FOREIGN KEY(`SM_SSN`) REFERENCES `Employee`(`E_SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Engineer`(
	`E_SSN` char(14) , 
    `Specialization` VARCHAR(50),
    PRIMARY KEY (`E_SSN`),
    FOREIGN KEY (`E_SSN`) REFERENCES `Employee`(`E_SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Model`(
	`Model_Name` VARCHAR(10),
    `Model_Year`YEAR,
    `Brand` VARCHAR(10) NOT NULL,
    INDEX (`Model_Name`),
    INDEX (`Model_Year`),
    PRIMARY KEY(`Model_Name` , `Model_Year`)
);

CREATE TABLE `Car` (
	`Plate_NO` VARCHAR(10),
    `Model_Name` VARCHAR(10) NOT NULL,
	`Model_Year` YEAR NOT NULL,
    `SSN` CHAR(14)  ,
    PRIMARY KEY(`Plate_NO`),
    FOREIGN KEY (`Model_Name`) REFERENCES `Model`(`Model_Name`) ON DELETE RESTRICT ON UPDATE CASCADE ,
    FOREIGN KEY (`Model_Year`) REFERENCES `Model`(`Model_Year`) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY(`SSN`) REFERENCES `Customer`(`C_SSN`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Order`(
	`Order_ID` INT UNSIGNED AUTO_INCREMENT ,
    `Status` ENUM('Delivered' , 'In Progress','Completed') DEFAULT 'In Progress',
    `Payment_Method` ENUM('Cash' , 'Credit') NOT NULL ,
    `Date` DATE NOT NULL,
    `Total_Cost` FLOAT UNSIGNED DEFAULT 0,
    PRIMARY KEY(`Order_ID`)
)AUTO_INCREMENT = 1;

CREATE TABLE `Repair_Order`(
	`Order_ID` INT UNSIGNED,
    `C_SSN` CHAR(14) NOT NULL ,
    `City` VARCHAR(20) NOT NULL ,
    `Street_NO` SMALLINT UNSIGNED NOT NULL,
    `Building_NO` INT UNSIGNED NOT NULL,
    `District` VARCHAR(20) NOT NULL,
    PRIMARY KEY(`Order_ID`),
    FOREIGN KEY (`Order_ID`) REFERENCES `Order`(`Order_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (`C_SSN`) REFERENCES `Customer`(`C_SSN`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Purchase_Order`(
	`Order_ID` INT UNSIGNED ,
    `Delivery_Date` DATE NOT NULL ,
    `S_SSN` CHAR(14) NOT NULL,
    PRIMARY KEY(`Order_ID`),
    FOREIGN KEY (`Order_ID`) REFERENCES `Order`(`Order_ID`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY(`S_SSN`) REFERENCES `Supplier`(`S_SSN`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Component`(
	`Model` VARCHAR(50),
    `Price` FLOAT UNSIGNED NOT NULL CHECK(`Price` != 0),
    PRIMARY KEY(`Model`)
);

CREATE TABLE `Offers`(
	`Component_Model` VARCHAR(50),
    `S_SSN` CHAR(14) ,
    PRIMARY KEY(`Component_Model` , `S_SSN`),
    FOREIGN KEY(`Component_Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY(`S_SSN`) REFERENCES `Supplier`(`S_SSN`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Body`(
	`Model` VARCHAR(50),
    `Chassis_Type` ENUM('Sedan' , 'Hatchback' , 'SUV' , 'Coupe' , 'Van' , 'Truck' , 'Convertible'),
    PRIMARY KEY(`Model`),
    FOREIGN KEY(`Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Battery`(
	`Model` VARCHAR(50),
    `Expiry_Date` DATE NOT NULL,
    PRIMARY KEY(`Model`),
    FOREIGN KEY(`Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Transmission`(
	`Model` VARCHAR(50),
    `Transmission_Type` ENUM('Automatic' , 'Manual')NOT NULL,
    PRIMARY KEY(`Model`),
    FOREIGN KEY(`Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Engine`(
	`Model` VARCHAR(50),
    `Lubricant_Type` VARCHAR(14) NOT NULL,
    `Horse_Power` SMALLINT UNSIGNED NOT NULL CHECK(`Horse_Power` != 0),
    PRIMARY KEY(`Model`),
    FOREIGN KEY(`Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Maintenance_Task`(
	`Task_ID` INT UNSIGNED ,
    `Task_Date` DATE NOT NULL,
    `Price` FLOAT UNSIGNED NOT NULL ,
    `Center_ID` INT UNSIGNED NOT NULL,
    `Plate_NO` VARCHAR(10) NOT NULL,
    `Order_ID` INT UNSIGNED NOT NULL,
    `Component_Model` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`Task_ID`) ,
    FOREIGN KEY (`Center_ID`) REFERENCES `Service_Center`(`Center_ID`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (`Order_ID`) REFERENCES `Repair_Order`(`Order_ID`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (`Component_Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (`Plate_NO`) REFERENCES `Car`(`Plate_NO`) ON DELETE CASCADE ON UPDATE CASCADE 
)AUTO_INCREMENT = 1;

CREATE TABLE `Performs`(
	`SSN` CHAR(14) ,
    `Task_ID` INT UNSIGNED ,
    PRIMARY KEY (`SSN` ,`Task_ID`) ,
    FOREIGN KEY (`SSN`) REFERENCES `Engineer`(`E_SSN`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (`Task_ID`) REFERENCES `Maintenance_Task`(`Task_ID`)ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE `Consist_OF`(
	`Order_ID` INT UNSIGNED,
    `Component_Model` VARCHAR(50),
    `Quantity` SMALLINT UNSIGNED NOT NULL CHECK(`Quantity` != 0),
    PRIMARY KEY(`Order_ID` ,`Component_Model`),
    FOREIGN KEY (`Order_ID`) REFERENCES `Order`(`Order_ID`) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY(`Component_Model`) REFERENCES `Component`(`Model`) ON DELETE CASCADE ON UPDATE CASCADE 
);
-- --------------------------------------------------------------------

