CREATE TABLE `users` (
  `iduser` int(11) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL default '',
  `password` varchar(45) NOT NULL default '',
   `nume` varchar(45) NOT NULL default '',
  `telefon` varchar(45) NOT NULL default '',
  `adresa` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`iduser`)
  );


  --insert an user

INSERT INTO `cabinet` . `users`
(
`username`,
`password`,
`nume`,
`telefon`,
`adresa`)
VALUES
(

'andrei',
'parola',
'andrei1',
'0773993219',
'alle olanesti');


CREATE TABLE `medicament` (
                            `denumire` varchar(45) NOT NULL,
                            PRIMARY KEY (`denumire`)
);

INSERT INTO `cabinet` . `medicament`
(`denumire`
)
VALUES
(

  'algocalmin'
  );


CREATE TABLE `pacient` (
                         `idpacient` int(11) NOT NULL AUTO_INCREMENT,
                         `nume` varchar(45) DEFAULT NULL,
                         `telefon` varchar(45) DEFAULT NULL,
                         `adresa` varchar(45) DEFAULT NULL,
                         `varsta` int(11) DEFAULT NULL,
                         PRIMARY KEY (`idpacient`)
);

INSERT INTO `cabinet` . `pacient`
(`nume`,
 `telefon`,
 `adresa`,
 `varsta`
)
VALUES
(

  'andrei',
 '0773993219',
 'aleea olanesti',
 11
);

