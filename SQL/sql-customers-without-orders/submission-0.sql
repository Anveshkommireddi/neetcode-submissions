-- Write your query below
select cust.name from customers cust
where cust.id not in (select distinct customer_id from orders);