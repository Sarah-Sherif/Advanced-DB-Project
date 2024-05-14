-- Report of all engineers and their specialization
SELECT `e`.`E_SSN`, `p`.`First_Name`, `p`.`Middle_Name`, `p`.`Last_Name`, `e`.`Role`, `en`.`Specialization`
FROM `Engineer` `en`
INNER JOIN `Employee` `e` ON `en`.`E_SSN` = `e`.`E_SSN`
INNER JOIN `Person` `p` ON `e`.`E_SSN` = `p`.`SSN`;

-- Report of all salesmen and the number of sales they made
SELECT `sm`.`SM_SSN`, `p`.`First_Name`, `p`.`Middle_Name`, `p`.`Last_Name`, `e`.`Role`, `sm`.`Sales_Made`
FROM `Sales_Man` AS `sm`
INNER JOIN `Employee` AS `e` ON `sm`.`SM_SSN` = `e`.`E_SSN`
INNER JOIN `Person` AS `p` ON `e`.`E_SSN` = `p`.`SSN`;

-- Report of all purchase orders with the supplier information
SELECT `po`.`Order_ID`, `po`.`Delivery_Date`, `s`.`Website`
FROM `Purchase_Order` `po`
INNER JOIN `Supplier` `s` ON `po`.`S_SSN` = `s`.`S_SSN`;

-- Show the names of all customers who have purchased a car in the year 2022
SELECT `p`.`First_Name`, `p`.`Last_Name`
FROM `Person` `p`
JOIN `Customer` `c` ON `p`.`SSN` = `c`.`C_SSN`
JOIN `Car` `cr` ON c.`C_SSN` = `cr`.`SSN`
WHERE `cr`.`Model_Year` = 2022;

--  the total cost of all orders for customers who live in the city of Alexandria
SELECT SUM(`o`.`Total_Cost`) as `Total_Cost`
FROM `Order` `o`
JOIN `Repair_Order` `ro` ON `o`.`Order_ID` = `ro`.`Order_ID`
JOIN `Customer` `c` ON `ro`.`C_SSN` = `c`.`C_SSN`
WHERE `c`.`City` = 'Alexandria';

-- Show the number of customers who have ordered a car that was manufactured by brand "Nissan"
SELECT COUNT(DISTINCT `c`.`C_SSN`) as `Total_Customers`
FROM `Customer` `c`
JOIN `Car` `cr` ON `c`.`C_SSN` = `cr`.`SSN`
JOIN `Model` `m` ON `cr`.`Model_Name` = `m`.`Model_Name` AND `cr`.`Model_Year` = `m`.`Model_Year`
WHERE `m`.`Brand` = 'Nissan';

-- the total number of orders for each month of the year.
SELECT EXTRACT(MONTH FROM `Date`) AS `Month`, COUNT(*) AS `Total_Orders`
FROM `Order`
GROUP BY `Month`;

-- Report on the total number of orders for each payment method
SELECT `Payment_Method`, COUNT(*) as `Total_Orders`
FROM `Order`
GROUP BY `Payment_Method`;

--
CREATE VIEW `Customer_Details` AS 
SELECT `Person`.`SSN`, `Person`.`First_Name`, `Person`.`Middle_Name`, `Person`.`Last_Name`, `Customer`.`City`, `Customer`.`Street_NO`, `Customer`.`Building_NO`, `Customer`.`District`
FROM `Person` JOIN `Customer` ON `Person`.`SSN` = `Customer`.`C_SSN`;

SELECT `Car`.`Plate_NO`, `Model`.`Model_Name`, `Model`.`Model_Year`, `Customer_Details`.`First_Name`, `Customer_Details`.`Middle_Name`, `Customer_Details`.`Last_Name`, `Customer_Details`.`City`, `Customer_Details`.`Street_NO`, `Customer_Details`.`Building_NO`, `Customer_Details`.`District`
FROM `Car` JOIN `Model` ON `Car`.`Model_Name` = `Model`.`Model_Name` AND `Car`.`Model_Year` = `Model`.`Model_Year`
JOIN `Customer_Details` ON `Car`.`SSN` = `Customer_Details`.`SSN`;


-- 
CREATE VIEW `service_center_summary` AS
SELECT 
    `sc`.`Center_ID`, 
    COUNT(`e`.`E_SSN`) AS `No_of_Employees`, 
    AVG(`e`.`Salary`) AS `Avg_Salary`, 
    SUM(`e`.`Salary`) AS `Total_Salary`
FROM `Service_Center` AS `sc`
JOIN `Employee` AS `e` ON `sc`.`Center_ID` = `e`.`Center_ID`
GROUP BY `sc`.`Center_ID`;

SELECT * FROM `service_center_summary`;





