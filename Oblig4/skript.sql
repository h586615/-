	DROP SCHEMA IF EXISTS oblig4 CASCADE;
CREATE SCHEMA oblig4;
SET search_path = oblig4;

	CREATE TABLE Deltagerliste (
		mobil varchar(8) Primary key,
	    fornavn varchar (50),
		etternavn varchar(50),
		kjonn varchar(6),
		pwd_hash CHARACTER (64),
   		pwd_salt CHARACTER (32)
);

INSERT INTO Deltagerliste VALUES 
	('98674553','Tallah','Hussain','mann',-- passord: pass123)
	'2C8700BDBD964E483E98BF371D8810D47F10C539B508D0ACCCC4416282873F49',
	'A8EEEB37FAAC34B399D8E4CE4C1DC72B')
	('Pål', -- passord: pass123
		'2C8700BDBD964E483E98BF371D8810D47F10C539B508D0ACCCC4416282873F49',
		'A8EEEB37FAAC34B399D8E4CE4C1DC72B');