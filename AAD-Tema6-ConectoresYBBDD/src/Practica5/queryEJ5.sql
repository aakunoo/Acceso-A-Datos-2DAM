SELECT 
    c.name AS customer_name,
    SUM(oi.quantity * oi.unit_price) AS total_sales
FROM 
    orders o
INNER JOIN customers c ON o.customer_id = c.customer_id
INNER JOIN order_items oi ON o.order_id = oi.order_id
GROUP BY 
    c.name
HAVING 
    SUM(oi.quantity * oi.unit_price) > 10000
ORDER BY 
    total_sales DESC;