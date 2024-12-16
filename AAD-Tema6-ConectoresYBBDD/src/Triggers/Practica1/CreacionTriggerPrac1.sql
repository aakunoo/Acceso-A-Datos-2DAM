CREATE OR REPLACE TRIGGER trg_no_cantidad_negativa
BEFORE UPDATE OF quantity ON inventories -- se activa antes de la actualización de 'quantity'
FOR EACH ROW
BEGIN
    IF :NEW.quantity < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'La cantidad no puede ser negativa'); -- generar error
    END IF;
END trg_no_cantidad_negativa;
/
