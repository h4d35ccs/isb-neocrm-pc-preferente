create Schema DERBY;
CREATE TABLE PC_ACC_REACT (
  TIPOPERS varchar(255) NOT NULL,
  CODPERS integer NOT NULL,
  CODOFERTA varchar(255) DEFAULT NULL,
  DESC_CORTA varchar(255) DEFAULT NULL,
  DESC_LARGA varchar(255) DEFAULT NULL,
  IDEMPR varchar(255) DEFAULT NULL,
  IMAGEN varchar(255) DEFAULT NULL,
  PRIMARY KEY (TIPOPERS,CODPERS)
);

CREATE TABLE PC_ACC_PREF (
  TIPOPERS varchar(255) NOT NULL,
  CODPERS integer NOT NULL,
  CAMPAGNA varchar(255) DEFAULT NULL,
  CODCLASE varchar(255) DEFAULT NULL,
  IDEMPR varchar(255) DEFAULT NULL,
  IDSUBEVE varchar(255) DEFAULT NULL,
  IDTIPEVE varchar(255) DEFAULT NULL,
  IMAGEN varchar(255) DEFAULT NULL,
  PRIMARY KEY (TIPOPERS,CODPERS)
);
