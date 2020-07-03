CREATE TABLE creditor (
cr_id          	BIGINT auto_increment,
cr_name    		VARCHAR NOT NULL UNIQUE,
cr_account_code VARCHAR,
cr_bic_code 	VARCHAR,
cr_address 		VARCHAR,
cr_city 		VARCHAR,
cr_countryCode 	VARCHAR,
PRIMARY KEY  (cr_id),
UNIQUE KEY cr_name_UNIQUE (cr_name)

);

CREATE TABLE transaction (
tr_id 				BIGINT auto_increment,
tr_operationId 		VARCHAR,
tr_accountingDate 	DATE,
tr_valueDate 		DATE,
tr_amount 			DOUBLE,
tr_currency 		VARCHAR,
tr_description 		VARCHAR,
tr_type 			VARCHAR,
PRIMARY KEY  (tr_id)
);

CREATE TABLE tr_type (
trt_id				BIGINT auto_increment,
trt_enumeration 	VARCHAR NOT NULL,
trt_value			VARCHAR NOT NULL UNIQUE,
PRIMARY KEY  (trt_id),
UNIQUE KEY trt_value_UNIQUE (trt_value)
)
