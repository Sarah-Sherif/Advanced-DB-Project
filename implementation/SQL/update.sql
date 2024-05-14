UPDATE `Engineer`
SET `Specialization` = 'Mechanical'
WHERE `E_SSN` = '96012101300120';

UPDATE `Engineer`
SET `Specialization` = 'Civil'
WHERE `E_SSN` = '91020901100485';

UPDATE `Engineer`
SET `Specialization` = 'Electrical'
WHERE `E_SSN` = '98031201500319';

UPDATE `Engineer`
SET `Specialization` = 'Software'
WHERE `E_SSN` = '90052301300185';

-- ------------------------------------------------------------------------------
UPDATE `Sales_Man` SET `Sales_Made` = 100 WHERE `SM_SSN` = '93071701200417';
UPDATE `Sales_Man` SET `Sales_Made` = 200 WHERE `SM_SSN` = '88112501100176';
UPDATE `Sales_Man` SET `Sales_Made` = 150 WHERE `SM_SSN` = '94060901200185';
UPDATE `Sales_Man` SET `Sales_Made` = 75 WHERE `SM_SSN` = '95022501200146';

-- ------------------------------------------------------------------------------
-- update the Chassis_Type for the rows with Model equal to A123, A456, and A789
UPDATE `Body`
SET `Chassis_Type` = CASE 
                        WHEN `Model` = 'A123' THEN 'Sedan'
                        WHEN `Model` = 'A456' THEN 'SUV'
                        WHEN `Model` = 'A789' THEN 'Hatchback'
                     END
WHERE `Model` IN ('A123', 'A456', 'A789');

-- --------------------------------------------------------------------------------
/* Give a 5% salary increase to Sales Men who made more than 100 sales,
	and a 5% salary decrease to Sales Men who made less than 100 sales. 
    The salaries of Engineers will be increased by 10%. */
UPDATE `Employee` AS `E`
JOIN `Sales_Man` AS `SM` ON `E`.`E_SSN` = `SM`.`SM_SSN`
SET `Salary` = CASE 
                    WHEN `Role` = 'Engineer' THEN `Salary` * 1.1 
                    WHEN `Role` = 'Sales Man' AND `SM`.`Sales_Made` >= 100 THEN `Salary` * 1.05
                    WHEN `Role` = 'Sales Man' AND `SM`.`Sales_Made` < 100 THEN `Salary` * 0.95
               END
WHERE `E`.`Center_ID` IN (
    SELECT `Center_ID` 
    FROM `Service_Center` 
    WHERE `City` = 'Alexandria'
);
