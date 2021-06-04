DROP TABLE IF EXISTS persons;

CREATE TABLE persons(
  id INT AUTO_INCREMENT,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  address VARCHAR(35) NOT NULL,
  city VARCHAR(15) NOT NULL,
  zip INT  NOT NULL,
  phone VARCHAR(20) NOT NULL,
  email VARCHAR(35) NOT NULL,
  PRIMARY KEY(first_name,last_name)
  );
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('John','Boyd','1509 Culver St','Culver',97451,'841-874-6512','jaboyd@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Jacob','Boyd','1509 Culver St','Culver',97451,'841-874-6513','drk@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Tenley','Boyd','1509 Culver St','Culver',97451,'841-874-6512','tenz@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Roger','Boyd','1509 Culver St','Culver',97451,'841-874-6512','jaboyd@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Felicia','Boyd','1509 Culver St','Culver',97451,'841-874-6544','jaboyd@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Jonanathan','Marrack','29 15th St','Culver',97451,'841-874-6513','drk@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Tessa','Carman','834 Binoc Ave','Culver',97451,'841-874-6512','tenz@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Peter','Duncan','644 Gershwin Cir','Culver',97451,'841-874-6512','jaboyd@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Foster','Shepard','748 Townings Dr','Culver',97451,'841-874-6544','jaboyd@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Tony','Cooper','112 Steppes Pl','Culver',97451,'841-874-6874','tcoop@ymail.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Lily','Cooper','489 Manchester St','Culver',97451,'841-874-9845','lily@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Sophia','Zemicks','892 Downing Ct','Culver',97451,'841-874-7878','soph@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Warren','Zemicks','892 Downing Ct','Culver',97451,'841-874-7512','ward@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Zach','Zemicks','892 Downing Ct','Culver',97451,'841-874-7512','zarc@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Reginold','Walker','908 73rd St','Culver',97451,'841-874-8547','reg@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Jamie','Peters','908 73rd St','Culver',97451,'841-874-7462','jpeter@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Ron','Peters','112 Steppes Pl','Culver',97451,'841-874-8888','jpeter@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Allison','Boyd','112 Steppes Pl','Culver',97451,'841-874-9888','aly@imail.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Brian','Stelzer','947 E. Rose Dr','Culver',97451,'841-874-7784','bstel@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Shawna','Stelzer','947 E. Rose Dr','Culver',97451,'841-874-7784','ssanw@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Kendrik','Stelzer','947 E. Rose Dr','Culver',97451,'841-874-7784','bstel@email.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Clive','Ferguson','748 Townings Dr','Culver',97451,'841-874-6741','clivfd@ymail.com');
INSERT INTO persons(first_name,last_name,address,city,zip,phone,email) VALUES ('Eric','Cadigan','951 LoneTree Rd','Culver',97451,'841-874-7458','gramps@email.com');



DROP TABLE IF EXISTS firestations;
CREATE TABLE firestations(
  id INT AUTO_INCREMENT,
   address VARCHAR(35)  PRIMARY KEY NOT NULL,
   station_number INTEGER  NOT NULL
);
INSERT INTO firestations(address,station_number) VALUES ('1509 Culver St',3);
INSERT INTO firestations(address,station_number) VALUES ('29 15th St',2);
INSERT INTO firestations(address,station_number) VALUES ('834 Binoc Ave',3);
INSERT INTO firestations(address,station_number) VALUES ('644 Gershwin Cir',1);
INSERT INTO firestations(address,station_number) VALUES ('748 Townings Dr',3);
INSERT INTO firestations(address,station_number) VALUES ('489 Manchester St',4);
INSERT INTO firestations(address,station_number) VALUES ('892 Downing Ct',2);
INSERT INTO firestations(address,station_number) VALUES ('908 73rd St',1);
INSERT INTO firestations(address,station_number) VALUES ('112 Steppes Pl',4);
INSERT INTO firestations(address,station_number) VALUES ('947 E. Rose Dr',1);
INSERT INTO firestations(address,station_number) VALUES ('951 LoneTree Rd',2);



DROP TABLE IF EXISTS medicalrecords;
CREATE TABLE medicalrecords(
  id INT AUTO_INCREMENT,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  birthdate VARCHAR(10)  NOT NULL,
  medications  VARCHAR(100),
  allergies    VARCHAR(80),
  PRIMARY KEY(first_name,last_name)
);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('John','Boyd','03/06/1984','aznol:350mg, hydrapermazol:100mg', 'nillacilan');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Jacob','Boyd','03/06/1989','pharmacol:5000mg, terazine:10mg, noznazol:250mg',NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Tenley','Boyd','02/18/2012',NULL,'peanut');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Roger','Boyd','09/06/2017',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Felicia','Boyd','01/08/1986','tetracyclaz:650mg','xilliathal');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Jonanathan','Marrack','01/03/1989',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Tessa','Carman','02/18/2012',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Peter','Duncan','09/06/2000',NULL,'shellfish');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Foster','Shepard','01/08/1980',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Tony','Cooper','03/06/1994','hydrapermazol:300mg, dodoxadin:30mg','shellfish');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Lily','Cooper','03/06/1994',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Sophia','Zemicks','03/06/1988','aznol:60mg, hydrapermazol:900mg, pharmacol:5000mg, terazine:500mg','peanut, shellfish, aznol');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Warren','Zemicks','03/06/1985',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Zach','Zemicks','03/06/2017',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Reginold','Walker','08/30/1979','thradox:700mg','illisoxian');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Jamie','Peters','03/06/1982',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Ron','Peters','04/06/1965',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Allison','Boyd','03/15/1965','aznol:200mg','nillacilan');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Brian','Stelzer','12/06/1975','ibupurin:200mg, hydrapermazol:400mg','nillacilan');
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Shawna','Stelzer','07/08/1980',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Kendrik','Stelzer','03/06/2014','noxidian:100mg, pharmacol:2500mg',NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Clive','Ferguson','03/06/1994',NULL,NULL);
INSERT INTO medicalrecords(first_name,last_name,birthdate,medications,allergies) VALUES ('Eric','Cadigan','08/06/1945','tradoxidine:400mg',NULL);



