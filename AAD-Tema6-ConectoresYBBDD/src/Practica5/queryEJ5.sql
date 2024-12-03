SELECT customer_id, 
SUM(unit_price * quantity) AS total_ventas 
FROM order_items 
JOIN orders ON order_items.order_id = orders.order_id 
GROUP BY customer_id