drop database cfd_db;
CREATE DATABASE  IF NOT EXISTS `cfd_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cfd_db`;

DROP TABLE IF EXISTS AddressBook;
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Accessory;
DROP TABLE IF EXISTS RedeemRecord;
DROP TABLE IF EXISTS Invoice;
DROP TABLE IF EXISTS `Size`;
DROP TABLE IF EXISTS Hoody;
DROP TABLE IF EXISTS HoodySize;
DROP TABLE IF EXISTS Pant;
DROP TABLE IF EXISTS PantSize;
DROP TABLE IF EXISTS Short;
DROP TABLE IF EXISTS ShortSize;
DROP TABLE IF EXISTS Coat;
DROP TABLE IF EXISTS CoatSize;
DROP TABLE IF EXISTS Bag;
DROP TABLE IF EXISTS CFDOrder;
CREATE TABLE AddressBook (
  aid     int(10) NOT NULL AUTO_INCREMENT, 
  address varchar(255), 
  cid     varchar(255) NOT NULL, 
  status	varchar(255) default "valid",
  PRIMARY KEY (aid),
  CONSTRAINT chk_DeliveryAddressStatus_valid_or_invalid CHECK (DeliveryAddressStatus in ('valid', 'invalid'))) ENGINE=InnoDB;
CREATE TABLE Customer (
  cid      varchar(255) NOT NULL, 
  email    varchar(255) NOT NULL UNIQUE, 
  password varchar(255) DEFAULT null, 
  fName    varchar(255) NOT NULL, 
  lName    varchar(255) NOT NULL, 
  balance  int(10) DEFAULT 0 NOT NULL, 
  phone		varchar(20)	default null,
  dob      date DEFAULT null, 
  gender   varchar(255) DEFAULT null, 
  regDate  timestamp default CURRENT_TIMESTAMP, 
  bonus    int(10) DEFAULT 1000 NOT NULL, 
  status   varchar(255) DEFAULT 'requested' NOT NULL, 
  PRIMARY KEY (cid),
  CONSTRAINT chk_Gender_isInValid CHECK (CustGender in('male','female', null)),
  CONSTRAINT chk_Status_isInValid CHECK (CustStatus in('requested','confirmed','denieded'))) ENGINE=InnoDB;
CREATE TABLE Staff (
 `sid` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fName` varchar(255) NOT NULL,
  `lName` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL DEFAULT 'staff',
  `shop` varchar(255) NOT NULL,
  `entryTime` datetime DEFAULT CURRENT_TIMESTAMP, 
  PRIMARY KEY (sid)
  ) ENGINE=InnoDB;
CREATE TABLE Accessory (
  PSID        varchar(255) NOT NULL, 
  pBrand      varchar(255) DEFAULT null, 
  pName       varchar(255) NOT NULL, 
  pType       varchar(255) NOT NULL, 
    img         varchar(255) NOT NULL DEFAULT 'img/noFound.png', 
  description varchar(255) DEFAULT null, 
  price       numeric(19, 2) DEFAULT 0.0 NOT NULL, 
  redeemPoint int(10) DEFAULT 99999999 NOT NULL, 
  stock         int(10) DEFAULT 0 NOT NULL, 
  status varchar(255) DEFAULT 'valid' NOT NULL, 
  PRIMARY KEY (PSID)) ENGINE=InnoDB;
CREATE TABLE RedeemRecord (
  rid       varchar(255) NOT NULL, 
  qty       int(10) NOT NULL, 
  cid       varchar(255) NOT NULL, 
  invoiceId varchar(255) NOT NULL, 
  PSID      varchar(255) NOT NULL, 
  PRIMARY KEY (rid)) ENGINE=InnoDB;
CREATE TABLE Invoice (
  invoiceId varchar(255) NOT NULL, 
  invoiceDate datetime NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  deliveryDate datetime NOT NULL, 
  address   varchar(255) NOT NULL, 
  status    varchar(255) NOT NULL, 
  cid       varchar(255) NOT NULL, 
  sid       varchar(255) NOT NULL, 
  PRIMARY KEY (invoiceId)) ENGINE=InnoDB;
CREATE TABLE `Size` (
  `size` varchar(10) NOT NULL, 
  PRIMARY KEY (`size`)) ENGINE=InnoDB;
CREATE TABLE Hoody (
  pid         varchar(255) NOT NULL, 
  pBrand      varchar(255) DEFAULT null, 
  pName       varchar(255) NOT NULL, 
  description varchar(255) DEFAULT null, 
  img         varchar(255) NOT NULL DEFAULT 'img/noFound.png', 
  price       numeric(19, 2) DEFAULT 0.0 NOT NULL, 
  status      varchar(255) DEFAULT 'valid' NOT NULL, 
  PRIMARY KEY (pid)) ENGINE=InnoDB;

CREATE TABLE HoodySize (
  PSID   varchar(255) NOT NULL, 
  stock  int(10) DEFAULT 0 NOT NULL, 
  pid    varchar(255) NOT NULL, 
  `size` varchar(10) NOT NULL, 
  PRIMARY KEY (PSID)) ENGINE=InnoDB;
CREATE TABLE Pant (
  pid         varchar(255) NOT NULL, 
  pBrand      varchar(255) DEFAULT null, 
  pName       varchar(255) NOT NULL, 
  description varchar(255) DEFAULT null, 
  img         varchar(255) NOT NULL DEFAULT 'img/noFound.png',  
  price       numeric(19, 2) DEFAULT 0.0 NOT NULL, 
  status      varchar(255) DEFAULT 'valid' NOT NULL, 
  PRIMARY KEY (pid)) ENGINE=InnoDB;
CREATE TABLE PantSize (
  PSID   varchar(255) NOT NULL, 
  stock  int(10) DEFAULT 0 NOT NULL, 
  pid    varchar(255) NOT NULL, 
  `size` varchar(10) NOT NULL, 
  PRIMARY KEY (PSID)) ENGINE=InnoDB;
CREATE TABLE Short (
  pid         varchar(255) NOT NULL, 
  pBrand      varchar(255) DEFAULT null, 
  pName       varchar(255) NOT NULL, 
  description varchar(255) DEFAULT null, 
  img         varchar(255) NOT NULL DEFAULT 'img/noFound.png',  
  price       numeric(19, 2) DEFAULT 0.0 NOT NULL, 
  status      varchar(255) DEFAULT 'valid' NOT NULL,
  PRIMARY KEY (pid)) ENGINE=InnoDB;
CREATE TABLE ShortSize (
  PSID   varchar(255) NOT NULL, 
  stock  int(10) DEFAULT 0 NOT NULL, 
  pid    varchar(255) NOT NULL, 
  `size` varchar(10) NOT NULL, 
  PRIMARY KEY (PSID)) ENGINE=InnoDB;
CREATE TABLE Coat (
  pid         varchar(255) NOT NULL, 
  pBrand      varchar(255) DEFAULT null, 
  pName       varchar(255) NOT NULL, 
  description varchar(255) DEFAULT null, 
  img         varchar(255) NOT NULL DEFAULT 'img/noFound.png', 
  price       numeric(19, 2) DEFAULT 0.0 NOT NULL, 
  status      varchar(255) DEFAULT 'valid' NOT NULL, 
  PRIMARY KEY (pid)) ENGINE=InnoDB;
CREATE TABLE CoatSize (
  PSID   varchar(255) NOT NULL, 
  stock  int(10) DEFAULT 0 NOT NULL, 
  pid    varchar(255) NOT NULL, 
  `size` varchar(10) NOT NULL, 
  PRIMARY KEY (PSID)) ENGINE=InnoDB;
CREATE TABLE Bag (
  PSID        varchar(255) NOT NULL, 
  pBrand      varchar(255) DEFAULT null, 
  pName       varchar(255) NOT NULL, 
  img         varchar(255) NOT NULL DEFAULT 'img/noFound.png',  
  description varchar(255) DEFAULT null, 
  price       numeric(19, 2) DEFAULT 0.0 NOT NULL, 
  stock         int(10) DEFAULT 0 NOT NULL, 
  status    varchar(255) DEFAULT 'valid' NOT NULL, 
  PRIMARY KEY (PSID)) ENGINE=InnoDB;
CREATE TABLE CFDOrder (
  oid           varchar(255) NOT NULL, 
  qty           int(10) NOT NULL, 
  price         numeric(19, 2) NOT NULL, 
  invoiceId     varchar(255) NOT NULL, 
  HoodySizePSID varchar(255) DEFAULT null, 
  CoatSizePSID  varchar(255) DEFAULT null, 
  ShortSizePSID varchar(255) DEFAULT null, 
  PantSizePSID  varchar(255) DEFAULT null, 
  AccessoryPSID varchar(255) DEFAULT null, 
  BagPSID       varchar(255) DEFAULT null, 
  PRIMARY KEY (oid),
  CONSTRAINT chk_Status CHECK (OrderStatus in ('Canceled', 'Delivered', 'Picked-Up', 'Delay-Pick-Up-Date'))) ENGINE=InnoDB;
ALTER TABLE AddressBook ADD INDEX FKAddressBoo69592 (cid), ADD CONSTRAINT FKAddressBoo69592 FOREIGN KEY (cid) REFERENCES Customer (cid);
ALTER TABLE RedeemRecord ADD INDEX FKRedeemReco380788 (cid), ADD CONSTRAINT FKRedeemReco380788 FOREIGN KEY (cid) REFERENCES Customer (cid);
ALTER TABLE RedeemRecord ADD INDEX FKRedeemReco239327 (PSID), ADD CONSTRAINT FKRedeemReco239327 FOREIGN KEY (PSID) REFERENCES Accessory (PSID);
ALTER TABLE Invoice ADD INDEX FKInvoice683428 (sid), ADD CONSTRAINT FKInvoice683428 FOREIGN KEY (sid) REFERENCES Staff (sid);
ALTER TABLE Invoice ADD INDEX FKInvoice901255 (cid), ADD CONSTRAINT FKInvoice901255 FOREIGN KEY (cid) REFERENCES Customer (cid);
ALTER TABLE RedeemRecord ADD INDEX FKRedeemReco330378 (invoiceId), ADD CONSTRAINT FKRedeemReco330378 FOREIGN KEY (invoiceId) REFERENCES Invoice (invoiceId);
ALTER TABLE HoodySize ADD INDEX FKHoodySize749619 (pid), ADD CONSTRAINT FKHoodySize749619 FOREIGN KEY (pid) REFERENCES Hoody (pid);
ALTER TABLE HoodySize ADD INDEX FKHoodySize256327 (`size`), ADD CONSTRAINT FKHoodySize256327 FOREIGN KEY (`size`) REFERENCES `Size` (`size`);
ALTER TABLE PantSize ADD INDEX FKPantSize32794 (pid), ADD CONSTRAINT FKPantSize32794 FOREIGN KEY (pid) REFERENCES Pant (pid);
ALTER TABLE PantSize ADD INDEX FKPantSize969750 (`size`), ADD CONSTRAINT FKPantSize969750 FOREIGN KEY (`size`) REFERENCES `Size` (`size`);
ALTER TABLE ShortSize ADD INDEX FKShortSize988774 (pid), ADD CONSTRAINT FKShortSize988774 FOREIGN KEY (pid) REFERENCES Short (pid);
ALTER TABLE ShortSize ADD INDEX FKShortSize455150 (`size`), ADD CONSTRAINT FKShortSize455150 FOREIGN KEY (`size`) REFERENCES `Size` (`size`);
ALTER TABLE CoatSize ADD INDEX FKCoatSize70644 (pid), ADD CONSTRAINT FKCoatSize70644 FOREIGN KEY (pid) REFERENCES Coat (pid);
ALTER TABLE CoatSize ADD INDEX FKCoatSize759454 (`size`), ADD CONSTRAINT FKCoatSize759454 FOREIGN KEY (`size`) REFERENCES `Size` (`size`);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder126732 (invoiceId), ADD CONSTRAINT FKCFDOrder126732 FOREIGN KEY (invoiceId) REFERENCES Invoice (invoiceId);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder570157 (HoodySizePSID), ADD CONSTRAINT FKCFDOrder570157 FOREIGN KEY (HoodySizePSID) REFERENCES HoodySize (PSID);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder911190 (CoatSizePSID), ADD CONSTRAINT FKCFDOrder911190 FOREIGN KEY (CoatSizePSID) REFERENCES CoatSize (PSID);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder931969 (ShortSizePSID), ADD CONSTRAINT FKCFDOrder931969 FOREIGN KEY (ShortSizePSID) REFERENCES ShortSize (PSID);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder417651 (PantSizePSID), ADD CONSTRAINT FKCFDOrder417651 FOREIGN KEY (PantSizePSID) REFERENCES PantSize (PSID);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder535822 (AccessoryPSID), ADD CONSTRAINT FKCFDOrder535822 FOREIGN KEY (AccessoryPSID) REFERENCES Accessory (PSID);
ALTER TABLE CFDOrder ADD INDEX FKCFDOrder9876 (BagPSID), ADD CONSTRAINT FKCFDOrder9876 FOREIGN KEY (BagPSID) REFERENCES Bag (PSID);
