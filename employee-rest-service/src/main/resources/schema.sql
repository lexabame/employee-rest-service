DROP TABLE IF EXISTS EMPLOYEES;

CREATE TABLE EMPLOYEES (
	ID BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(50) NOT NULL,
	MIDDLE_INITIAL VARCHAR(225),
	LAST_NAME VARCHAR(225),
	EMAIL VARCHAR(100) NOT NULL UNIQUE,
	DATE_OF_BIRTH DATETIME NOT NULL,
	DATE_OF_EMPLOYMENT DATETIME NOT NULL,
	STATUS VARCHAR(50) NOT NULL
);