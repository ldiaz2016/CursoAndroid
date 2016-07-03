/*
CALL usp_Cliente_Registrar('DIAZ', 'ATOCHE','LUIS', '41027490', 'PUERTO MALABRIGO', 'SIMON BOLIVAR 406', '999999', 'luisdz@gmail.com')
*/
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_Cliente_Registrar`
(
	p_paterno varchar(25),
	p_materno varchar(25),
	p_nombre varchar(30),
	p_dni char(8) ,
	p_ciudad varchar(30),
	p_direccion varchar(50),
	p_telefono varchar(20),
	p_email varchar(50)
)

BEGIN	
    
	DECLARE codigoCliente char(5);	
    
    DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING, NOT FOUND
	BEGIN
		-- Cancela la transacción
		rollback;
		-- Retorna el estado
		SELECT - 1 AS state, 'Error al registrar el cliente.' AS message;
	END;
       
    -- Iniciar Transacción
	start transaction;
	
	-- Genera codigo nuevo
    SET codigoCliente = (SELECT RIGHT(CONCAT('00000', CAST((MAX(CAST(chr_cliecodigo AS UNSIGNED)) + 1) AS CHAR (5))), 5) COD FROM cliente);
    
    -- Inserta el registro
	INSERT INTO cliente
	(
		chr_cliecodigo,
		vch_cliepaterno,
		vch_cliematerno,
		vch_clienombre,
		chr_cliedni,
		vch_clieciudad,
		vch_cliedireccion,
		vch_clietelefono,
		vch_clieemail
	)
	VALUES
	(
		codigoCliente,
		p_paterno,
		p_materno,
		p_nombre,
		p_dni,
		p_ciudad,
		p_direccion,
		p_telefono,
		p_email
	);
	
    -- Confirma Transacción
	commit;

	-- Retorna el estado
	SELECT 1 AS state, 'Cliente Registrado' AS message;
END

