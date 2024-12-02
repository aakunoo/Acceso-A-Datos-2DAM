-- Es lo que hay que poner para crear luego Users.
alter session set "_ORACLE_SCRIPT"=true;

-- Crear Usuario
CREATE USER OT 
IDENTIFIED BY oracle123
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
PROFILE DEFAULT
ACCOUNT UNLOCK;

-- Darle permisos al Usuario.
GRANT create session TO OT; -- Damos el permiso de "create session" al user "OT"
ALTER USER OT QUOTA UNLIMITED ON USERS; -- Cuota ilimitada en el tablespace USERS.
GRANT create table TO OT; -- Damos el permiso de "create table" al user "OT"

-- Para acceder a TODO de la tabla indicada.
SELECT * FROM OT.contacts


-- Permiso para crear secuencias (necesario para las columnas con valores generados automáticamente)
GRANT CREATE SEQUENCE TO OT;

-- Permiso para crear y manejar restricciones (necesario para claves foráneas y restricciones de integridad)
GRANT ALTER ANY TABLE TO OT;

-- Permiso para crear vistas (algunas veces requerido cuando se usan ciertos tipos de referencias cruzadas)
GRANT CREATE VIEW TO OT;

SELECT * FROM OT.regions

