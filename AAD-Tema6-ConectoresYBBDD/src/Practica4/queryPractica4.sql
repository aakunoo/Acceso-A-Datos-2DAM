SELECT p.product_name, pc.category_name, oi.unit_price 
FROM order_items oi 
INNER JOIN products p ON oi.product_id = p.product_id 
INNER JOIN product_categories pc ON p.category_id = pc.category_id
