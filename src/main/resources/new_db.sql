-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema amusements_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema amusements_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amusements_db` DEFAULT CHARACTER SET utf8 ;
USE `amusements_db` ;

-- -----------------------------------------------------
-- Table `amusements_db`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`region` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`city` (
  `name` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `region_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `amusements_db`.`region` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`amusement_park`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`amusement_park` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `capacity` INT NULL DEFAULT NULL,
  `address` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_amusement_park_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_amusement_park_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `amusements_db`.`city` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`attraction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  `capacity` INT NULL DEFAULT NULL,
  `amusement_park_id` INT NOT NULL,
  `minimum_age` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_attraction_amusememnt_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_attraction_amusememnt_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `amusements_db`.`amusement_park` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` VARCHAR(45) NULL DEFAULT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_client_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `amusements_db`.`city` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`position` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`employee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone_number` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` VARCHAR(45) NULL DEFAULT NULL,
  `gender` VARCHAR(50) NULL DEFAULT NULL,
  `position_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  `amusement_park_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emloyee_position1_idx` (`position_id` ASC) VISIBLE,
  INDEX `fk_emloyee_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_worker_amusement_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_emloyee_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `amusements_db`.`city` (`id`),
  CONSTRAINT `fk_emloyee_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `amusements_db`.`position` (`id`),
  CONSTRAINT `fk_worker_amusement_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `amusements_db`.`amusement_park` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `amusements_db`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amusements_db`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `arrival_time` VARCHAR(50) NOT NULL,
  `departure_time` VARCHAR(50) NOT NULL,
  `people_number` INT NOT NULL,
  `kids_number` INT NULL DEFAULT NULL,
  `price_in_USD` INT NOT NULL,
  `client_id` INT NOT NULL,
  `amusement_park_id` INT NOT NULL,
  `payment_time` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_ticket_amusement_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_amusement_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `amusements_db`.`amusement_park` (`id`),
  CONSTRAINT `fk_ticket_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `amusements_db`.`client` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
