
-- =============================================
-- Creación de los Objetos de la Base de Datos
-- =============================================

CREATE TABLE Cliente (
	chr_cliecodigo       CHAR(5) NOT NULL,
	vch_cliepaterno      VARCHAR(25) NOT NULL,
	vch_cliematerno      VARCHAR(25) NOT NULL,
	vch_clienombre       VARCHAR(30) NOT NULL,
	chr_cliedni          CHAR(8) NOT NULL,
	vch_clieciudad       VARCHAR(30) NOT NULL,
	vch_cliedireccion    VARCHAR(50) NOT NULL,
	vch_clietelefono     VARCHAR(20) NULL,
	vch_clieemail        VARCHAR(50) NULL,
	CONSTRAINT PK_Cliente 
		PRIMARY KEY (chr_cliecodigo)
) ENGINE = INNODB ;