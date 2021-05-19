-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lab_4
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab_4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab_4` DEFAULT CHARACTER SET utf8 ;
USE `lab_4` ;

-- -----------------------------------------------------
-- Table `lab_4`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`region` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`city` (
  `name` VARCHAR(45) NOT NULL,
  `id` INT NOT NULL,
  `region_id` INT NOT NULL,
  `index` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_id` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_id`)
    REFERENCES `lab_4`.`region` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`amusement_park`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`amusement_park` (
  `id` INT NOT NULL,
  `capacity` INT NULL,
  `address` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_amusement_park_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_amusement_park_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `lab_4`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`client` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL,
  `gender` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `city_d` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_client_city1_idx` (`city_d` ASC) VISIBLE,
  CONSTRAINT `fk_client_city1`
    FOREIGN KEY (`city_d`)
    REFERENCES `lab_4`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`position` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`emloyee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`emloyee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone_number` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NULL,
  `birthday` DATE NULL,
  `gender` VARCHAR(50) NULL,
  `position_id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `city_id` INT NOT NULL,
  `amusement_park_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_emloyee_position1_idx` (`position_id` ASC) VISIBLE,
  INDEX `fk_emloyee_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_emloyee_amusement_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_emloyee_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `lab_4`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emloyee_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `lab_4`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_emloyee_amusement_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `lab_4`.`amusement_park` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `lab_4`.`attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`attraction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `capacity` INT NULL,
  `amusement_park_id` INT NOT NULL,
  `minimum_age` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_attraction_amusememnt_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_attraction_amusememnt_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `lab_4`.`amusement_park` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`ticket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`ticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `arrival_time` DATETIME NOT NULL,
  `departure_time` DATETIME NOT NULL,
  `people_number` INT NOT NULL,
  `kids_number` INT NULL,
  `price_in_USD` INT NOT NULL,
  `client_id` INT NOT NULL,
  `amusement_park_id` INT NOT NULL,
  `ticket_type_id` INT NOT NULL,
  `can_pass_without_queue` TINYINT NULL,
  `payment_time` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ticket_client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_ticket_amusement_park1_idx` (`amusement_park_id` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `lab_4`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ticket_amusement_park1`
    FOREIGN KEY (`amusement_park_id`)
    REFERENCES `lab_4`.`amusement_park` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`show`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`show` (
  `id` INT NOT NULL,
  `is_free_to_visit` TINYINT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`show_ticket_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`show_ticket_type` (
  `show_id` INT NOT NULL,
  `ticket_type_id` INT NOT NULL,
  PRIMARY KEY (`show_id`, `ticket_type_id`),
  INDEX `fk_show_has_ticket_type_show1_idx` (`show_id` ASC) VISIBLE,
  CONSTRAINT `fk_show_has_ticket_type_show1`
    FOREIGN KEY (`show_id`)
    REFERENCES `lab_4`.`show` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`actor` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `years_of_experience` INT NULL,
  `gender` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lab_4`.`actor_show`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab_4`.`actor_show` (
  `actor_id` INT NOT NULL,
  `show_id` INT NOT NULL,
  PRIMARY KEY (`actor_id`, `show_id`),
  INDEX `fk_actor_has_show_show1_idx` (`show_id` ASC) VISIBLE,
  INDEX `fk_actor_has_show_actor1_idx` (`actor_id` ASC) VISIBLE,
  CONSTRAINT `fk_actor_has_show_actor1`
    FOREIGN KEY (`actor_id`)
    REFERENCES `lab_4`.`actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actor_has_show_show1`
    FOREIGN KEY (`show_id`)
    REFERENCES `lab_4`.`show` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
