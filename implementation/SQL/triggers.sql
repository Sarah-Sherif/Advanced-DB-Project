DELIMITER //

CREATE TRIGGER `increment_employee`
AFTER INSERT ON `Employee`
FOR EACH ROW
BEGIN
	UPDATE `Service_Center`
	SET `NO_of_Employees` = `NO_of_Employees` + 1
	WHERE `Service_center`.`Center_ID` = NEW.`Center_ID`;
END//

CREATE TRIGGER `update_employee_change_center`
AFTER UPDATE ON `Employee`
FOR EACH ROW
BEGIN
	IF OLD.`Center_ID` <> NEW.`Center_ID` THEN
		UPDATE `service_center`
	    SET `NO_of_Employees` = `NO_of_Employees` - 1
		WHERE `service_center`.`Center_ID` = OLD.`Center_ID`;
		
		UPDATE `service_center`
	    SET `NO_of_Employees` = `NO_of_Employees` + 1
		WHERE `service_center`.`Center_ID` = NEW.`Center_ID`;
	END IF;
    IF (SELECT `NO_of_Employees`
		FROM `service_center`
        WHERE `Service_Center`.`Center_ID` = OLD.`Center_ID`) = 0
	THEN
		DELETE FROM `service_center` 
        WHERE `Service_Center`.`Center_ID` = OLD.`Center_ID`;
	END IF;
    
END//

CREATE TRIGGER `decrement_employee`
AFTER DELETE ON `Employee`
FOR EACH ROW
BEGIN
    IF (SELECT `NO_of_Employees`
		FROM `service_center`
        WHERE `Service_Center`.`Center_ID` = OLD.`Center_ID`) = 1
	THEN
		DELETE FROM `Service_Center` 
        WHERE `Service_Center`.`Center_ID` = OLD.`Center_ID`;
	END IF;
END//

CREATE TRIGGER `Repair_Order_Price`
AFTER INSERT ON `Maintenance_Task`
FOR EACH ROW
BEGIN
	UPDATE `Order`
    SET `Total_Cost` = NEW.`Price`
    WHERE `Order`.`Order_ID` = NEW.`Order_ID`;
END//

CREATE TRIGGER `Update_Repair_Order_Price`
AFTER UPDATE ON `Maintenance_Task`
FOR EACH ROW
BEGIN
	UPDATE `Order`
	SET `Total_Cost` = NEW.`Price`
	WHERE `Order`.`Order_ID` = NEW.`Order_ID`;
END//

CREATE TRIGGER `Purchase_Order_Price`
AFTER INSERT ON `Consist_OF`
FOR EACH ROW
BEGIN
	UPDATE `Order`
    SET `Total_Cost` = (
		SELECT `Price`
        FROM `Component`
        WHERE NEW.`Component_Model` = `component`.`Model`
        ) * NEW.`Quantity`
	WHERE `Order`.`Order_ID` = NEW.`Order_ID`;
END//

CREATE TRIGGER `Purchase_Order_Price_update`
AFTER UPDATE ON `Consist_OF`
FOR EACH ROW
BEGIN
    UPDATE `Order`
    SET `Total_Cost` = (
        SELECT `Price`
        FROM `Component`
        WHERE NEW.`Component_Model` = `Component`.`Model`
    ) * NEW.`Quantity`
    WHERE `Order`.`Order_ID` = NEW.`Order_ID`;
END;

DELIMITER ;	
