-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tallerservicio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tallerservicio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tallerservicio` DEFAULT CHARACTER SET utf8 ;
USE `tallerservicio` ;

-- -----------------------------------------------------
-- Table `tallerservicio`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`Usuarios` (
  `dui` VARCHAR(10) NOT NULL,
  `user` VARCHAR(20) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `rol` VARCHAR(20) NOT NULL,
  `nombreCompleto` VARCHAR(50) NOT NULL,
  `telefono` VARCHAR(9) NULL,
  `correo` VARCHAR(75) NULL,
  `celular` VARCHAR(45) NULL,
  `Estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`dui`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallerservicio`.`Automoviles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`Automoviles` (
  `numChasis` VARCHAR(20) NOT NULL,
  `marca` VARCHAR(25) NOT NULL,
  `modelo` VARCHAR(35) NOT NULL,
  `color` VARCHAR(25) NOT NULL,
  `ano` VARCHAR(4) NOT NULL,
  `dui` VARCHAR(10) NOT NULL,
  `numPlaca` VARCHAR(20) NOT NULL,
  `clase` VARCHAR(20) NOT NULL,
  `numMotor` VARCHAR(20) NOT NULL,
  `tipoCarro` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`numChasis`),
  CONSTRAINT `dui`
    FOREIGN KEY (`dui`)
    REFERENCES `tallerservicio`.`Usuarios` (`dui`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallerservicio`.`tipo_Enderezado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`tipo_Enderezado` (
  `idTipo_Enderezado` INT NOT NULL AUTO_INCREMENT,
  `nivel` VARCHAR(10) NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`idTipo_Enderezado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallerservicio`.`tipo_Pintura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`tipo_Pintura` (
  `idTipo_Pintura` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `precioPintura` DOUBLE NOT NULL,
  PRIMARY KEY (`idTipo_Pintura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallerservicio`.`Servicios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`Servicios` (
  `idServicio` INT NOT NULL AUTO_INCREMENT,
  `Nombre_Servicio` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idServicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallerservicio`.`Servicio_Pintura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`Servicio_Pintura` (
  `idServicio_Pintura` INT NOT NULL AUTO_INCREMENT,
  `idServicio` INT NOT NULL,
  `numChasis` VARCHAR(20) NOT NULL,
  `idTipo_Pintura` INT NOT NULL,
  `color` VARCHAR(25) NOT NULL,
  `idTipo_Enderezado` INT NOT NULL,
  `manoDeObra` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idServicio_Pintura`),
  INDEX `idTipo_Enderezado_idx` (`idTipo_Enderezado` ASC) ,
  INDEX `idTipo_Pintura_idx` (`idTipo_Pintura` ASC) ,
  INDEX `idServicio_idx` (`idServicio` ASC) ,
  INDEX `numChasis_idx` (`numChasis` ASC) ,
  CONSTRAINT `numChasis`
    FOREIGN KEY (`numChasis`)
    REFERENCES `tallerservicio`.`Automoviles` (`numChasis`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTipo_Enderezado`
    FOREIGN KEY (`idTipo_Enderezado`)
    REFERENCES `tallerservicio`.`tipo_Enderezado` (`idTipo_Enderezado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTipo_Pintura`
    FOREIGN KEY (`idTipo_Pintura`)
    REFERENCES `tallerservicio`.`tipo_Pintura` (`idTipo_Pintura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idServicio`
    FOREIGN KEY (`idServicio`)
    REFERENCES `tallerservicio`.`Servicios` (`idServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tallerservicio`.`bitacora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tallerservicio`.`bitacora` (
  `idBitacora` INT NOT NULL,
  `foto` MEDIUMBLOB NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `idServicios` INT NOT NULL,
  PRIMARY KEY (`idBitacora`),
  INDEX `idServicios_idx` (`idServicios` ASC) ,
  CONSTRAINT `idServicios`
    FOREIGN KEY (`idServicios`)
    REFERENCES `tallerservicio`.`Servicio_Pintura` (`idServicio_Pintura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
