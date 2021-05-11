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
