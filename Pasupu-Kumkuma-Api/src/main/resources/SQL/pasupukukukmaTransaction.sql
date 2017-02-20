CREATE TABLE users (
  id VARCHAR(37) NOT NULL,
  ROLE_ID VARCHAR(37) NOT NULL,
   GENDER_ID VARCHAR(37) NOT NULL,
  name varchar(255) NOT NULL,
   EMAIL VARCHAR(400) UNIQUE NOT NULL,
   ALTERNATIVE_EMAIL VARCHAR (400) UNIQUE NOT NULL,
   PASSWORD TEXT NOT NULL,
  PHONE_NO   VARCHAR(15),
  DOB TIMESTAMP,
  birth_place varchar(255) ,
  birth_time varchar(50) ,
  RAASI_ID varchar(37) NOT NULL,
  NAKSHATRAM_ID varchar(37) NOT NULL,
  `STATUS_ID` VARCHAR(37) NOT NULL default '000' ,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (ROLE_ID) REFERENCES ROLES(ID),
  FOREIGN KEY (GENDER_ID) REFERENCES GENDER(ID),
  FOREIGN KEY (RAASI_ID) REFERENCES RAASI(ID),
  FOREIGN KEY (NAKSHATRAM_ID) REFERENCES NAKSHATRAM(ID),
  FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID)
) ;





CREATE TABLE ADDRESS( 
	ID VARCHAR(37) NOT NULL,
	ADDRESS_LINE1 VARCHAR(500),
	ADDRESS_LINE2 VARCHAR(500),
	COUNTRY_ID VARCHAR(37) NOT NULL,
	STATE_ID VARCHAR(37),
	CITY_ID VARCHAR(37) NOT NULL,
	ZIPCODE VARCHAR(40) NOT NULL,
	USER_ID VARCHAR(37) NOT NULL,-- CUSTOMER
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (STATE_ID) REFERENCES STATES (ID),
	FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID),
	FOREIGN KEY (CITY_ID) REFERENCES CITY (ID),
	FOREIGN KEY (USER_ID)REFERENCES USERS(ID)
	
) ;


CREATE TABLE puja_orders (
		  ID VARCHAR(37) NOT NULL,
		  USER_ID VARCHAR(37) NOT NULL,
		  PUJA_ID VARCHAR(37) NOT NULL,
		  amount double NOT NULL,
		  payed double NOT NULL,
		  `STATUS_ID` VARCHAR(37) NOT NULL default '000' ,
		  CREATED_BY    VARCHAR(37) NOT NULL,
		 CREATED_ON    TIMESTAMP NOT NULL,
		 UPDATED_BY    VARCHAR(37),
		 UPDATED_ON    TIMESTAMP,
		
       PRIMARY KEY (ID),  
       FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID),
	   FOREIGN KEY (USER_ID)REFERENCES USERS(ID),
	    FOREIGN KEY (PUJA_ID) REFERENCES PUJAS(ID)
);



CREATE TABLE puja_orders_details (
  id VARCHAR(37) NOT NULL,
  puja_order_id VARCHAR(37) NOT NULL,
  puja_samagri_id varchar(37) NOT NULL,
  CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
   PRIMARY KEY (id),
   FOREIGN KEY (puja_order_id) REFERENCES puja_orders(ID),   
   FOREIGN KEY (puja_samagri_id) REFERENCES puja_samagri(ID)
);




 CREATE TABLE cart_orders (
	  ID VARCHAR(37) NOT NULL,
	  USER_ID VARCHAR(37) NOT NULL,
	  PUJA_ID VARCHAR(37) NOT NULL,
	 CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
       PRIMARY KEY (ID),  
	   FOREIGN KEY (USER_ID)REFERENCES USERS(ID),
	    FOREIGN KEY (PUJA_ID) REFERENCES PUJAS(ID)
);




CREATE TABLE contact
 (
  id VARCHAR(37) NOT NULL,
  name varchar(255) NOT NULL,
   EMAIL VARCHAR(400) UNIQUE NOT NULL,
    PHONE_NO   VARCHAR(15),
  subject text NOT NULL,
  query longtext NOT NULL,
  datetime datetime NOT NULL,
  CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
  PRIMARY KEY (id)
);
CREATE TABLE user_requests (
id VARCHAR(37) NOT NULL,
  request_id varchar(255) NOT NULL,
  subject text NOT NULL,
  message longtext NOT NULL,
  CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (request_id)REFERENCES USERS(ID)
) ;


CREATE TABLE COUPAN_VALUE
(  #REFERRED BY ,REFERRED TO
	ID VARCHAR(37) NOT NULL,
	COUPON_TYPE_ID  VARCHAR(37)UNIQUE NOT NULL,
	AMOUNT  DOUBLE,	
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID) ,
	FOREIGN KEY (COUPON_TYPE_ID) REFERENCES COUPON_TYPE(ID)	
	);

CREATE TABLE user_requests_reply (
  id VARCHAR(37) NOT NULL,
  reply_id VARCHAR(37) NOT NULL,
  request_id VARCHAR(37) NOT NULL,
  user_id int(11) NOT NULL,
  message longtext NOT NULL,
  CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
  PRIMARY KEY (reply_id),  
  FOREIGN KEY (reply_id)REFERENCES USERS(ID),
  FOREIGN KEY (request_id)REFERENCES user_requests(ID)
) ;+++

CREATE TABLE REFERAL_DETAILS (
id VARCHAR(37) NOT NULL,
  referredBY varchar(37) NOT NULL,
  referred_to_email VARCHAR(400) UNIQUE NOT NULL,
  coupan_code VARCHAR(400) NOT NULL,
  REFERAL_STATE_ID  VARCHAR(37) NOT NULL,#REFERRAL ACCEPTED/PENDING
  CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (referredBY)REFERENCES USERS(ID)
) ;


CREATE TABLE COUPON_DETAILS (
  id VARCHAR(37) NOT NULL,
  COUPON_TYPE_ID  VARCHAR(37) NOT NULL,
  USER_ID varchar(255) NOT NULL,
  coupan_code VARCHAR(400) NOT NULL,
  amount DOUBLE ,  
  CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (USER_ID)REFERENCES USERS(ID),
  FOREIGN KEY (COUPON_TYPE_ID) REFERENCES COUPON_TYPE(ID)	
) ;


CREATE TABLE APP_SESSION (
  SESSION_ID VARCHAR(37) NOT NULL,
  USER_ID varchar(37) NOT NULL,
  LOGIN_DATE TIMESTAMP NOT NULL,
  LOGOUT_DATE TIMESTAMP NOT NULL,
  LAST_HIT_DATE TIMESTAMP NOT NULL,
  PRIMARY KEY (SESSION_ID),
  FOREIGN KEY (USER_ID)REFERENCES USERS(ID)
) ;
