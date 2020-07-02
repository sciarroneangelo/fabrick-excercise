CREATE TABLE creditor (
cr_id          	INTEGER auto_increment,
cr_name    		VARCHAR NOT NULL UNIQUE,
cr_account_code VARCHAR,
cr_bicCode 		VARCHAR,
cr_address 		VARCHAR,
cr_city 		VARCHAR,
cr_countryCode 	VARCHAR,
PRIMARY KEY  (cr_id),
UNIQUE KEY cr_name_UNIQUE (cr_name)

);
