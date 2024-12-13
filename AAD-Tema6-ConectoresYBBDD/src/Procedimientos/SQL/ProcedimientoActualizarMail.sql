CREATE OR REPLACE PROCEDURE actualizar_email(
    id_empleado IN NUMBER,
    email_nuevo IN VARCHAR2
) IS
BEGIN
    UPDATE employees
    SET email = email_nuevo
    WHERE employee_id = id_empleado;
END actualizar_email;
/

BEGIN -- No hacer execute.
    actualizar_email(5,'dam@contacto.com');
    DBMS_OUTPUT.PUT_LINE('Correo cambiado');
END;
/
