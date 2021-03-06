-- MySQL Script generated by MySQL Workbench
-- 07/10/16 17:55:50
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `CUST_STATUS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CUST_STATUS` ;

CREATE TABLE IF NOT EXISTS `CUST_STATUS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `CUST_TYPE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CUST_TYPE` ;

CREATE TABLE IF NOT EXISTS `CUST_TYPE` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `USER_STATUS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `USER_STATUS` ;

CREATE TABLE IF NOT EXISTS `USER_STATUS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `USERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `USERS` ;

CREATE TABLE IF NOT EXISTS `USERS` (
  `ID` INT NOT NULL,
  `LOGIN` VARCHAR(45) NULL,
  `PASSWORD` VARCHAR(45) NULL,
  `STATUS` INT NOT NULL,
  `NO_FAILED_LOGIN` INT NULL DEFAULT 0,
  `ASSOC_CUSTOMER` INT NOT NULL,
  `CREATED_BY` INT NOT NULL,
  `MODIFIED_BY` INT NOT NULL,
  `CREATED_TS` INT(11) NULL,
  `MODIFIED_TS` INT(11) NULL,
  PRIMARY KEY (`ID`))
;

CREATE INDEX `fk_USERS_USER_STATUS1_idx` ON `USERS` (`STATUS` ASC);

CREATE INDEX `fk_USERS_USERS1_idx` ON `USERS` (`CREATED_BY` ASC);

CREATE INDEX `fk_USERS_USERS2_idx` ON `USERS` (`MODIFIED_BY` ASC);

CREATE INDEX `fk_USERS_CUSTOMERS1_idx` ON `USERS` (`ASSOC_CUSTOMER` ASC);


-- -----------------------------------------------------
-- Table `CUSTOMERS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CUSTOMERS` ;

CREATE TABLE IF NOT EXISTS `CUSTOMERS` (
  `ID` INT NOT NULL,
  `FIRST_NAME` VARCHAR(45) NULL,
  `LAST_NAME` VARCHAR(45) NULL,
  `FAMILY_NAME` VARCHAR(45) NULL,
  `IPN` VARCHAR(10) NULL,
  `STATUS` INT NOT NULL,
  `TYPE` INT NOT NULL,
  `CREATED_BY` INT NOT NULL,
  `MODIFIED_BY` INT NOT NULL,
  `CREATED_TS` INT(11) NULL,
  `MODIFIED_TS` INT(11) NULL,
  PRIMARY KEY (`ID`))
;

CREATE UNIQUE INDEX `ID_UNIQUE` ON `CUSTOMERS` (`ID` ASC);

CREATE INDEX `fk_CUSTOMERS_CUST_STATUS_idx` ON `CUSTOMERS` (`STATUS` ASC);

CREATE INDEX `fk_CUSTOMERS_CUST_TYPE1_idx` ON `CUSTOMERS` (`TYPE` ASC);

CREATE INDEX `fk_CUSTOMERS_USERS1_idx` ON `CUSTOMERS` (`CRETED_BY` ASC);

CREATE INDEX `fk_CUSTOMERS_USERS2_idx` ON `CUSTOMERS` (`MODIFIED_BY` ASC);


-- -----------------------------------------------------
-- Table `ACC_STATUS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACC_STATUS` ;

CREATE TABLE IF NOT EXISTS `ACC_STATUS` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `RATES_DICT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RATES_DICT` ;

CREATE TABLE IF NOT EXISTS `RATES_DICT` (
  `ID` INT NOT NULL,
  `NAME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `ACCOUNTS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ACCOUNTS` ;

CREATE TABLE IF NOT EXISTS `ACCOUNTS` (
  `ID` INT NOT NULL,
  `ACC_CLASS` VARCHAR(4) NULL,
  `ACC_KEY` VARCHAR(1) NULL,
  `ACC_SUBACC` VARCHAR(9) NULL,
  `CUSTOMER_ID` INT NOT NULL,
  `STATUS` INT NOT NULL,
  `AMOUNT` FLOAT NULL,
  `AMOUNT_DYN` FLOAT NULL,
  `CCY` INT NOT NULL,
  `CREATED_BY` INT NOT NULL,
  `MODIFIED_BY` INT NOT NULL,
  `CREATED_TS` INT(11) NULL,
  `MODIFIED_TS` INT(11) NULL,
  PRIMARY KEY (`ID`))
;

CREATE INDEX `fk_ACCOUNTS_CUSTOMERS1_idx` ON `ACCOUNTS` (`CUSTOMER_ID` ASC);

CREATE INDEX `fk_ACCOUNTS_ACC_STATUS1_idx` ON `ACCOUNTS` (`STATUS` ASC);

CREATE INDEX `fk_ACCOUNTS_USERS1_idx` ON `ACCOUNTS` (`CREATED_BY` ASC);

CREATE INDEX `fk_ACCOUNTS_USERS2_idx` ON `ACCOUNTS` (`MODIFIED_BY` ASC);

CREATE INDEX `fk_ACCOUNTS_RATES_DICT1_idx` ON `ACCOUNTS` (`CCY` ASC);


-- -----------------------------------------------------
-- Table `RATES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `RATES` ;

CREATE TABLE IF NOT EXISTS `RATES` (
  `ID` INT NOT NULL,
  `RATE_ID` INT NOT NULL,
  `RATE_DATE` VARCHAR(45) NULL,
  `ASK` FLOAT NULL,
  `BID` FLOAT NULL,
  `NBU` FLOAT NULL,
  `CREATED_BY` INT NOT NULL,
  `MODIFIED_BY` INT NOT NULL,
  `CREATED_TS` INT NULL,
  `MODIFIED_TS` INT NULL,
  PRIMARY KEY (`ID`))
;

CREATE INDEX `fk_RATES_RATES_DICT1_idx` ON `RATES` (`RATE_ID` ASC);

CREATE INDEX `fk_RATES_USERS1_idx` ON `RATES` (`CREATED_BY` ASC);

CREATE INDEX `fk_RATES_USERS2_idx` ON `RATES` (`MODIFIED_BY` ASC);


-- -----------------------------------------------------
-- Table `OPER_DICT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPER_DICT` ;

CREATE TABLE IF NOT EXISTS `OPER_DICT` (
  `ID` INT NOT NULL,
  `OPER_TYPE` VARCHAR(45) NULL,
  `DESCRIPTION` VARCHAR(120) NULL,
  PRIMARY KEY (`ID`))
;


-- -----------------------------------------------------
-- Table `OPERATIONS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPERATIONS` ;

CREATE TABLE IF NOT EXISTS `OPERATIONS` (
  `ID` INT NOT NULL,
  `OPER_DICT_ID` INT NOT NULL,
  `AMOUNT` FLOAT NULL,
  `CCY` INT NOT NULL,
  `CREATED_BY` INT NOT NULL,
  `MODIFIED_BY` INT NOT NULL,
  `CREATED_TS` INT(11) NULL,
  `MODIFIED_TS` INT(11) NULL,
  PRIMARY KEY (`ID`))
;

CREATE INDEX `fk_OPERATIONS_OPER_DICT1_idx` ON `OPERATIONS` (`OPER_DICT_ID` ASC);

CREATE INDEX `fk_OPERATIONS_RATES_DICT1_idx` ON `OPERATIONS` (`CCY` ASC);

CREATE INDEX `fk_OPERATIONS_USERS1_idx` ON `OPERATIONS` (`CREATED_BY` ASC);

CREATE INDEX `fk_OPERATIONS_USERS2_idx` ON `OPERATIONS` (`MODIFIED_BY` ASC);


-- -----------------------------------------------------
-- Table `OPER_RULES`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OPER_RULES` ;

CREATE TABLE IF NOT EXISTS `OPER_RULES` (
  `ID` INT NOT NULL,
  `OPER_ID` INT NOT NULL,
  `CONDITION` VARCHAR(45) NULL,
  `RULE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
;

CREATE INDEX `fk_OPER_RULES_OPER_DICT1_idx` ON `OPER_RULES` (`OPER_ID` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
