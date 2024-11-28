-- Permiso para crear secuencias (necesario para las columnas con valores generados automáticamente)
GRANT CREATE SEQUENCE TO OT;

-- Permiso para crear y manejar restricciones (necesario para claves foráneas y restricciones de integridad)
GRANT ALTER ANY TABLE TO OT;

-- Permiso para crear vistas (algunas veces requerido cuando se usan ciertos tipos de referencias cruzadas)
GRANT CREATE VIEW TO OT;

SELECT * FROM OT.regions
