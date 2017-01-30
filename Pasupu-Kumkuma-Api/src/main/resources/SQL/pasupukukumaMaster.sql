CREATE TABLE ROLES(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID) 
);



CREATE TABLE GENDER(
	ID VARCHAR(37) NOT NULL,
	CODE VARCHAR(3) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);


CREATE TABLE COUNTRY(
	ID VARCHAR(37) NOT NULL,
	CODE VARCHAR(9) NOT NULL,
	NAME VARCHAR(200) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);

CREATE TABLE STATES(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (200) NOT NULL,
	COUNTRY_ID VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID)
);




CREATE TABLE CITY(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (200) NOT NULL,
	STATE_ID VARCHAR(37),
	COUNTRY_ID VARCHAR(37),
	ORDER_NUM INT,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (STATE_ID) REFERENCES STATES  (ID)	
);

CREATE TABLE RAASI(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID) 
);

CREATE TABLE NAKSHYATRAM(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID) 
);

CREATE TABLE STATUS (
	ID VARCHAR(37) NOT NULL,	
	CODE VARCHAR (50) NOT NULL,	
	NAME VARCHAR (100) NOT NULL,-- blocked,active	
	DESCRIPTION VARCHAR (500) NOT NULL,	
    CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);


CREATE TABLE `PUJAS` (
     ID VARCHAR(37) NOT NULL,
 	 NAME VARCHAR (100) NOT NULL,-- blocked,active	
	 DESCRIPTION VARCHAR (1000) NOT NULL,	
	`price` DOUBLE NOT NULL,
	`duration` varchar(50) NOT NULL,
	`puja_count` int default '0',	
    `photo` varchar(255) NOT NULL,
	`STATUS_ID` VARCHAR(37) NOT NULL default '000' ,
     CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID)
);


CREATE TABLE `puja_samagri` (
     ID VARCHAR(37) NOT NULL,
 	 NAME VARCHAR (100) NOT NULL,-- blocked,active	
	 DESCRIPTION VARCHAR (1000) NOT NULL,	
	`price` DOUBLE NOT NULL,
	`duration` varchar(50) NOT NULL,
    `photo` varchar(255) NOT NULL,
     CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)	
);


CREATE TABLE `puja_samagri_PUJA` (
     ID VARCHAR(37) NOT NULL,
	 pujasamagri_ID	 VARCHAR(37) NOT NULL,
	 PUJAS_ID VARCHAR(37) NOT NULL,
       CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,	
   `STATUS_ID` VARCHAR(37) NOT NULL default '000' ,
	PRIMARY KEY (ID),	
    FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID),
	 FOREIGN KEY (PUJA_ID) REFERENCES PUJAS(ID)
);

CREATE TABLE COUPAN_TYPE(  ---REFERRED BY ,REFERRED TO
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID) 
);


