-- This will delete all orders with a Status of "In Progress" and a Date older than one year from the current date.
DELETE FROM `Order`
WHERE `Date` < DATE_SUB(NOW(), INTERVAL 1 YEAR) AND `Status` = 'In Progress';

-- Delete all orders that have not been paid for in full and are more than 6 months old
DELETE FROM `Order`
WHERE `Payment_Method` = 'Credit' AND `Total_Cost` > 0 AND `Date` < DATE_SUB(NOW(), INTERVAL 6 MONTH);

-- Delete all customers who have not placed an order in the last 6 years
DELETE FROM `Customer`
WHERE `Customer_ID` NOT IN (
    SELECT `Customer_ID`
    FROM `Order`
    WHERE `Date` >= DATE_SUB(NOW(), INTERVAL 6 YEAR)
);

-- Delete all employees who work in the Cairo service center and have a salary less than the average salary of all engineers.
CREATE TEMPORARY TABLE `temp` AS (
    SELECT `E_SSN` 
    FROM `Employee` 
    WHERE `Center_ID` IN (
        SELECT `Center_ID` 
        FROM `Service_Center` 
        WHERE `City` = 'Cairo'
    ) 
    AND `Salary` < (
        SELECT AVG(`Salary`) 
        FROM `Employee`
        WHERE `Role` = 'Engineer'
    )
);

DELETE FROM `Employee`
WHERE `E_SSN` IN (SELECT `E_SSN` FROM `temp`);

DROP TEMPORARY TABLE IF EXISTS `temp`;
