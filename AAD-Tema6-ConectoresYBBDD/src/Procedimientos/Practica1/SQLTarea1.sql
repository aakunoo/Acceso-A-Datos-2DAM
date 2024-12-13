CREATE OR REPLACE PROCEDURE nuevo_pedido(
    p_customer_id IN NUMBER,
    p_status IN VARCHAR2,
    p_salesman_id IN NUMBER,
    p_order_date IN DATE
)IS
BEGIN
    INSERT INTO orders (customer_id, status, salesman_id, order_date)
    VALUES (p_customer_id, p_status, p_salesman_id, p_order_date);
    
END nuevo_pedido;
/
